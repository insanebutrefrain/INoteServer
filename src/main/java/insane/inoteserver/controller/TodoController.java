package insane.inoteserver.controller;

import insane.inoteserver.model.Todo;
import insane.inoteserver.model.TodoId;
import insane.inoteserver.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/iNote/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/add")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.saveAndFlush(todo);
    }

    @PutMapping("/update")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoRepository.saveAndFlush(todo);
    }

    @DeleteMapping("/delete")
    public void deleteTodo(@RequestBody Todo todo) {
        TodoId id = new TodoId(todo.getCreateTime(), todo.getUser());

        todoRepository.deleteById(id);
    }

    @GetMapping("/getAll/{user}")
    public List<Todo> getAllTodos(@PathVariable String user) {
        return todoRepository.findByUser(user);
    }
}
