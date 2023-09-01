package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public interface UserDAO {
    public List<User> getAllUsers();
    public User getUser(int id);
    public void addUser(User user);
    public void editUser(int id, User user);
    public void deleteUser(int id);
}
