package projetechec;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;

public class ProjetEchec {
    
    
    public static void main(String[] args) {

    /*java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new MainMenu().setVisible(true);
        }
    })
    ;
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new NewJFrame().setVisible(true);
        }
    });
  /* int numero=0;
   Joueurs j = new Joueurs(numero+=1,"294J","Falcone","Tibo",1234,5678,9101,"2006-01-01",'H',"Fr","ligue","nimes");
   Joueurs j2 = new Joueurs(numero+=1,"293J","Bert","Flo",1264,5698,3101,"1969-01-01",'F',"Fr","ligue","nimes");

   XML xml1 = new XML();
   xml1.WriteXML(j);
   xml1.WriteXML(j2);
   ArrayList<Joueurs> aj = new ArrayList<Joueurs>();
   aj=xml1.ReadXML();
   for (int i=0;i<aj.size();i++){
       aj.get(i).JtoString();
    /*XMLTournoi xml = new XMLTournoi();
/*        XMLTournoi xml = new XMLTournoi();
    String s = "";
    Tournoi t = new Tournoi("NomNom", "1990-09-09", "1999-06-10", 2, "Tonnerre");
    xml.WriteXML(t);
    ArrayList<Tournoi> at = new ArrayList<Tournoi>();
    at=xml.ReadXML();
    for (int i=0;i<at.size();i++){
        s+= at.get(i).tournoiToString();
    }*/
    //System.out.println(s);
    XML xml1 = new XML();
    /*try {
        xml1.supprimerJoueur(2);
    } catch (TransformerException ex) {
        Logger.getLogger(ProjetEchec.class.getName()).log(Level.SEVERE, null, ex);
    }*/
    Joueurs j = xml1.getJoueur(2);
    System.out.println(j.JtoString());
    }
    //System.out.println(s);
}