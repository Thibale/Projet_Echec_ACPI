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
    
    public Joueurs(Map<String, String> infos){
        if(infos.get("id") != null && !infos.get("id").isEmpty()){
            idJ = Integer.valueOf(infos.get("id"));
        }
        numLicenceJ=infos.get("numLicence");
        nomJ=infos.get("nom");
        prenomJ=infos.get("prenom");
        if("".equals(infos.get("eloClassique"))){
            numEloNormalJ="NC";
        }else{
            numEloNormalJ=infos.get("eloClassique");
        }
        if("".equals(infos.get("eloSemiRapide"))){
            numEloSemiRapideJ="NC";
        }else{
            numEloSemiRapideJ=infos.get("eloSemiRapide");
        }
        if("".equals(infos.get("eloRapide"))){
            numEloRapideJ="NC";
        }else{
            numEloRapideJ=infos.get("eloRapide");
        }      
        categorieJ=infos.get("categorie");
        dateNaisJ=infos.get("dateNaissance");
        sexeJ=infos.get("sexe");
        federationJ=infos.get("federation");
        ligueJ=infos.get("ligue");
        clubJ=infos.get("club");
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
        return  "Numero Licence : " + this.numLicenceJ +System.lineSeparator()+
                "Nom joueur : " + this.nomJ +System.lineSeparator()+ 
                "Prénom joueur : " + this.prenomJ +System.lineSeparator()+
                "Elo Classique : " + this.numEloNormalJ +System.lineSeparator()+
                "Elo SemiRapide : "+ this.numEloSemiRapideJ +System.lineSeparator()+
                "Elo Rapide :  " + this.numEloRapideJ +System.lineSeparator()+
                "Categorie : "+this.categorieJ +System.lineSeparator()+
                "Date Naissance : " + this.dateNaisJ +System.lineSeparator()+
                "Sexe : " + this.sexeJ +System.lineSeparator()+
                "Fédération : " + this.federationJ +System.lineSeparator()+
                "Ligue : " + this.ligueJ +System.lineSeparator()+
                "Club : "+ this.clubJ+System.lineSeparator();
    }
    
    public String affichageListe(){
        return nomJ+" "+prenomJ+"   "+numEloNormalJ+" "+categorieJ+" "+federationJ+" "+ligueJ+" "+clubJ;
    }
}  
