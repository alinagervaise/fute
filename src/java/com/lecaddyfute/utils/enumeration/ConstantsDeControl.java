/*
 * Class contraining all constants used in the application
 */
package com.lecaddyfute.utils.enumeration;

/**
 *
 * @author Gervaise
 */
public final class ConstantsDeControl {
    /** longueur  du code iso Alpha2 pays**/
    public static final int ISOALPHA2CODE = 2;
    public static final int MATRICULE_LENGTH = 15;
    public static final int DISTRICT_CODE_LENGTH = 3;
    public static final int NUMERO_REGISTRE_LENGTH = 4;
    public static final int ASSURE_PRINCIPAL = 1;
    
    /** statuts **/
    public static final int STATUT_MODIFIE = 7;
    public static final int STATUT_NEW = 8;
    public static final int STATUT_VALIDER = 5;
    public static final int STATUT_NON_VALIDER = 4;
    public static final int ACTIVE = 1;
    
    /** code des polices **/
    public static final int POLICE_CLASSIQUE = 1;
    public static final int POLICE_OUVERTE = 0;
    
    /** code profil **/
    public static final int SUPER_ADMINISTRATEUR = 1;
    public static final int ADMINISTRATEUR = 2;
    public static final int CONTROLEUR = 3;
    public static final int MEDECIN_CONSEIL = 4;
    public static final int ADMINISTRATIF = 5;
    public static final int BENEFICIAIRE = 6;
    public static final int SOUSCRIPTEUR = 7;
    public static final int ASSUREUR = 8;
    public static final int PRESTATAIRE = 9;

}
