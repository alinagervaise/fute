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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Z
 */
@Entity
@Table(name = "user_shopping_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserShoppingList.findAll", query = "SELECT u FROM UserShoppingList u"),
    @NamedQuery(name = "UserShoppingList.findById", query = "SELECT u FROM UserShoppingList u WHERE u.id = :id"),
    @NamedQuery(name = "UserShoppingList.findByIdUser", query = "SELECT u FROM UserShoppingList u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "UserShoppingList.findByIdShoppingList", query = "SELECT u FROM UserShoppingList u WHERE u.idShoppingList = :idShoppingList")})
public class UserShoppingList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shopping_list")
    private int idShoppingList;

    public UserShoppingList() {
    }

    public UserShoppingList(Integer id) {
        this.id = id;
    }

    public UserShoppingList(Integer id, int idUser, int idShoppingList) {
        this.id = id;
        this.idUser = idUser;
        this.idShoppingList = idShoppingList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdShoppingList() {
        return idShoppingList;
    }

    public void setIdShoppingList(int idShoppingList) {
        this.idShoppingList = idShoppingList;
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
        if (!(object instanceof UserShoppingList)) {
            return false;
        }
        UserShoppingList other = (UserShoppingList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.UserShoppingList[ id=" + id + " ]";
    }
    
}
