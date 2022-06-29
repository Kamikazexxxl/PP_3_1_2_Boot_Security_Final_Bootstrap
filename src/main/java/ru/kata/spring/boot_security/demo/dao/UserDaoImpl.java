package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> typedQuery = entityManager.createQuery("from User", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery("select user from User user where user.name=:name", User.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }
}

