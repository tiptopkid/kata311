package com.kata.spring_boot_kata311.dao;

import com.kata.spring_boot_kata311.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



import java.util.List;


@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.persist(user);

    }

    @Override
    public List<User> listUsers() {

        Session session = entityManager.unwrap(Session.class);
        return session.createQuery(
                        "select user from User user", User.class)
                .getResultList();
    }

//    @Override
    public User show(int id) {
        return entityManager.createQuery(
                        "select user from User user where id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Override
    public void update(int id, User updatedUser) {
        User userToUpdate = show(id);
        userToUpdate.setFirstName(updatedUser.getFirstName());
        userToUpdate.setCountry(updatedUser.getCountry());
        userToUpdate.setAge(updatedUser.getAge());

    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }

}
