/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Z
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id"),
    @NamedQuery(name = "Address.findByActive", query = "SELECT a FROM Address a WHERE a.active = :active"),
  
    @NamedQuery(name = "Address.findByDateCreation", query = "SELECT a FROM Address a WHERE a.dateCreation = :dateCreation"),
    @NamedQuery(name = "Address.findByDateFermeture", query = "SELECT a FROM Address a WHERE a.dateFermeture = :dateFermeture"),
    @NamedQuery(name = "Address.findByDateModification", query = "SELECT a FROM Address a WHERE a.dateModification = :dateModification"),
    @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country"),
    @NamedQuery(name = "Address.findByNeighborhood", query = "SELECT a FROM Address a WHERE a.neighborhood = :neighborhood"),
    @NamedQuery(name = "Address.findByRegion", query = "SELECT a FROM Address a WHERE a.region = :region"),
    @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street"),
    @NamedQuery(name = "Address.findBySignature", query = "SELECT a FROM Address a WHERE a.signature = :signature"),
    @NamedQuery(name = "Address.findByTel", query = "SELECT a FROM Address a WHERE a.tel = :tel"),
    @NamedQuery(name = "Address.findByVersion", query = "SELECT a FROM Address a WHERE a.version = :version"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByWebsite", query = "SELECT a FROM Address a WHERE a.website = :website")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Integer active;
    @Column(name = "bp")
    private Integer poBox;
    @Size(max = 255)
    @Column(name = "code_postal")
    private String zipCode;
 
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "date_fermeture")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFermeture;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    
    @JoinColumn(name = "country_code", referencedColumnName = "code")
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Country country;
    

    @Size(max = 255)
    @Column(name = "quartier")
    private String neighborhood;
    @Size(max = 255)
    @Column(name = "region")
    private String region;
    @Size(max = 255)
    @Column(name = "rue")
    private String street;
    @Size(max = 255)
    @Column(name = "signature")
    private String signature;
    @Size(max = 255)
    @Column(name = "tel")
    private String tel;
    @Column(name = "version")
    private Integer version;
    @Size(max = 255)
    @Column(name = "ville")
    private String city;
    @Size(max = 255)
    @Column(name = "website")
    private String website;
    
    @OneToMany(mappedBy = "address")
    private Set<Users> users;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getPoBox() {
        return poBox;
    }

    public void setPoBox(Integer poBox) {
        this.poBox = poBox;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

 
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateFermeture() {
        return dateFermeture;
    }

    public void setDateFermeture(Date dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String quartier) {
        this.neighborhood = quartier;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @XmlTransient
    public Set<Users> getUsers() {
        return users;
    }

    public void setUsersSet(Set<Users> users) {
        this.users = users;
    }
    
    public void clone (final Address address) {
        if(address==null)  return;
        this.city = address.getCity();
        if (this.country == null){
            this.country = new Country();
        }
        this.country.clone( address.getCountry());
        this.dateCreation = address.getDateCreation();
        this.neighborhood = address.getNeighborhood();
        this.region = address.getRegion();
        this.poBox = address.getPoBox();
        this.zipCode = address.getZipCode();
        this.tel = address.getTel();
        this.website = address.getWebsite();
        this.street = address.getStreet();
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        return this.street.equalsIgnoreCase(other.street)&& 
                this.city.equalsIgnoreCase(other.city)&&
                this.country == other.country &&
                this.poBox.equals(other.poBox) &&
                this.neighborhood.equalsIgnoreCase(other.neighborhood);
      
      
    }

    @Override
    public String toString() {
        return "Address[ id=" + id + " ] \n"
                + "Address[ neighborhood=" + neighborhood + " ] \n"
                + "Address[ poBox=" + poBox + " ] \n"
               + "Address[ street=" + street + " ] \n"
                + "Address[ City=" +  city + " ] \n"
                + "Address[ Country=" +  country + " ] \n";
    }
    
}
