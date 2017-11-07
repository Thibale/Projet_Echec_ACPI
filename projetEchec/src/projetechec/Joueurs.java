package projetechec;

import java.util.Date;

public class Joueurs {
    private int idJ;
    private String numLicenceJ;
    private String nomJ;
    private String prenomJ;
    private int numEloNormalJ;
    private int numEloSemiRapideJ;
    private int numEloRapideJ;
    private String categorieJ;
    private String dateNaisJ;
    private char sexeJ;
    private String federationJ;
    private String ligueJ;
    private String clubJ;
    
    public Joueurs(int id,String numLicence,String nom,String prenom,int numEloNormal,int numEloSemiRapide,int numEloRapide,String categorie,String dateNais,char sexe,String federation,String ligue,String club){
        idJ=id;
        numLicenceJ=numLicence;
        nomJ=nom;
        prenomJ=prenom;
        numEloNormalJ=numEloNormal;
        numEloSemiRapideJ=numEloSemiRapide;
        numEloRapideJ=numEloRapide;
        categorieJ=categorie;
        dateNaisJ=dateNais;
        sexeJ=sexe;
        federationJ=federation;
        ligueJ=ligue;
        clubJ=club;
    }
    
    /* Assesseurs */
    
    public int getIdJ(){
        return this.idJ;
    }
    
    public String getNumLicenceJ(){
        return this.numLicenceJ;
    }
    
    public String getNomJ(){
        return this.nomJ;
    }
    
    public String getPrenomJ(){
        return this.prenomJ;
    }
    
    public int getNumEloNormalJ(){
        return this.numEloNormalJ;
    }
    
    public int getNumEloSemiRapideJ(){
        return this.numEloSemiRapideJ;
    }
    
    public int getNumEloRapideJ(){
        return this.numEloRapideJ;
    }
    
    public String getCategorieJ(){
        return this.categorieJ;
    }
    
    public String getDateNaisJ(){
        return this.dateNaisJ;
    }
    
    public char getSexeJ(){
        return this.sexeJ;
    }
    
    public String getFederationJ(){
        return this.federationJ;
    }
    
    public String getLigueJ(){
        return this.ligueJ;
    }
    
    public String getClubJ(){
        return this.clubJ;
    }
}

    
