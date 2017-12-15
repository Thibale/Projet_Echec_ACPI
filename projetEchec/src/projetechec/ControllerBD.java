package projetechec;

import java.util.ArrayList;

public class ControllerBD {
    private static ConnexionBD connexionBD = new ConnexionBD();
    
    public void CreerJoueur(String[] informationsJoueurs){
        connexionBD.insertJoueur(informationsJoueurs);
    }
    
    public ArrayList<String[]> lireJoueurs(){
        return connexionBD.selectAllJoueurs();
    }
    
    public void modifierJoueurs(int id, String[] informationsJoueurs){
        connexionBD.updateJoueur(id, informationsJoueurs);
    }
    
    public void supprimerJoueurs(int id){
        connexionBD.deleteJoueur(id);
    }
}
