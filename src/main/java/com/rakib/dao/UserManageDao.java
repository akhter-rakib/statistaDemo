/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakib.dao;

import com.rakib.model.UserForm;
//import com.rakib.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Rakib
 */
public class UserManageDao {
    private SessionFactory sessionFactory;
 public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<UserForm> allRegisteredUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<UserForm> list = null;
        String hql = "from User";
        Query query = session.createQuery(hql);
        list = query.list();
        session.close();
        return list;
    }

    public UserForm editUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserForm user=new UserForm();
        session.beginTransaction();
        user = (UserForm) session.get(UserForm.class, id);
        session.getTransaction().commit();
        return user;
    }

}
