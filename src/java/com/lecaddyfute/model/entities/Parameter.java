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
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author Nono Guy
 */
@Entity
@Table(name = "parameter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parameter.findAll", query = "SELECT p FROM Parameter p"),
    @NamedQuery(name = "Parameter.findByCode", query = "SELECT p FROM Parameter p WHERE p.code = :code"),
    @NamedQuery(name = "Parameter.findByName", query = "SELECT p FROM Parameter p WHERE p.name = :name"),
    @NamedQuery(name = "Parameter.findByCreatedDateTime", query = "SELECT p FROM Parameter p WHERE p.createdDateTime = :createdDateTime"),
    @NamedQuery(name = "Parameter.findByLastUpdatedDateTime", query = "SELECT p FROM Parameter p WHERE p.lastUpdatedDateTime = :lastUpdatedDateTime"),
    @NamedQuery(name = "Parameter.findByIsActiveData", query = "SELECT p FROM Parameter p WHERE p.isActiveData = :isActiveData"),
    @NamedQuery(name = "Parameter.findByIsDeleteData", query = "SELECT p FROM Parameter p WHERE p.isDeleteData = :isDeleteData"),
    @NamedQuery(name = "Parameter.findByCreatedDate", query = "SELECT p FROM Parameter p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "Parameter.findByCreatedHour", query = "SELECT p FROM Parameter p WHERE p.createdHour = :createdHour"),
    @NamedQuery(name = "Parameter.findByCreatorId", query = "SELECT p FROM Parameter p WHERE p.creatorId = :creatorId"),
    @NamedQuery(name = "Parameter.findByLastModifierId", query = "SELECT p FROM Parameter p WHERE p.lastModifierId = :lastModifierId"),
    @NamedQuery(name = "Parameter.findByUniversalId", query = "SELECT p FROM Parameter p WHERE p.universalId = :universalId"),
    @NamedQuery(name = "Parameter.findBySignature", query = "SELECT p FROM Parameter p WHERE p.signature = :signature")})
public class Parameter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "code")
    private String code;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "value")
    private String value;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "createdDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Column(name = "lastUpdatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDateTime;
    @Column(name = "isActiveData")
    private Integer isActiveData;
    @Column(name = "isDeleteData")
    private Integer isDeleteData;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "createdHour")
    @Temporal(TemporalType.TIME)
    private Date createdHour;
    @Column(name = "creatorId")
    private Integer creatorId;
    @Column(name = "lastModifierId")
    private Integer lastModifierId;
    @Size(max = 100)
    @Column(name = "universalId")
    private String universalId;
    @Size(max = 100)
    @Column(name = "signature")
    private String signature;

    public Parameter() {
    }

    public Parameter(String code) {
        this.code = code;
    }

    public Parameter(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public Integer getIsActiveData() {
        return isActiveData;
    }

    public void setIsActiveData(Integer isActiveData) {
        this.isActiveData = isActiveData;
    }

    public Integer getIsDeleteData() {
        return isDeleteData;
    }

    public void setIsDeleteData(Integer isDeleteData) {
        this.isDeleteData = isDeleteData;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedHour() {
        return createdHour;
    }

    public void setCreatedHour(Date createdHour) {
        this.createdHour = createdHour;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getLastModifierId() {
        return lastModifierId;
    }

    public void setLastModifierId(Integer lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getUniversalId() {
        return universalId;
    }

    public void setUniversalId(String universalId) {
        this.universalId = universalId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ngs.model.entities.Parameter[ code=" + code + " ]";
    }
    
}
