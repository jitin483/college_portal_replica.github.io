package com.developer;

import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 */
public class Contactinfo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String subject;
    private String message;
    
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getsubject() {
        return subject;
    }
    public void setsubject(String subject) {
        this.subject = subject;
    }
    public String getmessage() {
        return message;
    }
    public void setmessage(String message) {
        this.message = message;
    }
    
}