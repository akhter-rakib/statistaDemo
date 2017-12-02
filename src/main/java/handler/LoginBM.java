/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import com.rakib.dao.UserDao;
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
        User user = userDao.loginUser(email, password);
        System.out.println("****************************"+user.getPassword());
        if(user!=null){
            System.out.println("***********************"+user.getEmail());
        }else{
            
        }
        return null;
    }

    public LoginBM() {
    }

}
