package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.User;
import Tendry.e_upgrade.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService service;

    @GetMapping
    public List<User> getAllUsers(){
        return service.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable int id){
        return service.findUserById(id);
    }

    @GetMapping("/name/{name}")
    public List<User> findUserByName(@PathVariable String name) throws SQLException {
        return service.findUserByName(name);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user ) {
        return service.insert(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        boolean deleted = service.delete(id);
        if (deleted) {
            return new ResponseEntity<>("user with id " + id + " deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("user with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        User updated = service.update(updatedUser);

        if (updated != null) {
            return new ResponseEntity<>(id + " has been updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
