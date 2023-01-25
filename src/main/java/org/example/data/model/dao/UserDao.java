package org.example.data.model.dao;

import org.example.data.model.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List userList = session.createQuery("from users").list();
        return userList;
    }

    public UserEntity getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity user = (UserEntity) session.load(UserEntity.class, new Integer(id));
        return user;
    }

    public UserEntity addUser(UserEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }

    public void updateUser(UserEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity p = (UserEntity) session.load(UserEntity.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }


}
