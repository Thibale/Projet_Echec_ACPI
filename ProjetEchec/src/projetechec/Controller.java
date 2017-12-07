package projetechec;

import java.util.ArrayList;

public class Controller {
    
    public static XML xmlJoueur = new XML();
    public static XMLTournoi xmlTournoi = new XMLTournoi();
    
    public static int idTournoiCourant = -1;
    public static int idJoueurDedans = -1;
    public static int idJoueurDehors = -1;
    public static ArrayList<Joueurs> joueursDedans;
    public static ArrayList<Joueurs> joueursDehors;
    
    public static boolean ajoutJoueurToTournoiConfirmed = false;
}
