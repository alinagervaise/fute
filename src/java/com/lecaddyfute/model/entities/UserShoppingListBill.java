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
@Table(name = "user_shopping_list_bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserShoppingListBill.findAll", query = "SELECT u FROM UserShoppingListBill u"),
    @NamedQuery(name = "UserShoppingListBill.findById", query = "SELECT u FROM UserShoppingListBill u WHERE u.id = :id"),
    @NamedQuery(name = "UserShoppingListBill.findByIdUserBillingAccount", query = "SELECT u FROM UserShoppingListBill u WHERE u.idUserBillingAccount = :idUserBillingAccount"),
    @NamedQuery(name = "UserShoppingListBill.findByIdShoppingList", query = "SELECT u FROM UserShoppingListBill u WHERE u.idShoppingList = :idShoppingList"),
    @NamedQuery(name = "UserShoppingListBill.findByAmount", query = "SELECT u FROM UserShoppingListBill u WHERE u.amount = :amount"),
    @NamedQuery(name = "UserShoppingListBill.findByDescription", query = "SELECT u FROM UserShoppingListBill u WHERE u.description = :description"),
    @NamedQuery(name = "UserShoppingListBill.findByDateCreate", query = "SELECT u FROM UserShoppingListBill u WHERE u.dateCreate = :dateCreate")})
public class UserShoppingListBill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user_billing_account")
    private int idUserBillingAccount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shopping_list")
    private int idShoppingList;
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

    public UserShoppingListBill() {
    }

    public UserShoppingListBill(Integer id) {
        this.id = id;
    }

    public UserShoppingListBill(Integer id, int idUserBillingAccount, int idShoppingList, Date dateCreate) {
        this.id = id;
        this.idUserBillingAccount = idUserBillingAccount;
        this.idShoppingList = idShoppingList;
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUserBillingAccount() {
        return idUserBillingAccount;
    }

    public void setIdUserBillingAccount(int idUserBillingAccount) {
        this.idUserBillingAccount = idUserBillingAccount;
    }

    public int getIdShoppingList() {
        return idShoppingList;
    }

    public void setIdShoppingList(int idShoppingList) {
        this.idShoppingList = idShoppingList;
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
        if (!(object instanceof UserShoppingListBill)) {
            return false;
        }
        UserShoppingListBill other = (UserShoppingListBill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.UserShoppingListBill[ id=" + id + " ]";
    }
    
}
