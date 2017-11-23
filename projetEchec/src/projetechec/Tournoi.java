package projetechec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
    
    public Tournoi(String nomT,String dateDebutT,String dateFinT, String nbRoundT, String lieuT){
        nomTournoi=nomT;
        dateDebut=dateDebutT;
        dateFin=dateFinT;
        if("".equals(nbRoundT)){
            nbRondes=0;
        }else{
            nbRondes=Integer.valueOf(nbRoundT);
        }
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
    
    public boolean nomTournoiEstVide(){
        return "".equals(this.nomTournoi);
    }
    
    public boolean dateDebutEstVide(){
        return "".equals(this.dateDebut);
    }
    
    public boolean dateFinEstVide(){
        return "".equals(this.dateFin);
    }
    
    public boolean nbRondesEstVide(){
        return this.nbRondes == 0;
    }
    
    public boolean verifDonneesSensiblesCompletes(){ 
        boolean tmp = true;
        //String stmp = "";
        //messageErreur = "Données manquantes";
        if(this.nomTournoiEstVide()){
            tmp = false;
            //stmp += System.getProperty("line.separator")+"Nom Tournoi manquant";
        }
        if(this.dateDebutEstVide()){
            tmp = false;
            //stmp += System.getProperty("line.separator")+"Date de début manquante";
        }
        if(this.dateFinEstVide()){
            tmp = false;
            //stmp += System.getProperty("line.separator")+"Date de fin manquante";
        }
        if(this.nbRondesEstVide()){
            tmp = false;
            //stmp += System.getProperty("line.separator")+"Nombre de rondes manquant";
        }
        if(!tmp){
            //messageErreur = "Données manquantes" + stmp;
        }
        return tmp;
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
    
    public boolean verifDateDebutAvantDateFin(String dateDeb, String dateFi){
        boolean verif = true;
        LocalDate dateD = LocalDate.parse(dateDeb);
        LocalDate dateF = LocalDate.parse(dateFi);
        if (dateD.compareTo(dateF) > 0){
            verif = false;
            //messageErreur += "Erreur, date de début plus récente que date de fin.";
        }
        return verif;
    }
    
    public boolean verifDateDebut(String dateDeb){
        boolean verif = true;
        LocalDate dateD = LocalDate.parse(dateDeb);
        LocalDate curDate = LocalDate.now();
        if (dateD.compareTo(curDate) < 0){
            verif = false;
            //messageErreur += "Erreur, date de début inférieure à la date actuelle.";
        }
        return verif;
    }
    
    public String tournoiToString(){
        return "Tournoi : " + nomTournoi + System.getProperty("line.separator") +
               "Date de début : " + dateDebut + " Date de fin : " + dateFin + System.getProperty("line.separator") +
               "Nombre de rondes : " + nbRondes + System.getProperty("line.separator") +
               "Lieu : " + lieu;
    }
    
}