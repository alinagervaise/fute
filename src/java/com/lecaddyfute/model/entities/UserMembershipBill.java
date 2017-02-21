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
@Table(name = "user_membership_bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMembershipBill.findAll", query = "SELECT u FROM UserMembershipBill u"),
    @NamedQuery(name = "UserMembershipBill.findById", query = "SELECT u FROM UserMembershipBill u WHERE u.id = :id"),
    @NamedQuery(name = "UserMembershipBill.findByIdUserBillingAccount", query = "SELECT u FROM UserMembershipBill u WHERE u.idUserBillingAccount = :idUserBillingAccount"),
    @NamedQuery(name = "UserMembershipBill.findByIdUser", query = "SELECT u FROM UserMembershipBill u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "UserMembershipBill.findByAmount", query = "SELECT u FROM UserMembershipBill u WHERE u.amount = :amount"),
    @NamedQuery(name = "UserMembershipBill.findByDescription", query = "SELECT u FROM UserMembershipBill u WHERE u.description = :description"),
    @NamedQuery(name = "UserMembershipBill.findByDateCreate", query = "SELECT u FROM UserMembershipBill u WHERE u.dateCreate = :dateCreate")})
public class UserMembershipBill implements Serializable {

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
    @Column(name = "id_user")
    private int idUser;
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

    public UserMembershipBill() {
    }

    public UserMembershipBill(Integer id) {
        this.id = id;
    }

    public UserMembershipBill(Integer id, int idUserBillingAccount, int idUser, Date dateCreate) {
        this.id = id;
        this.idUserBillingAccount = idUserBillingAccount;
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof UserMembershipBill)) {
            return false;
        }
        UserMembershipBill other = (UserMembershipBill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.UserMembershipBill[ id=" + id + " ]";
    }
    
}
