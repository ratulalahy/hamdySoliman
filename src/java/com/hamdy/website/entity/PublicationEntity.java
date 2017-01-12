package java.com.hamdy.website.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ratul
 */
public class PublicationEntity implements Serializable {
    private String title;
    private String uri;
    private List<AuthorEntity> authors;
    private String publisher;
    private String publicationDetails;
    private String typeOfPublication;
    private String dateOfPublication;
    private List<String> keywords;
      
    private PropertyChangeSupport propertySupport;
    
    public PublicationEntity() {
        propertySupport = new PropertyChangeSupport(this);
    }
      
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDetails() {
        return publicationDetails;
    }

    public void setPublicationDetails(String publicationDetails) {
        this.publicationDetails = publicationDetails;
    }

    public String getTypeOfPublication() {
        return typeOfPublication;
    }

    public void setTypeOfPublication(String typeOfPublication) {
        this.typeOfPublication = typeOfPublication;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public PropertyChangeSupport getPropertySupport() {
        return propertySupport;
    }

    public void setPropertySupport(PropertyChangeSupport propertySupport) {
        this.propertySupport = propertySupport;
    }
    
}
