package projetechec;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.ArrayList;

public class Joueurs {  
    private int idJ;
    private String numLicenceJ;
    private String nomJ;
    private String prenomJ;
    private String numEloNormalJ;
    private String numEloSemiRapideJ;
    private String numEloRapideJ;
    private String categorieJ;
    private String dateNaisJ;
    private String sexeJ;
    private String federationJ;
    private String ligueJ;
    private String clubJ;
    
    public Joueurs(String numLicence,String nom,String prenom,String numEloNormal,String numEloSemiRapide,String numEloRapide,String cat,String dateNais,String sexe,String federation,String ligue,String club){
        idJ=0;
        numLicenceJ=numLicence;
        nomJ=nom;
        prenomJ=prenom;
        if("".equals(numEloNormal)){
            numEloNormalJ="NC";
        }else{
            numEloNormalJ=numEloNormal;
        }
        if("".equals(numEloSemiRapide)){
            numEloSemiRapideJ="NC";
        }else{
            numEloRapideJ=numEloRapide;
        }
        if("".equals(numEloRapide)){
            numEloRapideJ="NC";
        }else{
            numEloRapideJ=numEloRapide;
        }      
        categorieJ=cat;
        dateNaisJ=dateNais;
        sexeJ=sexe;
        federationJ=federation;
        ligueJ=ligue;
        clubJ=club;
    }
   
    // Assesseurs
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
    public String getNumEloNormalJ(){
        return this.numEloNormalJ;
    }
    public String getNumEloSemiRapideJ(){
        return this.numEloSemiRapideJ;
    }
    public String getNumEloRapideJ(){
        return this.numEloRapideJ;
    }
    public String getCategorieJ(){
        return this.categorieJ;
    }
    public String getDateNaisJ(){
        return this.dateNaisJ;
    }
    public String getSexeJ(){
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
    
    public void setIdJ(int id){
        this.idJ = id;
    }
    public void setNumLicenceJ(String numLic){
        this.numLicenceJ = numLic;
    }
    public void setNomJ(String nom){
        this.nomJ = nom;
    }
    public void setPrenomJ(String prenom){
        this.prenomJ = prenom;
    }
    public void setNumEloNormalJ(String elo){
        this.numEloNormalJ = elo;
    }
    public void setNumEloSemiRapideJ(String elo){
        this.numEloSemiRapideJ = elo;
    }
    public void setNumEloRapideJ(String elo){
        this.numEloRapideJ = elo;
    }
    public void setCategorieJ(String cat){
        this.categorieJ = cat;
    }
    public void setDateNaisJ(String date){
        this.dateNaisJ = date;
    }
    public void setSexeJ(String sexe){
        this.sexeJ = sexe;
    }
    public void setFederationJ(String fed){
        this.federationJ = fed;
    }
    public void setLigueJ(String ligue){
        this.ligueJ = ligue;
    }
    public void setClubJ(String club){
        this.clubJ = club;
    }
    
    public String JtoString(){
        return  "Numero Licence : " + this.numLicenceJ +System.getProperty("line.separator")+
                "Nom joueur : " + this.nomJ +System.getProperty("line.separator")+ 
                "Prénom joueur : " + this.prenomJ +System.getProperty("line.separator")+
                "Elo Classique : " + this.numEloNormalJ +System.getProperty("line.separator")+
                "Elo SemiRapide : "+ this.numEloSemiRapideJ +System.getProperty("line.separator")+
                "Elo Rapide :  " + this.numEloRapideJ +System.getProperty("line.separator")+
                "Categorie : "+this.categorieJ +System.getProperty("line.separator")+
                "Date Naissance : " + this.dateNaisJ +System.getProperty("line.separator")+
                "Sexe : " + this.sexeJ +System.getProperty("line.separator")+
                "Fédération : " + this.federationJ +System.getProperty("line.separator")+
                "Ligue : " + this.ligueJ +System.getProperty("line.separator")+
                "Club : "+ this.clubJ+System.getProperty("line.separator");
    }
}  
