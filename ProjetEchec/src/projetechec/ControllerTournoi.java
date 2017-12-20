package projetechec;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ControllerTournoi {
    
    private static final ControllerBD CONTROLLER_BD = new ControllerBD();
    
    public static int idTournoiCourant = -1;

    public static int idJoueurDedans = -1;
    public static int idJoueurDehors = -1;
    public static ArrayList<Joueurs> joueursDedans;
    public static ArrayList<Joueurs> joueursDehors;
    
    //Réalise l'eregistrement d'un tournoi et renvois la chaine de carctère pour les erreurs ainsi que les codes d'erreur pour les labels graphiques
    public boolean enregistrerTournoi(Map<String, String> infosTournoi,  JLabel nomTournoiLabel, JLabel dateDebutLabel, JLabel dateFinLabel, JLabel nbRondesLabel, JTextArea retour){
        Tournoi t = new Tournoi(infosTournoi);
        boolean verif = allVerifTournoi(t, nomTournoiLabel, dateDebutLabel, dateFinLabel, nbRondesLabel, retour);        
        if(verif){
            CONTROLLER_BD.CreerTournoi(infosTournoi);
        }
        return verif;
    }
    
    //Contient toutes les verification
    //<editor-fold defaultstate="collapsed" desc="Verifications">
    
    //Vérifie que les données obligatoires du tournoi ont bien été rentrée
    public boolean verifDonneesSensiblesCompletes(Tournoi t){ 
        boolean verif = true;
        if(stringEstVide(t.getNomTournoi())){
            verif = false;
        }
        if(stringEstVide(t.getDateDebut())){
            verif = false;
        }
        if(stringEstVide(t.getDateFin())){
            verif = false;
        }
        if(t.getNbRondes() == 0){
            verif = false;
        }
        return verif;
    }
    
    //Verifie que la chaine est vide
    public boolean stringEstVide(String chaineTester){
        return "".equals(chaineTester);
    }
    
    //Vérifie que la taille du nom du tournoi ne dépasse pas 50 caractères
    public boolean verifTailleNomTournoi(String chaineTester){
        boolean verif = true;
        if(chaineTester.length() > 50){
            verif = false;
        }
        return verif;
    }
    
    //Vérifie que le nombre de rondes est positif
    public boolean verifNbRondes(int nbRondes){
        boolean verif = true;
        if(nbRondes < 0){
            verif = false;
        }
        return verif;
    }
    
    //Convertie la date au format AAAA-MM-JJ
    public String conversionDate(String date){
        String tmp = "";
        tmp = tmp + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);
        tmp += "-";
        tmp = tmp + date.charAt(3) + date.charAt(4);
        tmp += "-";
        tmp = tmp + date.charAt(0) + date.charAt(1);
        
        return tmp;
    }
    
    //Verifier que la date soit au bon format (00/00/0000)
    public boolean verifMatchDate(String date){
        return date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"); 
    }
    
    //Verifier que la date existe
    public boolean verifDateValide(String date){
        String tmp = this.conversionDate(date);
        boolean checkFormat = true;
        Date datetmp = null;
        String format = "yyyy-MM-dd";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            datetmp = sdf.parse(tmp);
            if (!tmp.equals(sdf.format(datetmp))) {
                datetmp = null;
            }
        } catch (ParseException ex) {
        }
        if (datetmp == null) {
            checkFormat = false;
        }
        return checkFormat;
    }
    
    //Test avec les fonctions format date
    public boolean verifFormatDateValide(String date){
        boolean checkFormat;

        checkFormat = this.verifMatchDate(date);
        
        if(checkFormat){
            checkFormat = this.verifDateValide(date);
        }
        return checkFormat;
    }
    
    //Vérifie que la date de début est plus ancienne que la date de fin
    public boolean verifDateDebutAvantDateFin(String dateDeb, String dateFi){
        String tmpD = this.conversionDate(dateDeb);
        String tmpF = this.conversionDate(dateFi);
        boolean verif = true;
        LocalDate dateD = LocalDate.parse(tmpD);
        LocalDate dateF = LocalDate.parse(tmpF);
        if (dateD.compareTo(dateF) > 0){
            verif = false;
        }
        return verif;
    }
    
    //Vérifie que la date de début n'est pas encore passée
    public boolean verifDateDebut(String dateDeb){
        String tmp = this.conversionDate(dateDeb);
        boolean verif = true;
        LocalDate dateD = LocalDate.parse(tmp);
        LocalDate curDate = LocalDate.now();
        if (dateD.compareTo(curDate) < 0){
            verif = false;
        }
        return verif;
    }
    
    //Instancie toutes les vérifications du tournoi
    public boolean allVerifTournoi(Tournoi t, JLabel nomTournoiLabel, JLabel dateDebutLabel, JLabel dateFinLabel, JLabel nbRondesLabel, JTextArea retour){
        String stmp="Données incorrectes: ";
        boolean verif = true;
        if(!verifDonneesSensiblesCompletes(t)){
            verif = false;
            if(stringEstVide(t.getNomTournoi())){
                nomTournoiLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Nom Tournoi manquant";
            }
            if(stringEstVide(t.getDateDebut())){
                dateDebutLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Date de début manquante";
            }
            if(stringEstVide(t.getDateFin())){
                dateFinLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Date de fin manquante";
            }
            if(t.getNbRondes() == 0){
                nbRondesLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Nombre de rondes manquant";
            }
        }
        if(!verifTailleNomTournoi(t.getNomTournoi())){
            verif = false;
            nomTournoiLabel.setForeground(Color.red);
            stmp += System.lineSeparator()+"Nom de tournoi limité à 50 caractères.";
        }
        if(!verifFormatDateValide(t.getDateDebut())){
            verif = false;
            dateDebutLabel.setForeground(Color.red);
            if(!verifMatchDate(t.getDateDebut())){
                stmp += System.lineSeparator()+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!verifDateValide(t.getDateDebut())){
                    stmp += System.lineSeparator()+"Erreur, date incorrecte";
                }
            }
        }
        if(!verifFormatDateValide(t.getDateFin())){
            verif= false;
            dateFinLabel.setForeground(Color.red);
            if(!verifMatchDate(t.getDateFin())){
                stmp += System.lineSeparator()+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!verifDateValide(t.getDateFin())){
                    stmp += System.lineSeparator()+"Erreur, date incorrecte";
                }
            }
        }
        if(verifFormatDateValide(t.getDateDebut()) && verifFormatDateValide(t.getDateFin())){
            if(!verifDateDebut(t.getDateDebut())){
                verif= false;
                stmp += System.lineSeparator()+"Erreur, date de début infèrieure à la date actuelle.";
            }
            if(!verifDateDebutAvantDateFin(t.getDateDebut(), t.getDateFin())){
                verif = false;
                stmp += System.lineSeparator()+"Erreur, date de début plus récente que date de fin.";
            }
        }
        if(!verifNbRondes(t.getNbRondes())){
            verif = false;
            stmp += System.lineSeparator()+"Erreur, le nombre de rondes doit être positif.";
        }
        
        retour.setText(stmp);
        
        return verif;
    }
    //</editor-fold>
    
    public void tournoiListGetSelectedTournoi(JList tournoiList){
        String s = (String) tournoiList.getSelectedValue();
        if(s != null && !s.isEmpty()){
            idTournoiCourant = Integer.valueOf(s.split(" ")[0]);
        }
    }
    
    //Appelle la base pour récupérer les tournoi
    public static ArrayList<Tournoi> lireTournois(){
        ArrayList<Tournoi> listTournoi = new ArrayList<>();
        
        ArrayList<Map<String, String>> listInfosTournois = CONTROLLER_BD.lireTournois();
        
        for(int i = 0; i < listInfosTournois.size() ; i++){
            Tournoi t= new Tournoi(listInfosTournois.get(i));
                
            listTournoi.add(t);
        }

        return listTournoi;
    }
    
    //Appelle la base pour récupérer les joueurs
    public ArrayList<Joueurs> lireJoueursFromTournoi(int idTournoi){
        ArrayList<Joueurs> listJoueurs=new ArrayList<>();
        
        ArrayList<Map<String, String>> listInfosJoueurs = CONTROLLER_BD.recupererJoueursTournoi(idTournoi);
        
        for(int i = 0; i < listInfosJoueurs.size() ; i++){
            Joueurs jtmp= new Joueurs(listInfosJoueurs.get(i));
                
            listJoueurs.add(jtmp);
        }

        return listJoueurs;
    }
    
    //renvoie la liste DefaultListModel des tournois
    public static DefaultListModel setTournoisInListModel(JTextArea textArea){
        String text = new String();
        ArrayList<Tournoi> listT = lireTournois();
        DefaultListModel listM = new DefaultListModel();
        String tmpList;
        for (int i=0;i<listT.size();i++){
            text = text + " Tournoi n°"+(i+1)+System.lineSeparator();
            text = text +listT.get(i).TtoString()+System.lineSeparator();
            tmpList =(listT.get(i).getIdT())+" "+listT.get(i).getNomTournoi();
            listM.addElement(tmpList);
        }
        return listM;
    }
    
    //Place les informations du tournoi dans le champ de texte
    public void setInfoTournoiInTextArea(JTextArea textArea){
        if(idTournoiCourant != -1){
            ArrayList<Tournoi> listT = lireTournois();
            boolean trouve = false;
            int i = -1;
            while(!trouve && i < listT.size()-1){
                i++;
                if(listT.get(i).getIdT() == idTournoiCourant){
                    trouve = true;
                }
            }
            String afftmp = listT.get(i).TtoString()+System.lineSeparator();
            textArea.setText(afftmp);
        }
    }
    
    //Met en place les joueur dans les list de l'interface
    public void setAjoutJoueursInTournoiJList(JList listJoueursDedans, JList listJoueursDehors){
        ArrayList<Joueurs> listJoueursDuTournoi = lireJoueursFromTournoi(ControllerTournoi.getIdTournoiCourant());
        DefaultListModel listM = new DefaultListModel();
        listJoueursDedans.setModel(listM);
        String tmpList;
        //Créé une list avec les joueurs déjà présent dans le tournoi
        for (int i=0;i<listJoueursDuTournoi.size();i++){
            tmpList =(listJoueursDuTournoi.get(i).getIdJ())+" "+listJoueursDuTournoi.get(i).getNumLicenceJ()+ " " +listJoueursDuTournoi.get(i).getNomJ()+ " " +listJoueursDuTournoi.get(i).getPrenomJ();
            listM.addElement(tmpList);
        }
        
        //récupèration des id des joueurs présent dans le tournoi
        ArrayList<Joueurs> listJoueurEnDehors = ControllerJoueur.lireJoueur();
        ArrayList<Integer> toRemove = new ArrayList<>();
        for (Joueurs joueur : listJoueursDuTournoi) {
            for (int i = 0; i<listJoueurEnDehors.size(); i++){
                if(!"".equals(joueur.getNumLicenceJ())){
                    if(joueur.getNumLicenceJ().equals(listJoueurEnDehors.get(i).getNumLicenceJ())){
                        toRemove.add(i);
                    }
                }else{
                    if(joueur.getNomJ().equals(listJoueurEnDehors.get(i).getNomJ()) && joueur.getPrenomJ().equals(listJoueurEnDehors.get(i).getPrenomJ()) && joueur.getDateNaisJ().equals(listJoueurEnDehors.get(i).getDateNaisJ())){
                        toRemove.add(i);
                    }
                }
            }
        }
        Collections.sort(toRemove);
        for (int i = toRemove.size()-1; i >= 0; i--){
            int integer = toRemove.get(i);
            Joueurs j = listJoueurEnDehors.get(integer);
            listJoueurEnDehors.remove(j);
        }
        
        //Créé la list des joueurs hors du tournoi
        DefaultListModel listM2 = new DefaultListModel();
        listJoueursDehors.setModel(listM2);
        String tmpList2;
        for (int i=0;i<listJoueurEnDehors.size();i++){
            tmpList2 =(listJoueurEnDehors.get(i).getIdJ())+" "+listJoueurEnDehors.get(i).getNumLicenceJ()+ " " +listJoueurEnDehors.get(i).getNomJ()+ " " +listJoueurEnDehors.get(i).getPrenomJ();
            listM2.addElement(tmpList2);
        }
        joueursDedans = listJoueursDuTournoi;
        joueursDehors = listJoueurEnDehors;
    }
    
    //récupère l'id du joueur séléctionné
    public void tournoiListGetSelectedJoueurDedans(JList joueurList){
        String s = (String) joueurList.getSelectedValue();
        if(s != null && !s.isEmpty()){
            idJoueurDedans = Integer.valueOf(s.split(" ")[0]);
        }
    }
    
    //récupère l'id du joueur séléctionné
    public void tournoiListGetSelectedJoueurDehors(JList joueurList){
        String s = (String) joueurList.getSelectedValue();
        if(s != null && !s.isEmpty()){
            idJoueurDehors = Integer.valueOf(s.split(" ")[0]);
        }
    }
    
    public void ajoutJoueurToTournoiList(JList dedans, JList dehors){
        if(idJoueurDehors != -1){
            joueursDedans.add(getJoueurFromId(joueursDehors, idJoueurDehors));
            joueursDehors.remove(getJoueurFromId(joueursDehors, idJoueurDehors));
            
            DefaultListModel listM = new DefaultListModel();
            dedans.setModel(listM);
            String tmpList;
            for (int i = 0; i < joueursDedans.size();i++){
                tmpList =(joueursDedans.get(i).getIdJ())+" "+joueursDedans.get(i).getNumLicenceJ()+ " " +joueursDedans.get(i).getNomJ()+ " " +joueursDedans.get(i).getPrenomJ();
                listM.addElement(tmpList);
            }
            
            DefaultListModel listM2 = new DefaultListModel();
            dehors.setModel(listM2);
            String tmpList2;
            for (int i = 0; i < joueursDehors.size();i++){
                tmpList2 =(joueursDehors.get(i).getIdJ())+" "+joueursDehors.get(i).getNumLicenceJ()+ " " +joueursDehors.get(i).getNomJ()+ " " +joueursDehors.get(i).getPrenomJ();
                listM2.addElement(tmpList2);
            }
            
            idJoueurDehors = -1;
            idJoueurDedans = -1;
            MenuPrincipal.confirmed = false;
        }
    }
    
    public void retireJoueurToTournoiList(JList dedans, JList dehors){
        if(idJoueurDedans != -1){
            joueursDehors.add(getJoueurFromId(joueursDedans, idJoueurDedans));
            joueursDedans.remove(getJoueurFromId(joueursDedans, idJoueurDedans));
            
            DefaultListModel listM = new DefaultListModel();
            dehors.setModel(listM);
            String tmpList;
            for (int i=0;i<joueursDehors.size();i++){
                tmpList =(joueursDehors.get(i).getIdJ())+" "+joueursDehors.get(i).getNumLicenceJ()+ " " +joueursDehors.get(i).getNomJ()+ " " +joueursDehors.get(i).getPrenomJ();
                listM.addElement(tmpList);
            }
            
            DefaultListModel listM2 = new DefaultListModel();
            dedans.setModel(listM2);
            String tmpList2;
            for (int i=0;i<joueursDedans.size();i++){
                tmpList2 =(joueursDedans.get(i).getIdJ())+" "+joueursDedans.get(i).getNumLicenceJ()+ " " +joueursDedans.get(i).getNomJ()+ " " +joueursDedans.get(i).getPrenomJ();
                listM2.addElement(tmpList2);
            }
            
            idJoueurDedans = -1;
            idJoueurDehors = -1;
            MenuPrincipal.confirmed = false;
        }
    }
    
    //Permet l'enregistrement d'un joueur dans un tournoi
    public void ajoutJoueursTournoi(){
        CONTROLLER_BD.resetParticipation(idTournoiCourant);
        for(int i = 0; i < joueursDedans.size(); i++){
            CONTROLLER_BD.CreerParticipation(joueursDedans.get(i).getIdJ(), idTournoiCourant);
        }
    }
    
    //Supprime le tournoi
    public void supprimerTournoiSelectionne(){
        CONTROLLER_BD.supprimerJoueur(idTournoiCourant);
    }
    
    //Met les information d'un joueur dans une HashMap
    public static Map<String, String> getInfosTournoi(Tournoi tournoi){
        Map<String, String> map = new HashMap<>();
        
        map.put("nom", tournoi.getNomTournoi());
        map.put("dateDebut", tournoi.getDateDebut());
        map.put("dateFin", tournoi.getDateFin());
        map.put("nbRondes", String.valueOf(tournoi.getNbRondes()));
        map.put("lieu", tournoi.getLieu());
        
        return map;
    }
    
    public static Map<String, String> getInfoTournoiCourant(){
        if(idTournoiCourant != -1){
            ArrayList<Tournoi> listT = lireTournois();
            boolean trouve = false;
            int i = -1;
            while(!trouve && i < listT.size()-1){
                i++;
                if(listT.get(i).getIdT() == idTournoiCourant){
                    trouve = true;
                }
            }
            return getInfosTournoi(listT.get(i));
        }
        else{
            return null;
        }
    }

    //Vérifie les modifications apportée et modifie le joueur dans la base
    public boolean modifieTournoi(Map<String, String> infosTournoi, JLabel nomLabel, JLabel prenomLabel, JLabel sexeLabel, JLabel dateLabel, JTextArea retour){
        Tournoi t = new Tournoi(infosTournoi);
        boolean verif = allVerifTournoi(t, nomLabel, prenomLabel, sexeLabel, dateLabel, retour);        
        
        if(verif){
            retour.setText("Tournoi modifié !");
            CONTROLLER_BD.modifierTournoi(ControllerTournoi.getIdTournoiCourant(), getInfosTournoi(t));
        }
        return verif;
    }
    
    public static int getIdTournoiCourant() {
        return idTournoiCourant;
    }

    public static void setIdTournoiCourant(int idTournoiCourant) {
        ControllerTournoi.idTournoiCourant = idTournoiCourant;
    }

    public Joueurs getJoueurFromId(ArrayList<Joueurs> joueurs, int id){
        boolean trouve = false;
        int i = -1;
        while(!trouve && i < joueurs.size()-1){
            i++;
            if(joueurs.get(i).getIdJ() == id){
                return joueurs.get(i);
            }
        }
        return new Joueurs();        
    }
    
    
}
