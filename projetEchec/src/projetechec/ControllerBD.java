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
    
    public void modifierTournoi(int id, Map<String, String> informationsTournoi){
        CONNEXION_BD.updateTournoi(id, informationsTournoi);
    }
    
    public void supprimerTournoi(int id){
        CONNEXION_BD.deleteTournoi(id);
    }
    
    public void CreerParticipation(int idJoueur, int idTournoi){
        CONNEXION_BD.insertParticiper(idJoueur, idTournoi);
    }
    
    public void supprimerParticipation(int idJoueur, int idTournoi){
        CONNEXION_BD.deleteParticiper(idJoueur, idTournoi);
    }
    
    public ArrayList<Map<String, String>> recupererJoueursTournoi(int idTournoi){
        return CONNEXION_BD.selectJoueursFromTournoi(idTournoi);
    }

}
