/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakib.dao;

import com.rakib.model.Role;
import com.rakib.model.User;
import com.rakib.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rakib
 */
public class UserDao {

 
    public void SaveUser(User user) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        
//        System.out.println("*******************Doa F************************************");
//        Transaction tx = null;
//        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
           // tx = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
        } finally {
            session.flush();
            session.close();
        }
        System.out.println("******************Done*****************");
    }

    public User loginUser(String email, String password) {
        //  boolean userFound = false;
        User user = null;
        Transaction tx = null;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", email));
            criteria.add(Restrictions.eq("password", password));
            List list = criteria.list();
            System.out.println("*******************" + email);
            if ((list != null) && (list.size() > 0)) {
                // userFound = true;
                user = (User) criteria.list().get(0);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }

    public List<Role> getRoles() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Role.class);
        return criteria.list();
    }

}
