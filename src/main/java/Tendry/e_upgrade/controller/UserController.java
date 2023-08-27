package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.User;
import Tendry.e_upgrade.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return service.findAllUser();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findUserById(@PathVariable int id){
        return service.findUserById(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user ) {
        return service.insert(user);
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id , HttpStatus done , HttpStatus fail) {
        Boolean deletedUser = service.delete(id);
        if (deletedUser != null && deletedUser.booleanValue()) {
            return new ResponseEntity<>( done.OK);
        } else {
            return new ResponseEntity<>(fail.NOT_FOUND);
        }
    }

    @PutMapping("/updateUser/{id}")
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
