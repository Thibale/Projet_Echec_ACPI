package projetechec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Tournoi {
    private String nomTournoi;
    private String dateDebut;
    private String dateFin;
    private int nbRondes;
    private String lieu;
    private ArrayList<Joueurs> joueurs;
    
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
        //messageErreur = "DonnÃ©es manquantes";
        if(this.nomTournoiEstVide()){
            tmp = false;
            //stmp += System.getProperty("line.separator")+"Nom Tournoi manquant";
        }
        if(this.dateDebutEstVide()){
            tmp = false;
            //stmp += System.getProperty("line.separator")+"Date de dÃ©but manquante";
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
            //messageErreur = "DonnÃ©es manquantes" + stmp;
        }
        return tmp;
    }
    
    public boolean verifTailleNomTournoi(){
        boolean verif = true;
        if(this.nomTournoi.length() > 50){
            verif = false;
        }
        return verif;
    }
    
    public boolean verifNbRondes(){
        boolean verif = true;
        if(!"".equals(this.nbRondes)){
            if(!String.valueOf(this.nbRondes).matches("[^-]*")){
                verif = false;
                //RetourCreation.setText("Erreur, elo invalide");
            }
        }
        return verif;
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
    
    public boolean verifMatchDate(String date){
        return date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"); 
        //messageErreur += "Erreur, date invalide format attendu : AAAA-MM-JJ";
    }
    
    public boolean verifDateValide(String date){
        String tmp = this.conversionDate(date);
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
    
    public boolean verifDateDebutAvantDateFin(String dateDeb, String dateFi){
        String tmpD = this.conversionDate(dateDeb);
        String tmpF = this.conversionDate(dateFi);
        boolean verif = true;
        LocalDate dateD = LocalDate.parse(tmpD);
        LocalDate dateF = LocalDate.parse(tmpF);
        if (dateD.compareTo(dateF) > 0){
            verif = false;
            //messageErreur += "Erreur, date de dÃ©but plus rÃ©cente que date de fin.";
        }
        return verif;
    }
    
    public boolean verifDateDebut(String dateDeb){
        String tmp = this.conversionDate(dateDeb);
        boolean verif = true;
        LocalDate dateD = LocalDate.parse(tmp);
        LocalDate curDate = LocalDate.now();
        if (dateD.compareTo(curDate) < 0){
            verif = false;
            //messageErreur += "Erreur, date de dÃ©but infÃ©rieure Ã  la date actuelle.";
        }
        return verif;
    }
    
    public String tournoiToString(){
        return "Tournoi : " + nomTournoi + System.getProperty("line.separator") +
               "Date de début : " + dateDebut + " Date de fin : " + dateFin + System.getProperty("line.separator") +
               "Nombre de rondes : " + nbRondes + System.getProperty("line.separator") +
               "Lieu : " + lieu;
    }
    
    public void setJoueurs(ArrayList<Joueurs> jList){
        this.joueurs = jList;
    }
    
    public ArrayList<Joueurs> getJoueurs(){
        return this.joueurs;
    }
    public String TtoString(){
        return  "Nom tournoi : " + this.nomTournoi +System.getProperty("line.separator")+
                "Date de début : " + this.dateDebut +System.getProperty("line.separator")+ 
                "Date de fin : " + this.dateFin +System.getProperty("line.separator")+
                "Nombre de rondes : " + this.nbRondes +System.getProperty("line.separator")+
                "Lieu : "+ this.lieu +System.getProperty("line.separator");
    }
}