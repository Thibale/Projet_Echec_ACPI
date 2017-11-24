package projetechec;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
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
    
    public Joueurs(String numLicence,String nom,String prenom,String numEloNormal,String numEloSemiRapide,String numEloRapide,String dateNais,char sexe,String federation,String ligue,String club){
        idJ=0;
        numLicenceJ=numLicence;
        nomJ=nom;
        prenomJ=prenom;
        if("".equals(numEloNormal)){
            numEloNormalJ=0;
        }else{
            numEloNormalJ=Integer.valueOf(numEloNormal);
        }
        if("".equals(numEloSemiRapide)){
            numEloSemiRapideJ=0;
        }else{
            numEloSemiRapideJ=Integer.valueOf(numEloSemiRapide);
        }
        if("".equals(numEloRapide)){
            numEloRapideJ=0;
        }else{
            numEloRapideJ=Integer.valueOf(numEloRapide);
        }
        categorieJ=this.calculCategorie(dateNais);
        dateNaisJ=dateNais;
        sexeJ=sexe;
        federationJ=federation;
        ligueJ=ligue;
        clubJ=club;
    }
    public Joueurs(int id,String numLicence,String nom,String prenom,int numEloNormal,int numEloSemiRapide,int numEloRapide,String dateNais,char sexe,String federation,String ligue,String club){
        idJ=id;
        numLicenceJ=numLicence;
        nomJ=nom;
        prenomJ=prenom;
        numEloNormalJ=numEloNormal;
        numEloSemiRapideJ=numEloSemiRapide;
        numEloRapideJ=numEloRapide;
        categorieJ=this.calculCategorie(dateNais);
        dateNaisJ=dateNais;
        sexeJ=sexe;
        federationJ=federation;
        ligueJ=ligue;
        clubJ=club;
    }
    public Joueurs(int id,String numLicence,String nom,String prenom,int numEloNormal,int numEloSemiRapide,int numEloRapide,String cat,String dateNais,char sexe,String federation,String ligue,String club){
        idJ=id;
        numLicenceJ=numLicence;
        nomJ=nom;
        prenomJ=prenom;
        numEloNormalJ=numEloNormal;
        numEloSemiRapideJ=numEloSemiRapide;
        numEloRapideJ=numEloRapide;
        categorieJ=cat;
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
    public void setNumEloNormalJ(int elo){
        this.numEloNormalJ = elo;
    }
    public void setNumEloSemiRapideJ(int elo){
        this.numEloSemiRapideJ = elo;
    }
    public void setNumEloRapideJ(int elo){
        this.numEloRapideJ = elo;
    }
    public void setCategorieJ(String cat){
        this.categorieJ = cat;
    }
    public void setDateNaisJ(String date){
        this.dateNaisJ = date;
    }
    public void setSexeJ(char sexe){
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
    
    public String calculCategorie(String date){
        String cat = "";
        if(this.verifFormatDateValide(date)){
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
            cat = cat+this.sexeJ;
        }else{
            cat = "Categorie non accessible.";
        }
        return cat;
    }
    
    
    public boolean verifDateNaiss(String dateNaissance){
        boolean verif = true;
        LocalDate dateNaiss = LocalDate.parse(dateNaissance);
        LocalDate curDate = LocalDate.now();
        if (dateNaiss.compareTo(curDate) > 0){
            verif = false;
            //messageErreur += System.getProperty("line.separator") + "Erreur, date de naissance plus récente que la date actuelle.";
        }
        return verif;
    }
    
    public boolean verifMatchDate(String date){
        return date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})"); 
        //messageErreur += "Erreur, date invalide format attendu : AAAA-MM-JJ";
    }

    public boolean verifDateValide(String date){
        boolean checkFormat = true;
        Date datetmp = null;
        String format = "yyyy-MM-dd";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            datetmp = sdf.parse(date);
            if (!date.equals(sdf.format(datetmp))) {
                datetmp = null;
            }
        } catch (ParseException ex) {
        }
        if (datetmp == null) {
            checkFormat = false;
            //messageErreur += "Erreur, date incorrecte";
        }
        return checkFormat;
    }

    public boolean verifFormatDateValide(String date){
        boolean checkFormat;

        checkFormat = this.verifMatchDate(date);

        if(checkFormat){
            checkFormat = this.verifDateValide(date);
        }
        return checkFormat;
    }
    
    
    public boolean verifFormatNomValide(){
        boolean res = true;
        if(!this.nomJ.matches("[A-Za-z-]*")){
            res = false;
            //RetourCreation.setText("Erreur, nom invalide");
        }
        return res;
    }
    
    public boolean verifFormatPrenomValide(){
        boolean res = true;
        if(!this.prenomJ.matches("[A-Za-z-]*")){
            res = false;
            //RetourCreation.setText("Erreur, prenom invalide");
        }
        return res;
    }
    
    public boolean verifFormatEloValide(String elo){
        boolean res = true;
        if(!"".equals(elo)){
            if(!elo.matches("[0-9]*")){
                res = false;
                //RetourCreation.setText("Erreur, elo invalide");
            }
        }
        return res;
    }
    
    public boolean verifFormatLigueValide(){
        boolean res = true;
        if(!"".equals(this.ligueJ)){
            if(!this.ligueJ.matches("[A-Za-z-]*") || this.ligueJ.length() != 3){
                res = false;
                //RetourCreation.setText("Erreur, ligue invalide");
            }
        }
        return res;
    }
    
    public boolean verifFormatFedValide(){
        boolean res = true;
        if(!"".equals(this.federationJ)){
            if(!this.federationJ.matches("[A-Za-z-]*") || this.federationJ.length() != 3){
                res = false;
                //RetourCreation.setText("Erreur, fédération invalide");
            }
        }
        return res;
    }
    
    public boolean nomEstVide(){
        return "".equals(this.nomJ);
    }
    
    public boolean prenomEstVide(){
        return "".equals(this.prenomJ);
    }
    
    public boolean sexeEstVide(){
        return "".equals(this.sexeJ);
    }
    
    public boolean dateEstVide(){
        return "".equals(this.dateNaisJ);
    }
    
    public boolean verifDonneeEnregistrementJoueur(){
        boolean res = true;
        if(this.nomEstVide()){
            res = false;
            //labelNom.setForeground(Color.red);
        }
        if(this.prenomEstVide()){
            res = false;
            //labelPrenom.setForeground(Color.red);
        }
        if(this.sexeEstVide()){
            res = false;
            //labelSexe.setForeground(Color.red);
        }
        if(this.dateEstVide()){
            res = false;
            //labelDateDeNaissance.setForeground(Color.red);
        }
        return res;
    }
    
    public String JtoString(){
        return "Numero Licence: " + this.numLicenceJ +System.getProperty("line.separator")+
                "Nom joueur: " + this.nomJ +System.getProperty("line.separator")+ 
                "Prenom joueur: " + this.prenomJ +System.getProperty("line.separator")+
                "Numero Elo Normal: " + this.numEloNormalJ +System.getProperty("line.separator")+
                "Numero Elo SemiRapide: "+ this.numEloSemiRapideJ +System.getProperty("line.separator")+
                "Numero Elo Rapide:  " + this.numEloRapideJ +System.getProperty("line.separator")+
                "Categorie: "+this.categorieJ +System.getProperty("line.separator")+
                "Date Naissance: " + this.dateNaisJ +System.getProperty("line.separator")+
                "Sexe: " + this.sexeJ +System.getProperty("line.separator")+
                "Federation: " + this.federationJ +System.getProperty("line.separator")+
                "Ligue: " + this.ligueJ +System.getProperty("line.separator")+
                "Club: "+ this.clubJ+System.getProperty("line.separator");
    }
}  
