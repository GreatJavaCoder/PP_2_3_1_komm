package web.repository;

import com.mysql.cj.PreparedQuery;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public User getUser(int id) {
        User user = (User) entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void editUser(int id, User updatedUser) {
        User userToBeUpdated = getUser(id);
        userToBeUpdated.setHeight(updatedUser.getHeight());
        userToBeUpdated.setName(updatedUser.getName());
        entityManager.merge(userToBeUpdated);
    }

    @Transactional
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}
