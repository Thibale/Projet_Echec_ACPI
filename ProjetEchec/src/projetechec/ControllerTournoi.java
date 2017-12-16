/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetechec;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

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
    
    public static String ajoutJoueurTournoi(ArrayList<Joueurs> listeJ,  int idT){
        String res = "Enregistrement confirmé";
        xmlTournoi.ecrireJoueurDansTournoi(listeJ, idT);
        return res;
    }
    
}
