/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Z
 */
@Entity
@Table(name = "rayon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rayon.findAll", query = "SELECT r FROM Rayon r"),
    @NamedQuery(name = "Rayon.findById", query = "SELECT r FROM Rayon r WHERE r.id = :id"),
    @NamedQuery(name = "Rayon.findByDescription", query = "SELECT r FROM Rayon r WHERE r.description = :description"),
    @NamedQuery(name = "Rayon.findByName", query = "SELECT r FROM Rayon r WHERE r.name = :name"),
    @NamedQuery(name = "Rayon.findByShortName", query = "SELECT r FROM Rayon r WHERE r.shortName = :shortName")})
public class Rayon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "short_name")
    private String shortName;
    
    @Size(max = 255)
    @Column(name = "path")
    private String path;
    
    @Column(name = "data")
    private byte[] data;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @OneToMany(mappedBy = "rayon")
    private Set<Category> categories;

    public Rayon() {
    }

    public Rayon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
    
   

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
     public Set<Category> getCategories() {
        return categories;
    }
    
    public void clone(Rayon rayon){
        if (rayon == null) return;
        this.data = rayon.getData();
        this.dateCreation = rayon.getDateCreation();
        this.name = rayon.getName();
        this.shortName = rayon.getShortName();
        this.path = rayon.getName();
        this.description = rayon.getDescription();
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rayon)) {
            return false;
        }
        Rayon other = (Rayon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.Rayonproduit[ id=" + id + " ]";
    }
    
}
