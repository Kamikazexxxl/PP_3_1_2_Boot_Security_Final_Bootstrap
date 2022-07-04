package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

        @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("Выполняется делете юзер");
        entityManager.createQuery("delete from User user where user.id = ?1")
                .setParameter(1, id)
                .executeUpdate();
        System.out.println("Метод делете юзер выполнен");
    }

    @Override
    public User getUser(int id) {
        return entityManager.createQuery("select u from User u where u.id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery("select user from User user where user.name=:name", User.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public void editUser(int id, String name, String surname, int age, String password) {
        User user = getUser(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setPassword(password);
        entityManager.merge(user);
    }
}

