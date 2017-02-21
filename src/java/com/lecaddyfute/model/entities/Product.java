/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
   
    @NamedQuery(name = "Product.findByDesignation", query = "SELECT p FROM Product p WHERE p.designation = :designation"),
    @NamedQuery(name = "Product.findByBrand", query = "SELECT p FROM Product p WHERE p.brand = :brand"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByMainImage", query = "SELECT p FROM Product p WHERE p.mainImage = :mainImage"),
    @NamedQuery(name = "Product.findByImageThum1", query = "SELECT p FROM Product p WHERE p.imageThum1 = :imageThum1"),
    @NamedQuery(name = "Product.findByImageThum2", query = "SELECT p FROM Product p WHERE p.imageThum2 = :imageThum2"),
    @NamedQuery(name = "Product.findByImageThum3", query = "SELECT p FROM Product p WHERE p.imageThum3 = :imageThum3"),
    @NamedQuery(name = "Product.findByImageThum4", query = "SELECT p FROM Product p WHERE p.imageThum4 = :imageThum4")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonBackReference
    private Category category;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "designation")
    private String designation;
  
    @Column(name = "quantity")
    private String quantity;
    
    @Size(max = 150)
    @Column(name = "brand")
    private String brand;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "main_image")
    private String mainImage;
    @Size(max = 255)
    @Column(name = "image_thum1")
    private String imageThum1;
    @Size(max = 255)
    @Column(name = "image_thum2")
    private String imageThum2;
    @Size(max = 255)
    @Column(name = "image_thum3")
    private String imageThum3;
    @Size(max = 255)
    @Column(name = "image_thum4")
    private String imageThum4;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
   

    
    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, Category category, String designation) {
        this.id = id;
        this.category = category;
        this.designation = designation;
    }
    public Product(Product product) {
        if (product == null)  return;
        this.id = product.getId();
        this.category = product.getCategory();
        this.designation = product.getDesignation();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    
   
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getImageThum1() {
        return imageThum1;
    }

    public void setImageThum1(String imageThum1) {
        this.imageThum1 = imageThum1;
    }

    public String getImageThum2() {
        return imageThum2;
    }

    public void setImageThum2(String imageThum2) {
        this.imageThum2 = imageThum2;
    }

    public String getImageThum3() {
        return imageThum3;
    }

    public void setImageThum3(String imageThum3) {
        this.imageThum3 = imageThum3;
    }

    public String getImageThum4() {
        return imageThum4;
    }

    public void setImageThum4(String imageThum4) {
        this.imageThum4 = imageThum4;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    
    public void clone(Product product){
        if (product == null) return ;
        this.brand = product.getBrand();
        this.dateCreation = product.getDateCreation();
        this.description = product.getDescription();
        this.designation = product.getDesignation();
        this.imageThum1 = product.getImageThum1();
        this.imageThum2 = product.getImageThum2();
        this.imageThum3 = product.getImageThum3();
        this.imageThum4 = product.getImageThum4();
        this.mainImage = product.getMainImage();
        this.quantity = product.getQuantity();
        if (this.category == null){
            this.category = new Category();
        }
        this.category.clone(product.getCategory());
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.Product[ id=" + id + " ]"
                           +  "Product[ id=" +brand +"]\n"
                           +  "Product[ description=" +description +"]\n"
                           +  "Product[ designation=" +designation +"]\n"
                           +  "Product[ mainImage=" + mainImage +"]\n"
                           +  "Product[ quantity=" + quantity+"]\n"
                           +  "Product[ brand=" + brand+"]\n"
                           + "Product[ imageThum1=" + imageThum1+"]\n"
                           +  "Product[ imageThum2 =" +imageThum2 +"]\n"
                           +  "Product[ imageThum3=" + imageThum3 +"]\n"
                           +  "Product[ imageThum4 =" + imageThum4+"]\n";
      
    }
    
}
