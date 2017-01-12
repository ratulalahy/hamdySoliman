package java.com.hamdy.website.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ratul
 */
public class AuthorEntity implements Serializable {
    
    private String authorName;
    
   
    private PropertyChangeSupport propertySupport;
    
    public AuthorEntity() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public AuthorEntity(String authorName)
    {
        this.authorName = authorName;
    }
        
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
}
