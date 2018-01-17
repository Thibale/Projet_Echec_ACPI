package projetechec;

import java.util.ArrayList;
import java.util.Map;

public class ControllerBD {
    private static final ConnexionBD CONNEXION_BD = new ConnexionBD();

    public void CreerJoueur(Map<String, String> informationsJoueur){
        CONNEXION_BD.insertJoueur(informationsJoueur);
    }

    public ArrayList<Map<String, String>> lireJoueurs(){
        return CONNEXION_BD.selectAllJoueurs();
    }

    public void modifierJoueur(int id, Map<String, String> informationsJoueur){
        CONNEXION_BD.updateJoueur(id, informationsJoueur);
    }

    public void supprimerJoueur(int id){
        CONNEXION_BD.deleteJoueur(id);
    }

    public void CreerTournoi(Map<String, String> informationsTournoi){
        CONNEXION_BD.insertTournoi(informationsTournoi);
    }

    public ArrayList<Map<String, String>> lireTournois(){
        return CONNEXION_BD.selectAllTournois();
    }
    
    public String getNomTournoiCourant(int id){
        return CONNEXION_BD.nomTournoiCourant(id);
    }

    public void modifierTournoi(int id, Map<String, String> informationsTournoi){
        CONNEXION_BD.updateTournoi(id, informationsTournoi);
    }

    public void supprimerTournoi(int id){
        CONNEXION_BD.deleteTournoi(id);
    }

    public void CreerParticipation(int idJoueur, int idTournoi){
        CONNEXION_BD.insertParticiper(idJoueur, idTournoi);
    }

    public void resetParticipation(int idTournoi){
        CONNEXION_BD.deleteAllParticipationTournoi(idTournoi);
    }

    public void supprimerParticipation(int idJoueur, int idTournoi){
        CONNEXION_BD.deleteParticiper(idJoueur, idTournoi);
    }

    public ArrayList<Map<String, String>> recupererJoueursTournoi(int idTournoi){
        return CONNEXION_BD.selectJoueursFromTournoi(idTournoi);
    }

    public int recupererNombreParticipation(int idTournoi){
        return CONNEXION_BD.getNombreParticipants(idTournoi);
    }

    public String[] getAllRondes(int idTournoi){
        ArrayList<String> array = CONNEXION_BD.getAllRondes(idTournoi);
        String[] string = new String[array.size()+1];
        for (int i = 0; i<array.size(); i++) {
            string[i] = array.get(i);
        }
        string[array.size()] = String.valueOf(array.size()+1);
        return string;
    }

    public boolean checkExistingRonde(int idTournoi, int idRonde){
        int compteur = CONNEXION_BD.countSpecificRonde(idTournoi, idRonde);
        boolean result;
        if(compteur > 0){
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}
