package insane.inoteserver.repository;

import insane.inoteserver.model.Task;
import insane.inoteserver.model.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, TaskId> {
    List<Task> findByUser(String user);
}