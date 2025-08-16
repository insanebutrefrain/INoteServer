package insane.inoteserver.controller;

import insane.inoteserver.model.Task;
import insane.inoteserver.model.TaskId;
import insane.inoteserver.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iNote/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/add")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestBody Task task) {
        TaskId id = new TaskId(task.getCreateTime(), task.getUser());
        taskRepository.deleteById(id);
    }

    @GetMapping("/getAll/{user}")
    public List<Task> getAllTasks(@PathVariable String user) {
        return taskRepository.findByUser(user);
    }
}
