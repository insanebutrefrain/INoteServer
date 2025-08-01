package insane.inoteserver.controller;

import insane.inoteserver.model.TaskList;
import insane.inoteserver.model.TaskListId;
import insane.inoteserver.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("iNote/taskList")
public class TaskListController {

    @Autowired
    private TaskListRepository taskListRepository;

    @PostMapping("/add")
    public TaskList createTaskList(@RequestBody TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @PutMapping("/update")
    public TaskList updateTaskList(@RequestBody TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @DeleteMapping("/delete")
    public void deleteTaskList(@RequestBody TaskList taskList) {
        TaskListId id = new TaskListId(taskList.getCreateTime(), taskList.getUser());
        taskListRepository.deleteById(id);
    }

    @GetMapping("/getAll/{user}")
    public List<TaskList> getAllTaskLists(@PathVariable String user) {
        return taskListRepository.findByUser(user);
    }
}