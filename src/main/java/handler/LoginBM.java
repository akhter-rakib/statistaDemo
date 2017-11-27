/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import com.rakib.doa.UserDao;
import com.rakib.model.User;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rakib
 */
@ManagedBean
@SessionScoped
public class LoginBM {

    private String email;
    private String password;

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

    public String login() {
        UserDao userDao = new UserDao();
        boolean userExist = userDao.loginUser(email, password);
        return null;
    }

    public LoginBM() {
    }

}
