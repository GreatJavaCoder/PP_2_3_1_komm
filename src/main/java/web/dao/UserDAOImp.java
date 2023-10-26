package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(int id) {
        User user = (User) entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void editUser(int id, User updatedUser) {
        User userToBeUpdated = getUser(id);
        userToBeUpdated.setHeight(updatedUser.getHeight());
        userToBeUpdated.setName(updatedUser.getName());
        entityManager.merge(userToBeUpdated);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}
