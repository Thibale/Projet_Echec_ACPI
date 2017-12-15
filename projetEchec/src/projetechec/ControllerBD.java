package projetechec;

import java.util.ArrayList;
import java.util.Map;

public class ControllerBD {
    private static ConnexionBD connexionBD = new ConnexionBD();
    
    public void CreerJoueur(Map<String, String> informationsJoueurs){
        connexionBD.insertJoueur(informationsJoueurs);
    }
    
    public ArrayList<Map<String, String>> lireJoueurs(){
        return connexionBD.selectAllJoueurs();
    }
    
    public void modifierJoueurs(int id, Map<String, String> informationsJoueurs){
        connexionBD.updateJoueur(id, informationsJoueurs);
    }
    
    public void supprimerJoueurs(int id){
        connexionBD.deleteJoueur(id);
    }
}
