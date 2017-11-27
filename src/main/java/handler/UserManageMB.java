/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import com.rakib.doa.UserManageDao;
import com.rakib.model.User;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rakib
 */
@ManagedBean
@ViewScoped
public class UserManageMB implements Serializable{

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public List<User> userList() {
        UserManageDao userManageDao = new UserManageDao();
        List<User> users = userManageDao.allRegisteredUsers();
        return users;
    }
    
   public String edit(int userId) {
        System.out.println("*********************"+userId);
        UserManageDao userManageDao = new UserManageDao();
        User editUser = userManageDao.editUser(userId);
        System.out.println("**************"+editUser.getEmail());
         System.out.println("**************"+editUser.getFirstname());
        sessionMap.put("editUser", editUser);
        return "edit";
    }

}
