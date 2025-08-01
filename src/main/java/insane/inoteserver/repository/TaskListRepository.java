package insane.inoteserver.repository;

import insane.inoteserver.model.TaskList;
import insane.inoteserver.model.TaskListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, TaskListId> {
    List<TaskList> findByUser(String user);
}