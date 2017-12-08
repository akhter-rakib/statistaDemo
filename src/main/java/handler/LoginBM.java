/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import com.rakib.dao.UserDao;
import com.rakib.model.UserForm;
import com.rakib.model.UserRole;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;
import session.SessionUtils;

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
        UserForm user = userDao.loginUser(email, password);
        if (user != null) {
            Iterator<UserRole> iterator = user.getUserRoles().iterator();
            while (iterator.hasNext()) {
                UserRole roleType = iterator.next();
                System.out.println("************************" + roleType.getRole().getRoleType());
            }
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("user", user);
            return "success?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Email and Passowrd", "Please enter correct Email and Password"));
            return "loginForm?faces-redirect=true";
        }

    }

    public LoginBM() {
    }

}
