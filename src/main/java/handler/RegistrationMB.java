/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import com.rakib.dao.UserDao;
import com.rakib.model.Project;
import com.rakib.model.User;
import com.rakib.model.Userrole;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rakib
 */
@ManagedBean
@SessionScoped
public class RegistrationMB implements Serializable {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Set<Project> projects = new HashSet<Project>(0);
    private Set<Userrole> userroles = new HashSet<Userrole>(0);

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Userrole> getUserroles() {
        return userroles;
    }

    public void setUserroles(Set<Userrole> userroles) {
        this.userroles = userroles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String saveUser() {
        UserDao userDao = new UserDao();
        System.out.println("*******************MB*******************"+getFirstname());
        User user = new User(getFirstname(), getLastname(), getEmail(), getPassword());
        userDao.SaveUser(user);
        return "loginForm";
    }

}
