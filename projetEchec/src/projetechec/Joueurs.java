package projetechec;

public class Joueurs {
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
            numEloSemiRapideJ=numEloSemiRapide;
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
    
    public Joueurs(String[] infos){
        numLicenceJ=infos[0];
        nomJ=infos[1];
        prenomJ=infos[2];
        if("".equals(infos[4])){
            numEloNormalJ="NC";
        }else{
            numEloNormalJ=infos[4];
        }
        if("".equals(infos[5])){
            numEloSemiRapideJ="NC";
        }else{
            numEloSemiRapideJ=infos[5];
        }
        if("".equals(infos[6])){
            numEloRapideJ="NC";
        }else{
            numEloRapideJ=infos[6];
        }      
        categorieJ=infos[7];
        dateNaisJ=infos[3];
        sexeJ=infos[8];
        federationJ=infos[9];
        ligueJ=infos[10];
        clubJ=infos[11];
    }
   
    // Assesseurs
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
}  
