package com.rakib.model;
// Generated Nov 15, 2017 3:52:42 PM by Hibernate Tools 4.3.1



/**
 * Userrole generated by hbm2java
 */
public class Userrole  implements java.io.Serializable {


     private Integer id;
     private Project project;
     private Role role;
     private User user;

    public Userrole() {
    }

    public Userrole(Project project, Role role, User user) {
       this.project = project;
       this.role = role;
       this.user = user;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }




}


