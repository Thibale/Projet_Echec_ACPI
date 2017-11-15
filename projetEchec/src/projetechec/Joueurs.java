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
    public Joueurs(int id,String numLicence,String nom,String prenom,int numEloNormal,int numEloSemiRapide,int numEloRapide,String dateNais,char sexe,String federation,String ligue,String club){
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
    
    /*public String verrifierContenuJoueur(Joueurs j){
        if(verifDonneeEnregistrementJoueur(j.getNomJ(), j.getPrenomJ(), j.getDateNaisJ(), j.getSexeJ())){
            if(verifFormatNomValide(nom)){
                if(verifFormatPrenomValide(prenom)){
                    if(verifFormatDateValide(dateDeNaissance)){
                        if(verifFormatEloValide(eloN)){
                            if(verifFormatEloValide(eloR)){
                                if(verifFormatEloValide(eloSR)){
                                    if(verifFormatFedValide(fed)){
                                        if(verifFormatLigueValide(lig)){
                                            Joueurs J = new Joueurs(numL,nom,prenom,Integer.valueOf(eloN),Integer.valueOf(eloSR),Integer.valueOf(eloR),dateDeNaissance,sexe.charAt(0),fed,lig,clb); //le sexe vaut 'a' car j'arrive pas à faire la coversion String to Char
                                            RetourCreation.setText(nom + '\n' + prenom + '\n' + dateDeNaissance + '\n' + sexe + '\n' + licence);
                                            //RetourCreation.setText(J.getNomJ() + '\n' + J.getPrenomJ() + '\n' + J.getDateNaisJ() + '\n' + J.getSexeJ() + '\n'); //test de l'objet
                                            //XML xml1 = new XML(); 
                                            //xml1.WriteXML(J);
                                        }
                                    }
                                }
                            }
                        } 
                    }
                }
            }
        }
        return "";
    }*/
    
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
