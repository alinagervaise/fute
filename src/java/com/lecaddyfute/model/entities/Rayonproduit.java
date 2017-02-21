/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Z
 */
@Entity
@Table(name = "rayonproduit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rayonproduit.findAll", query = "SELECT r FROM Rayonproduit r"),
    @NamedQuery(name = "Rayonproduit.findById", query = "SELECT r FROM Rayonproduit r WHERE r.id = :id"),
    @NamedQuery(name = "Rayonproduit.findByDescription", query = "SELECT r FROM Rayonproduit r WHERE r.description = :description"),
    @NamedQuery(name = "Rayonproduit.findByName", query = "SELECT r FROM Rayonproduit r WHERE r.name = :name"),
    @NamedQuery(name = "Rayonproduit.findByShortName", query = "SELECT r FROM Rayonproduit r WHERE r.shortName = :shortName")})
public class Rayonproduit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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

    public Rayonproduit() {
    }

    public Rayonproduit(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rayonproduit)) {
            return false;
        }
        Rayonproduit other = (Rayonproduit) object;
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
