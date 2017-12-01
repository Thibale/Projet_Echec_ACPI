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
    private String numEloNormalJ;
    private String numEloSemiRapideJ;
    private String numEloRapideJ;
    private String categorieJ;
    private String dateNaisJ;
    private String sexeJ;
    private String federationJ;
    private String ligueJ;
    private String clubJ;
    
    public Joueurs(String numLicence,String nom,String prenom,String numEloNormal,String numEloSemiRapide,String numEloRapide,String dateNais,String sexe,String federation,String ligue,String club){
        idJ=0;
        numLicenceJ=numLicence;
        nomJ=nom;
        prenomJ=prenom;
        if("".equals(numEloNormal)){
            numEloNormalJ="NC";
        }else{
            if(this.verifFormatEloValide(numEloNormal)){
                numEloNormalJ=numEloNormal;
            }
        }
        if("".equals(numEloSemiRapide)){
            numEloSemiRapideJ="NC";
        }else{
            if(this.verifFormatEloValide(numEloSemiRapide))
                numEloSemiRapideJ=numEloSemiRapide;
        }
        if("".equals(numEloRapide)){
            numEloRapideJ="NC";
        }else{
            if(this.verifFormatEloValide(numEloRapide))
                numEloRapideJ=numEloRapide;
        }
        categorieJ=this.calculCategorie(sexe,dateNais);
        dateNaisJ=dateNais;
        sexeJ=sexe;
        federationJ=federation;
        ligueJ=ligue;
        clubJ=club;
    }
    public Joueurs(int id,String numLicence,String nom,String prenom,String numEloNormal,String numEloSemiRapide,String numEloRapide,String dateNais,String sexe,String federation,String ligue,String club){
        idJ=id;
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
    public Joueurs(int id,String numLicence,String nom,String prenom,String numEloNormal,String numEloSemiRapide,String numEloRapide,String cat,String dateNais,String sexe,String federation,String ligue,String club){
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
    public Joueurs(String nom, String prenom, String dateN, String sexe){
        idJ=0;
        numLicenceJ="";
        nomJ=nom;
        prenomJ=prenom;
        numEloNormalJ="NC";
        numEloSemiRapideJ="NC";
        numEloRapideJ="NC";
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
    
    public String calculCategorie(String sexe, String date){
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
            }else if(age < 60){
                cat = cat+"SeP";
            }else{
                cat = cat+"Vet";
            }
            cat = cat+sexe;
        }else{
            cat = "Categorie non accessible.";
        }
        return cat;
    }
    
    public String conversionDate(String date){
        //FROM JJ/MM/AAAA
        //TO AAAA-MM-JJ
        String tmp = "";
        tmp = tmp + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);
        tmp += "-";
        tmp = tmp + date.charAt(3) + date.charAt(4);
        tmp += "-";
        tmp = tmp + date.charAt(0) + date.charAt(1);
        //LocalDate dateCorrecte = LocalDate.parse(tmp);
        return tmp;
    }
    
    public boolean verifDateNaiss(String dateNaissance){
        String tmp = this.conversionDate(dateNaissance);
        boolean verif = true;
        LocalDate dateNaiss = LocalDate.parse(tmp);
        LocalDate curDate = LocalDate.now();
        if (dateNaiss.compareTo(curDate) > 0){
            verif = false;
            //messageErreur += System.getProperty("line.separator") + "Erreur, date de naissance plus récente que la date actuelle.";
        }
        return verif;
    }
    
    public boolean verifMatchDate(String date){
        return date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"); 
        //messageErreur += "Erreur, date invalide format attendu : JJ-MM-AAAA";
    }

    public boolean verifDateValide(String date){
        String tmp =  this.conversionDate(date);
        boolean checkFormat = true;
        Date datetmp = null;
        String format = "yyyy-MM-dd";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            datetmp = sdf.parse(tmp);
            if (!tmp.equals(sdf.format(datetmp))) {
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
            if(!elo.matches("([0-9]{4})") || !elo.matches("([0-9]{3})")){
                res = false;
                //RetourCreation.setText("Erreur, elo invalide");
            }
        }
        return res;
    }
    
    public boolean verifFormatEloPositif(String elo){
        boolean res = true;
        if(!"".equals(elo)){
            if(!elo.matches("[^-]*")){
                res = false;
                //RetourCreation.setText("Erreur, elo invalide");
            }
        }
        return res;
    }
    
    public boolean verifFormatElo900To3000(String elo){
        boolean res = true;
        if((!"".equals(elo)) && verifFormatEloValide(elo)){
            if(Integer.valueOf(elo) < 900 || Integer.valueOf(elo) > 3000){
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
    
    public boolean verifNumLicenceValide(){
        boolean res = true;
        if(!"".equals(this.numLicenceJ)){
            if(!this.numLicenceJ.matches("([A-Z]{1})([0-9]{4})")){
                res = false;
                //RetourCreation.setText("Erreur, fédération invalide");
            }
        }
        return res;
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
