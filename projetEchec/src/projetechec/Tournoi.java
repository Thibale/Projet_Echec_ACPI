package projetechec;

public class Tournoi {
    private String nomTournoi;
    private String dateDebut;
    private String dateFin;
    private int nbRondes;
    private String lieu;
    
    public Tournoi(String nomT,String dateDebutT,String dateFinT, int nbRoundT, String lieuT){
        nomTournoi=nomT;
        dateDebut=dateDebutT;
        dateFin=dateFinT;
        nbRondes=nbRoundT;
        lieu=lieuT;
    }

    public String getNomTournoi() {
        return nomTournoi;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public int getNbRondes() {
        return nbRondes;
    }

    public String getLieu() {
        return lieu;
    }

    public void setNomTournoi(String nomTournoi) {
        this.nomTournoi = nomTournoi;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setNbRondes(int nbRondes) {
        this.nbRondes = nbRondes;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    public boolean verifCompletion(String messageErreur){
        boolean tmp = true;
        messageErreur = "Données manquantes";
        if("".equals(this.nomTournoi)){
            tmp = false;
            messageErreur += System.getProperty("line.separator")+"Nom Tournoi manquant";
        }
        if("".equals(this.dateDebut)){
            tmp = false;
            messageErreur += System.getProperty("line.separator")+"Date de début manquante";
        }
        if("".equals(this.dateFin)){
            tmp = false;
            messageErreur += System.getProperty("line.separator")+"Date de fin manquante";
        }
        if(this.nbRondes == 0){
            tmp = false;
            messageErreur += System.getProperty("line.separator")+"Nombre de rondes manquant";
        }
        return tmp;
    }
    
    
    
    /*private String nomTournoi;
    private String dateDebut;
    private String dateFin;
    private int nbRondes;
    private String lieu;*/
}