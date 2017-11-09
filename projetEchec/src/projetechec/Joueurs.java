package projetechec;

import java.time.LocalDate;
import java.time.Period;

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
    
    public Joueurs(String numLicence,String nom,String prenom,int numEloNormal,int numEloSemiRapide,int numEloRapide,String dateNais,char sexe,String federation,String ligue,String club){
        idJ=0;
        numLicenceJ=numLicence;
        nomJ=nom;
        prenomJ=prenom;
        numEloNormalJ=numEloNormal;
        numEloSemiRapideJ=numEloSemiRapide;
        numEloRapideJ=numEloRapide;
        categorieJ=this.calculCategorie(sexe,dateNais);
        dateNaisJ=dateNais;
        sexeJ=sexe;
        federationJ=federation;
        ligueJ=ligue;
        clubJ=club;
    }
    public Joueurs(String nom, String prenom, String dateN, char sexe){
        idJ=0;
        numLicenceJ="";
        nomJ=nom;
        prenomJ=prenom;
        numEloNormalJ=0;
        numEloSemiRapideJ=0;
        numEloRapideJ=0;
        categorieJ="";
        dateNaisJ=dateN;
        sexeJ=sexe;
        federationJ="";
        ligueJ="";
        clubJ="";
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
    
    public void getIdJ(int id){
        this.idJ = id;
    }
    public void getNumLicenceJ(String numLic){
        this.numLicenceJ = numLic;
    }
    public void getNomJ(String nom){
        this.nomJ = nom;
    }
    public void getPrenomJ(String prenom){
        this.prenomJ = prenom;
    }
    public void getNumEloNormalJ(int elo){
        this.numEloNormalJ = elo;
    }
    public void getNumEloSemiRapideJ(int elo){
        this.numEloSemiRapideJ = elo;
    }
    public void getNumEloRapideJ(int elo){
        this.numEloRapideJ = elo;
    }
    public void getCategorieJ(String cat){
        this.categorieJ = cat;
    }
    public void getDateNaisJ(String date){
        this.dateNaisJ = date;
    }
    public void getSexeJ(char sexe){
        this.sexeJ = sexe;
    }
    public void getFederationJ(String fed){
        this.federationJ = fed;
    }
    public void getLigueJ(String ligue){
        this.ligueJ = ligue;
    }
    public void getClubJ(String club){
        this.clubJ = club;
    }
    
    public String calculCategorie(char sexe, String date){
        String cat = "";
        LocalDate dob = LocalDate.parse(date);
        LocalDate curDate = LocalDate.now();
        int age = Period.between(dob, curDate).getYears();
        if(age < 8){
            cat = cat+"pPo";
        }else if(age < 10){
            cat = cat+"Po";
        }else if(age < 12){
            cat = cat+"Pu";
        }else if(age < 14){
            cat = cat+"Ben";
        }else if(age < 16){
            cat = cat+"Min";
        }else if(age < 18){
            cat = cat+"Cad";
        }else if(age < 20){
            cat = cat+"Jun";
        }else if(age < 50){
            cat = cat+"Sen";
        }else{
            cat = cat+"Vet";
        }
        return cat+sexe;
    }
}  
