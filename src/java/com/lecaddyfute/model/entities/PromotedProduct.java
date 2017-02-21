/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Z
 */
@Entity
@Table(name = "promoted_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromotedProduct.findAll", query = "SELECT p FROM PromotedProduct p"),
    @NamedQuery(name = "PromotedProduct.findById", query = "SELECT p FROM PromotedProduct p WHERE p.id = :id"),
//    @NamedQuery(name = "PromotedProduct.findByIdProduit", query = "SELECT p FROM PromotedProduct p WHERE p.idProduit = :idProduit"),
//    @NamedQuery(name = "PromotedProduct.findByIdShop", query = "SELECT p FROM PromotedProduct p WHERE p.idShop = :idShop"),
    @NamedQuery(name = "PromotedProduct.findByPrice", query = "SELECT p FROM PromotedProduct p WHERE p.price = :price"),
    @NamedQuery(name = "PromotedProduct.findByDateCreation", query = "SELECT p FROM PromotedProduct p WHERE p.dateCreation = :dateCreation"),
    @NamedQuery(name = "PromotedProduct.findByDateExpiration", query = "SELECT p FROM PromotedProduct p WHERE p.dateExpiration = :dateExpiration")})
public class PromotedProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
  
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produit", referencedColumnName = "id")
    private Product product;
   
   
    @ManyToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_shop")
    private Shop shop;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "deal")
    private Double deal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @Column(name = "date_expiration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExpiration;

    public PromotedProduct() {
    }

    public PromotedProduct(Integer id) {
        this.id = id;
    }

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Double getDeal() {
        return deal;
    }

    public void setDeal(Double deal) {
        this.deal = deal;
    }
    
    
    public void clone(PromotedProduct product){
        if (product == null) return;
        this.dateCreation = product.getDateCreation();
        this.dateExpiration = product.getDateExpiration();
        this.deal = product.getDeal();
        this.price = product.getPrice();
        if (this.product == null){
            this.product = new Product();
        }
        
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromotedProduct)) {
            return false;
        }
        PromotedProduct other = (PromotedProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.PromotedProduct[ id=" + id + " ]\n"
                +"PromotedProduct[ deal=" + deal + " ]\n"
                +"PromotedProduct[ price=" + price + " ]\n"
                +"PromotedProduct[ product=" + product + " ]\n"
                +"PromotedProduct[ shop=" + shop + " ]\n"
                ;
    }
    
}
