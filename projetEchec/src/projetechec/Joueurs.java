package projetechec;

import java.util.Map;

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
        
    public Joueurs(){
        idJ = -1;
        numLicenceJ = "";
        nomJ = "";
        prenomJ = "";
        numEloNormalJ = "";
        numEloSemiRapideJ = "";
        numEloRapideJ = "";
        categorieJ = "";
        dateNaisJ = "";
        sexeJ = "";
        federationJ = "";
        ligueJ = "";
        clubJ = "";
    }
    
    Joueurs(Map<String, String> informations){
        if(informations.get("id") != null && !informations.get("id").isEmpty()){
            idJ = Integer.valueOf(informations.get("id"));
        }
        numLicenceJ=informations.get("numLicence");
        nomJ=informations.get("nom");
        prenomJ=informations.get("prenom");
        if("".equals(informations.get("eloClassique"))){
            numEloNormalJ="NC";
        }else{
            numEloNormalJ=informations.get("eloClassique");
        }
        if("".equals(informations.get("eloSemiRapide"))){
            numEloSemiRapideJ="NC";
        }else{
            numEloSemiRapideJ=informations.get("eloSemiRapide");
        }
        if("".equals(informations.get("eloRapide"))){
            numEloRapideJ="NC";
        }else{
            numEloRapideJ=informations.get("eloRapide");
        }      
        categorieJ=informations.get("categorie");
        dateNaisJ=informations.get("dateNaissance");
        sexeJ=informations.get("sexe");
        federationJ=informations.get("federation");
        ligueJ=informations.get("ligue");
        clubJ=informations.get("club");
    }
   
    // Assesseurs
    public int getIdJ() {
        return idJ;
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
        return  "Numéro Licence : " + this.numLicenceJ +System.lineSeparator()+
                "Nom joueur : " + this.nomJ +System.lineSeparator()+ 
                "Prénom joueur : " + this.prenomJ +System.lineSeparator()+
                "Elo Classique : " + this.numEloNormalJ +System.lineSeparator()+
                "Elo SemiRapide : "+ this.numEloSemiRapideJ +System.lineSeparator()+
                "Elo Rapide :  " + this.numEloRapideJ +System.lineSeparator()+
                "Catégorie : "+this.categorieJ +System.lineSeparator()+
                "Date Naissance : " + this.dateNaisJ +System.lineSeparator()+
                "Sexe : " + this.sexeJ +System.lineSeparator()+
                "Fédération : " + this.federationJ +System.lineSeparator()+
                "Ligue : " + this.ligueJ +System.lineSeparator()+
                "Club : "+ this.clubJ+System.lineSeparator();
    }
    
    public String affichageListe(){
        return nomJ+"   "+prenomJ+"   "+numEloNormalJ+"   "+categorieJ+"      "+federationJ+"      "+ligueJ+"     "+clubJ;
    }
}  
