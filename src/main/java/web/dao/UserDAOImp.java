package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Component
public class UserDAOImp implements UserDAO{
    private UserRepository userRepository;

    public UserDAOImp() {
    }

    @Autowired
    public UserDAOImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void editUser(int id, User user) {
        userRepository.editUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }
}
