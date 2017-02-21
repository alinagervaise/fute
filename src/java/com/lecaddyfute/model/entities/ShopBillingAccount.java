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
@Table(name = "shop_billing_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShopBillingAccount.findAll", query = "SELECT s FROM ShopBillingAccount s"),
    @NamedQuery(name = "ShopBillingAccount.findById", query = "SELECT s FROM ShopBillingAccount s WHERE s.id = :id"),
    @NamedQuery(name = "ShopBillingAccount.findByIdShop", query = "SELECT s FROM ShopBillingAccount s WHERE s.idShop = :idShop"),
    @NamedQuery(name = "ShopBillingAccount.findByIdPaymentMethod", query = "SELECT s FROM ShopBillingAccount s WHERE s.idPaymentMethod = :idPaymentMethod"),
    @NamedQuery(name = "ShopBillingAccount.findByCardNumber", query = "SELECT s FROM ShopBillingAccount s WHERE s.cardNumber = :cardNumber"),
    @NamedQuery(name = "ShopBillingAccount.findByCode", query = "SELECT s FROM ShopBillingAccount s WHERE s.code = :code"),
    @NamedQuery(name = "ShopBillingAccount.findByDateOfExpiration", query = "SELECT s FROM ShopBillingAccount s WHERE s.dateOfExpiration = :dateOfExpiration"),
    @NamedQuery(name = "ShopBillingAccount.findByAddressLine1", query = "SELECT s FROM ShopBillingAccount s WHERE s.addressLine1 = :addressLine1"),
    @NamedQuery(name = "ShopBillingAccount.findByAdressLine2", query = "SELECT s FROM ShopBillingAccount s WHERE s.adressLine2 = :adressLine2"),
    @NamedQuery(name = "ShopBillingAccount.findByZipCode", query = "SELECT s FROM ShopBillingAccount s WHERE s.zipCode = :zipCode")})
public class ShopBillingAccount implements Serializable {

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
    @Column(name = "id_payment_method")
    private Integer idPaymentMethod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "card_number")
    private String cardNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code")
    private int code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_expiration")
    @Temporal(TemporalType.DATE)
    private Date dateOfExpiration;
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

    public ShopBillingAccount() {
    }

    public ShopBillingAccount(Integer id) {
        this.id = id;
    }

    public ShopBillingAccount(Integer id, int idShop, String cardNumber, int code, Date dateOfExpiration, String addressLine1, String zipCode) {
        this.id = id;
        this.idShop = idShop;
        this.cardNumber = cardNumber;
        this.code = code;
        this.dateOfExpiration = dateOfExpiration;
        this.addressLine1 = addressLine1;
        this.zipCode = zipCode;
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

    public Integer getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(Integer idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Date dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopBillingAccount)) {
            return false;
        }
        ShopBillingAccount other = (ShopBillingAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.ShopBillingAccount[ id=" + id + " ]";
    }
    
}
