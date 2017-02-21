/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Z
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findById", query = "SELECT m FROM Menu m WHERE m.id = :id"),
    @NamedQuery(name = "Menu.findByLabelFr", query = "SELECT m FROM Menu m WHERE m.labelFr = :labelFr"),
    @NamedQuery(name = "Menu.findByLabelEn", query = "SELECT m FROM Menu m WHERE m.labelEn = :labelEn"),
    @NamedQuery(name = "Menu.findByDescription", query = "SELECT m FROM Menu m WHERE m.description = :description"),
    @NamedQuery(name = "Menu.findByAction", query = "SELECT m FROM Menu m WHERE m.action = :action"),
    @NamedQuery(name = "Menu.findByClasse", query = "SELECT m FROM Menu m WHERE m.classe = :classe"),
    @NamedQuery(name = "Menu.findByCodeLibelle", query = "SELECT m FROM Menu m WHERE m.codeLibelle = :codeLibelle"),
    @NamedQuery(name = "Menu.findByDateCreation", query = "SELECT m FROM Menu m WHERE m.dateCreation = :dateCreation"),
    @NamedQuery(name = "Menu.findByDateModification", query = "SELECT m FROM Menu m WHERE m.dateModification = :dateModification"),
    @NamedQuery(name = "Menu.findByIcone", query = "SELECT m FROM Menu m WHERE m.icone = :icone"),
    @NamedQuery(name = "Menu.findByLibelle", query = "SELECT m FROM Menu m WHERE m.libelle = :libelle"),
    @NamedQuery(name = "Menu.findByOrdre", query = "SELECT m FROM Menu m WHERE m.ordre = :ordre")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "label_fr")
    private String labelFr;
    @Size(max = 50)
    @Column(name = "label_en")
    private String labelEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "action")
    private String action;
    @Size(max = 255)
    @Column(name = "classe")
    private String classe;
    @Size(max = 255)
    @Column(name = "code_libelle")
    private String codeLibelle;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @Size(max = 255)
    @Column(name = "icone")
    private String icone;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "ordre")
    private Short ordre;
    @OneToMany(mappedBy = "parent")
    private Set<Menu> menusSet;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne
    private Menu parent;

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    public Menu(Integer id, String labelFr, String description) {
        this.id = id;
        this.labelFr = labelFr;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelFr() {
        return labelFr;
    }

    public void setLabelFr(String labelFr) {
        this.labelFr = labelFr;
    }

    public String getLabelEn() {
        return labelEn;
    }

    public void setLabelEn(String labelEn) {
        this.labelEn = labelEn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getCodeLibelle() {
        return codeLibelle;
    }

    public void setCodeLibelle(String codeLibelle) {
        this.codeLibelle = codeLibelle;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Short getOrdre() {
        return ordre;
    }

    public void setOrdre(Short ordre) {
        this.ordre = ordre;
    }

    @XmlTransient
    public Set<Menu> getMenuSet() {
        return menusSet;
    }

    public void setMenuSet(Set<Menu> menusSet) {
        this.menusSet = menusSet;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecaddyfute.model.entities.Menu[ id=" + id + " ]";
    }
    
}
