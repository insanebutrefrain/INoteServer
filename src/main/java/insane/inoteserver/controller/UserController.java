package insane.inoteserver.controller;

import insane.inoteserver.model.User;
import insane.inoteserver.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("iNote/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @PutMapping("/delete")
    public Boolean deleteUser(@RequestBody User user) {
        try {
            userRepository.deleteById(user.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @GetMapping("/get/{id}")
    public Optional<User> findUser(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @GetMapping("/get/{id}/{psw}")
    public Optional<User> findUser(@PathVariable String id, @PathVariable String psw) {
        return Optional.ofNullable(userRepository.findByIdAndPassword(id, psw));
    }

    @GetMapping("/getAll")
    public List<User> getAllUser() {
        return userRepository.findAll();

    }
}