/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakib.dao;

import com.rakib.model.Role;
import com.rakib.model.UserForm;
import com.rakib.util.NewHibernateUtil;
//import com.rakib.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rakib
 */
public class UserManageDao {

    public List<UserForm> allRegisteredUsers() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserForm.class);
        return criteria.list();
    }

    public UserForm editUser(Integer id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserForm.class);
        criteria.add(Restrictions.eq("id", id));
        return (UserForm) criteria.uniqueResult();
    }

    public List<Role> getRoles() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Role.class);
        return criteria.list();
    }

    public void updateUser(UserForm user) {
        NewHibernateUtil.getSessionFactory().getCurrentSession().merge(user);
    }

    public void deleteUser(UserForm user) {

    }

}
