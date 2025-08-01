package insane.inoteserver.repository;

import insane.inoteserver.model.Note;
import insane.inoteserver.model.NoteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, NoteId> {
    List<Note> findByUser(String user);
}