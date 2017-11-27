/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakib.doa;

import com.rakib.model.User;
import com.rakib.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rakib
 */
public class UserManageDao {

    public List<User> allRegisteredUsers() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<User> list = null;
        String hql = "from User";
        Query query = session.createQuery(hql);
        list = query.list();
        session.close();
        return list;
    }

    public User editUser(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        User user=new User();
        session.beginTransaction();
        user = (User) session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

}
