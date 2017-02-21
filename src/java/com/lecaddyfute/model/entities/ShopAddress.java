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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "shop_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShopAddress.findAll", query = "SELECT s FROM ShopAddress s"),
    @NamedQuery(name = "ShopAddress.findById", query = "SELECT s FROM ShopAddress s WHERE s.id = :id"),
    @NamedQuery(name = "ShopAddress.findByIdShop", query = "SELECT s FROM ShopAddress s WHERE s.idShop = :idShop"),
    @NamedQuery(name = "ShopAddress.findByAddressLine1", query = "SELECT s FROM ShopAddress s WHERE s.addressLine1 = :addressLine1"),
    @NamedQuery(name = "ShopAddress.findByAdressLine2", query = "SELECT s FROM ShopAddress s WHERE s.adressLine2 = :adressLine2"),
    @NamedQuery(name = "ShopAddress.findByZipCode", query = "SELECT s FROM ShopAddress s WHERE s.zipCode = :zipCode"),
    @NamedQuery(name = "ShopAddress.findByNeighborhood", query = "SELECT s FROM ShopAddress s WHERE s.neighborhood = :neighborhood"),
    @NamedQuery(name = "ShopAddress.findByCity", query = "SELECT s FROM ShopAddress s WHERE s.city = :city"),
    @NamedQuery(name = "ShopAddress.findByCountry", query = "SELECT s FROM ShopAddress s WHERE s.country = :country"),
    @NamedQuery(name = "ShopAddress.findByCellphone", query = "SELECT s FROM ShopAddress s WHERE s.cellphone = :cellphone"),
    @NamedQuery(name = "ShopAddress.findByPhone", query = "SELECT s FROM ShopAddress s WHERE s.phone = :phone")})
public class ShopAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address_line1")
    private String addressLine1;
    @Size(max = 50)
    @Column(name = "adress_line2")
    private String adressLine2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "zip_code")
    private String zipCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "neighborhood")
    private String neighborhood;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "country")
    private String country;
    @Size(max = 20)
    @Column(name = "cellphone")
    private String cellphone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;

    public ShopAddress() {
    }

    public ShopAddress(Integer id) {
        this.id = id;
    }

    public ShopAddress(Integer id, int idShop, String addressLine1, String zipCode, String neighborhood, String city, String country) {
        this.id = id;
        this.idShop = idShop;
        this.addressLine1 = addressLine1;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
        this.city = city;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAdressLine2() {
        return adressLine2;
    }

    public void setAdressLine2(String adressLine2) {
        this.adressLine2 = adressLine2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (!(object instanceof ShopAddress)) {
            return false;
        }
        ShopAddress other = (ShopAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.ShopAddress[ id=" + id + " ]";
    }
    
}
