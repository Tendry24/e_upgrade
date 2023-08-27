package Tendry.e_upgrade.services;

import Tendry.e_upgrade.models.User;
import Tendry.e_upgrade.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class UserService {
    private UserRepository user;

    public List<User> findAllUser(){
        try{
            return user.findAllUser();
        }catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }

    public Optional<User> findUserById(int id){
        try{
            return user.findUserById(id);
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }

    public User insert(User toInsert){
        try{
            this.user.insert(toInsert);
            return toInsert;
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }


    public Boolean delete(int toDelete){
        try {
            this.user.delete(toDelete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public User update(User updatedUser) {
        try {
            this.user.update(updatedUser);
            return updatedUser;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating category");
        }
    }
}
