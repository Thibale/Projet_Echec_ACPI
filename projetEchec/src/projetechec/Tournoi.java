package projetechec;

import java.util.List;
import java.util.Map;

public class Tournoi {
    
    private int idT;
    private String nomTournoi;
    private String dateDebut;
    private String dateFin;
    private int nbRondes;
    private String lieu;
    private List<Joueurs> joueurs;
    
    public Tournoi(Map<String, String> informations){
        if(informations.get("id") != null && !informations.get("id").isEmpty()){
            idT = Integer.valueOf(informations.get("id"));
        }
        nomTournoi=informations.get("nom");
        dateDebut=informations.get("dateDebut");
        dateFin=informations.get("dateFin");
        if(!(informations.get("nbRondes").isEmpty())){
            try{
                nbRondes=Integer.valueOf(informations.get("nbRondes"));
            }catch(java.lang.NumberFormatException e){
                nbRondes = 0;
            }
        }else{
            nbRondes = 0;
        }
        
        lieu=informations.get("lieu");
    }

    
    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
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
    
    public void setJoueurs(List<Joueurs> jList){
        this.joueurs = jList;
    }
    
    public List<Joueurs> getJoueurs(){
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