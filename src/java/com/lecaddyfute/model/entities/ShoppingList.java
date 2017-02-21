/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Z
 */
@Entity
@Table(name = "shopping_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingList.findAll", query = "SELECT s FROM ShoppingList s"),
    @NamedQuery(name = "ShoppingList.findById", query = "SELECT s FROM ShoppingList s WHERE s.id = :id"),
    @NamedQuery(name = "ShoppingList.findByIdProduct", query = "SELECT s FROM ShoppingList s WHERE s.idProduct = :idProduct"),
    @NamedQuery(name = "ShoppingList.findByPrice", query = "SELECT s FROM ShoppingList s WHERE s.price = :price"),
    @NamedQuery(name = "ShoppingList.findByQuantity", query = "SELECT s FROM ShoppingList s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "ShoppingList.findByDateCreation", query = "SELECT s FROM ShoppingList s WHERE s.dateCreation = :dateCreation"),
    @NamedQuery(name = "ShoppingList.findByDateModification", query = "SELECT s FROM ShoppingList s WHERE s.dateModification = :dateModification"),
    @NamedQuery(name = "ShoppingList.findByStatus", query = "SELECT s FROM ShoppingList s WHERE s.status = :status")})
public class ShoppingList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private int idProduct;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Size(max = 8)
    @Column(name = "status")
    private String status;

    public ShoppingList() {
    }

    public ShoppingList(Integer id) {
        this.id = id;
    }

    public ShoppingList(Integer id, int idProduct, Date dateCreation) {
        this.id = id;
        this.idProduct = idProduct;
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof ShoppingList)) {
            return false;
        }
        ShoppingList other = (ShoppingList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.ShoppingList[ id=" + id + " ]";
    }
    
}
