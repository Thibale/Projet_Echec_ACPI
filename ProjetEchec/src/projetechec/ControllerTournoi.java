/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetechec;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;
import java.util.logging.Level;
/**
 *
 * @author User
 */
public class ControllerTournoi {
    
    
    public static XML xmlJoueur = new XML();
    public static XMLTournoi xmlTournoi = new XMLTournoi();
    
    
    //renvoie la liste String des tournois, passée en static pour être utilisé par l'interface graphique, à regarder
    public static String SelectionTournoiS(){
        String res ="" ;
        ArrayList<Tournoi> listT = xmlTournoi.ReadXML();
        DefaultListModel listM = new DefaultListModel();
        String tmpList = "";
        for (int i=0;i<listT.size();i++){
            res=res+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
            tmpList =(i+1)+" Tournoi n°"+(i+1)+" "+listT.get(i).getNomTournoi();
            listM.addElement(tmpList);
            res=res+listT.get(i).TtoString()+System.getProperty("line.separator");
        }
        return res;
    } 
    
    //renvoie la liste DefaultListModel des tournois, passée en static pour être utilisé par l'interface graphique, à regarder
    public static DefaultListModel SelectionTournoiT(){
        DefaultListModel res ;
        ArrayList<Tournoi> listT = xmlTournoi.ReadXML();
        DefaultListModel listM = new DefaultListModel();
                String tmpList = "";
        for (int i=0;i<listT.size();i++){
            tmpList =(i+1)+" Tournoi n°"+(i+1)+" "+listT.get(i).getNomTournoi();
            listM.addElement(tmpList);
        }
        return listM;
    }
    //Réalise l'eregistrement d'un tournoi et renvois la chaine de carctère pour les erreurs ainsi que les codes d'erreur pour les labels graphiques
    public static String[] enregistrerTournoi(String nomTournoi,String dateDebut,String dateFin,String nbRondes,String lieu){
        Tournoi t = new Tournoi(nomTournoi,dateDebut,dateFin,nbRondes,lieu);
        boolean test = true ;
        String stmp[] = new String[7];
        stmp[0] = "Données incorrectes: ";
        stmp[1] = "0";
        stmp[2] = "0";
        stmp[3] = "0";
        stmp[4] = "0";
        stmp[5] = "0";
        stmp[6] = "0";
        if(!t.verifDonneesSensiblesCompletes())
        {
            test= false;
            if(t.nomTournoiEstVide()){
                stmp[1] = "1";
                stmp[0] += System.getProperty("line.separator")+"Nom Tournoi manquant";
            }
            if(t.dateDebutEstVide()){
                stmp[2] = "1";
                stmp[0] += System.getProperty("line.separator")+"Date de début manquante";
            }
            if(t.dateFinEstVide()){
                stmp[3] = "1";
                stmp[0] += System.getProperty("line.separator")+"Date de fin manquante";
            }
            if(t.nbRondesEstVide()){
                stmp[4] = "1";
                stmp[0] += System.getProperty("line.separator")+"Nombre de rondes manquant";
            }
        }
        if(!t.verifTailleNomTournoi()){
            stmp[5] = "1";
            stmp[0] += System.getProperty("line.separator")+"Nom de tournoi limité à 50 caractères.";
        }
        if(!t.verifFormatDateValide(dateDebut))
        {
            test= false;
            if(!t.verifMatchDate(dateDebut)){
                stmp[6] = "1";
                stmp[0] += System.getProperty("line.separator")+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!t.verifDateValide(dateDebut)){
                    stmp[6] = "1";
                    stmp[0] += System.getProperty("line.separator")+"Erreur, date incorrecte";
                }
            }
        }
        if(!t.verifFormatDateValide(dateFin))
        {
            test= false;
            if(!t.verifMatchDate(dateFin)){
                stmp[6] = "1";
                stmp[0] += System.getProperty("line.separator")+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!t.verifDateValide(dateFin)){
                    stmp[6] = "1";
                    stmp[0] += System.getProperty("line.separator")+"Erreur, date incorrecte";
                }
            }
        }
        if(t.verifFormatDateValide(dateDebut) && t.verifFormatDateValide(dateFin)){
            if(!t.verifDateDebut(dateDebut)){
                test= false;
                stmp[6] = "1";
                stmp[0] += System.getProperty("line.separator")+"Erreur, date de début infèrieure à la date actuelle.";
            }
            if(!t.verifDateDebutAvantDateFin(dateDebut, dateFin)){
                test= false;
                stmp[0] += System.getProperty("line.separator")+"Erreur, date de début plus récente que date de fin.";
            }
        }
        if(!t.verifNbRondes()){
            test = false;
            stmp[0] += System.getProperty("line.separator")+"Erreur, le nombre de rondes doit être positif.";
        }
        if(test){
            stmp[0] ="Tournoi créé avec succès !";       
            xmlTournoi.WriteXML(t);
        }
        return stmp;
    }
    //retourne le string d'un tournoi dont l'id est passé en paramêtre
    public static String[] selectionTournoiJoueur(String Tournoi){
        ArrayList<Tournoi> listT = xmlTournoi.ReadXML();
        String[] res = new String[3];
        res[2] = "0";
        if(Tournoi != null && !Tournoi.isEmpty()){
            res[2] = "1";
            res[1] = Tournoi.split(" ")[0];
            res[0] = listT.get(Integer.valueOf(res[1])-1).TtoString()+System.getProperty("line.separator");
        }
        return res;
    }
    //Permet l'enregistrement d'un joueur dans un tournoi
    public static String ajoutJoueurTournoi(ArrayList<Joueurs> listeJ,  int idT){
        String res = "Enregistrement confirmé";
        xmlTournoi.ecrireJoueurDansTournoi(listeJ, idT);
        return res;
    }
    
    //permet de supprimer un tournoi dont l'id est passé en paramêtre
    public static DefaultListModel supprimerTournoi(String Tournoi){ //ligne 2000 environ
        if(Tournoi != null && !Tournoi.isEmpty()){
            int intTmp = Integer.valueOf(Tournoi.split(" ")[0]);
            try { 
                xmlTournoi.supprimerTournoi(intTmp);
            } catch (TransformerException ex) {
                Logger.getLogger(ControllerTournoi.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Tournoi> listT = xmlTournoi.ReadXML();
            DefaultListModel listM = new DefaultListModel();
            String tmp="";
            String tmpList = "";
            for (int i=0;i<listT.size();i++){
                tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
                tmpList =(i+1)+" Tournoi n°"+(i+1)+" "+listT.get(i).getNomTournoi();
                listM.addElement(tmpList);
            }
            return listM;
        }
        return null;
    }
    //permet de retourner le tournoi qui va être modifier
    public static Tournoi modifierTournoi(String Tournoi){ //ligne 2030 environ
        ArrayList<Tournoi> listT = xmlTournoi.ReadXML();
            int intTmp = -1;
            if(Tournoi != null && !Tournoi.isEmpty()){
                intTmp = Integer.valueOf(Tournoi.split(" ")[0]);

            }
            if(intTmp != -1){
                //Faut pas faire comme ça faut créer un nouveau pannel
                xmlTournoi.modifierTournoi(intTmp, listT.get(intTmp-1));
                return listT.get(intTmp-1);
            }
        
        return null;
    }
    
    public static int modifierTournoiIntTmp(String Tournoi){
        ArrayList<Tournoi> listT = xmlTournoi.ReadXML();
            int intTmp = -1;
            if(Tournoi != null && !Tournoi.isEmpty()){
                intTmp = Integer.valueOf(Tournoi.split(" ")[0]);

            }
            return intTmp;
    }
    
    public static ArrayList<Joueurs> getJoueursTournoi(int idT){
        ArrayList<Joueurs> listJ = xmlTournoi.getJoueursFromTournoi(idT);
        return listJ;
    }
    public static DefaultListModel selectionTournoiAjoutJ(int idT){
        ArrayList<Joueurs> listJ = getJoueursTournoi( idT);
        DefaultListModel listM = new DefaultListModel();
        String tmp="";
        String tmpList = "";
        for (int i=0;i<listJ.size();i++){
            //tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
            tmpList =(i+1)+" "+listJ.get(i).getNumLicenceJ()+ " " +listJ.get(i).getNomJ()+ " " +listJ.get(i).getPrenomJ();
            listM.addElement(tmpList);
        }
        return listM;
    }
    
}
