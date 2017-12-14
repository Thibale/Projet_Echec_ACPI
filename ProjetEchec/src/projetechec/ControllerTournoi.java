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
    
}
