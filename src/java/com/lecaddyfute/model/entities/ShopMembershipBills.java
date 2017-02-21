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
@Table(name = "shop_membership_bills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShopMembershipBills.findAll", query = "SELECT s FROM ShopMembershipBills s"),
    @NamedQuery(name = "ShopMembershipBills.findById", query = "SELECT s FROM ShopMembershipBills s WHERE s.id = :id"),
    @NamedQuery(name = "ShopMembershipBills.findByIdShopBillingAccount", query = "SELECT s FROM ShopMembershipBills s WHERE s.idShopBillingAccount = :idShopBillingAccount"),
    @NamedQuery(name = "ShopMembershipBills.findByIdShop", query = "SELECT s FROM ShopMembershipBills s WHERE s.idShop = :idShop"),
    @NamedQuery(name = "ShopMembershipBills.findByAmount", query = "SELECT s FROM ShopMembershipBills s WHERE s.amount = :amount"),
    @NamedQuery(name = "ShopMembershipBills.findByDescription", query = "SELECT s FROM ShopMembershipBills s WHERE s.description = :description"),
    @NamedQuery(name = "ShopMembershipBills.findByDateCreate", query = "SELECT s FROM ShopMembershipBills s WHERE s.dateCreate = :dateCreate")})
public class ShopMembershipBills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shop_billing_account")
    private int idShopBillingAccount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shop")
    private int idShop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    public ShopMembershipBills() {
    }

    public ShopMembershipBills(Integer id) {
        this.id = id;
    }

    public ShopMembershipBills(Integer id, int idShopBillingAccount, int idShop, Date dateCreate) {
        this.id = id;
        this.idShopBillingAccount = idShopBillingAccount;
        this.idShop = idShop;
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdShopBillingAccount() {
        return idShopBillingAccount;
    }

    public void setIdShopBillingAccount(int idShopBillingAccount) {
        this.idShopBillingAccount = idShopBillingAccount;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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
        if (!(object instanceof ShopMembershipBills)) {
            return false;
        }
        ShopMembershipBills other = (ShopMembershipBills) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.ShopMembershipBills[ id=" + id + " ]";
    }
    
}
