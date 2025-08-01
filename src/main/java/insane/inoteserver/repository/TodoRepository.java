package insane.inoteserver.repository;

import insane.inoteserver.model.Todo;
import insane.inoteserver.model.TodoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, TodoId> {
    List<Todo> findByUser(String user);
}