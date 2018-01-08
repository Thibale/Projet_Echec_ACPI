package projetechec;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ControllerTournoi {
    
    private static final ControllerBD CONTROLLER_BD = new ControllerBD();
    
    private static int idTournoiCourant = -1;

    private static int idJoueurDedans = -1;
    private static int idJoueurDehors = -1;
    private static ArrayList<Joueurs> joueursDedans;
    private static ArrayList<Joueurs> joueursDehors;
    
    //Réalise l'eregistrement d'un tournoi et renvois la chaîne de caractère pour les erreurs ainsi que les codes d'erreur pour les labels graphiques
    public boolean enregistrerTournoi(Map<String, String> infosTournoi,  JLabel nomTournoiLabel, JLabel dateDebutLabel, JLabel dateFinLabel, JLabel nbRondesLabel, JTextArea retour){
        Tournoi t = new Tournoi(infosTournoi);
        boolean verifications = allVerifTournoi(t, nomTournoiLabel, dateDebutLabel, dateFinLabel, nbRondesLabel, retour);
        if(verifications){
            CONTROLLER_BD.CreerTournoi(infosTournoi);
        }
        return verifications;
    }
    
    //Contient toutes les verification
    //<editor-fold defaultstate="collapsed" desc="Verifications">
    
    //Vérifie que les données obligatoires du tournoi ont bien été rentrée
    private boolean verificationDonneesSensiblesCompletes(Tournoi t){
        boolean verification = true;
        if(stringEstVide(t.getNomTournoi())){
            verification = false;
        }
        if(stringEstVide(t.getDateDebut())){
            verification = false;
        }
        if(stringEstVide(t.getDateFin())){
            verification = false;
        }
        if(t.getNbRondes() == 0){
            verification = false;
        }
        return verification;
    }
    
    //Vérifie que la chaîne est vide
    private boolean stringEstVide(String chaineTester){
        return "".equals(chaineTester);
    }
    
    //Vérifie que la taille du nom du tournoi ne dépasse pas 50 caractères
    private boolean verifTailleNomTournoi(String chaineTester){
        boolean verif = true;
        if(chaineTester.length() > 50){
            verif = false;
        }
        return verif;
    }
    
    //Vérifie que le nombre de rondes est positif
    private boolean verifNbRondes(int nbRondes){
        boolean verif = true;
        if(nbRondes < 0){
            verif = false;
        }
        return verif;
    }
    
    //Convertie la date au format AAAA-MM-JJ
    private String conversionDate(String date){
        String tmp = "";
        tmp = tmp + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);
        tmp += "-";
        tmp = tmp + date.charAt(3) + date.charAt(4);
        tmp += "-";
        tmp = tmp + date.charAt(0) + date.charAt(1);
        
        return tmp;
    }
    
    //Verifier que la date soit au bon format (00/00/0000)
    private boolean verifMatchDate(String date){
        return date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"); 
    }
    
    //Verifier que la date existe
    private boolean verifDateValide(String date){
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
    private boolean verifFormatDateValide(String date){
        boolean checkFormat;

        checkFormat = this.verifMatchDate(date);
        
        if(checkFormat){
            checkFormat = this.verifDateValide(date);
        }
        return checkFormat;
    }
    
    //Vérifie que la date de début est plus ancienne que la date de fin
    private boolean verifDateDebutAvantDateFin(String dateDeb, String dateFi){
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
    private boolean verifDateDebut(String dateDeb){
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
    private boolean allVerifTournoi(Tournoi t, JLabel nomTournoiLabel, JLabel dateDebutLabel, JLabel dateFinLabel, JLabel nbRondesLabel, JTextArea retour){
        String stmp="Données incorrectes: ";
        boolean verif = true;
        if(!verificationDonneesSensiblesCompletes(t)){
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
    private static ArrayList<Tournoi> lireTournois(){
        ArrayList<Tournoi> listTournoi = new ArrayList<>();
        
        ArrayList<Map<String, String>> listInfosTournois = CONTROLLER_BD.lireTournois();
        
        for(int i = 0; i < listInfosTournois.size() ; i++){
            Tournoi t= new Tournoi(listInfosTournois.get(i));
                
            listTournoi.add(t);
        }

        return listTournoi;
    }
    
    //Appelle la base pour récupérer les joueurs
    private ArrayList<Joueurs> lireJoueursFromTournoi(int idTournoi){
        ArrayList<Joueurs> listJoueurs=new ArrayList<>();
        
        ArrayList<Map<String, String>> listInfosJoueurs = CONTROLLER_BD.recupererJoueursTournoi(idTournoi);

        for (Map<String, String> listInfosJoueur : listInfosJoueurs) {
            Joueurs jtmp = new Joueurs(listInfosJoueur);

            listJoueurs.add(jtmp);
        }

        return listJoueurs;
    }
    
    //renvoie la liste DefaultListModel des tournois
    public static DefaultListModel setTournoisInListModel(JTextArea textArea){
        StringBuilder text = new StringBuilder();
        ArrayList<Tournoi> listT = lireTournois();
        DefaultListModel listM = new DefaultListModel();
        String tmpList;
        for (int i=0;i<listT.size();i++){
            text.append(" Tournoi n°").append(i + 1).append(System.lineSeparator());
            text.append(listT.get(i).TtoString()).append(System.lineSeparator());
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
        for (Joueurs aListJoueursDuTournoi : listJoueursDuTournoi) {
            tmpList = (aListJoueursDuTournoi.getIdJ()) + " " + aListJoueursDuTournoi.getNomJ() + " " + aListJoueursDuTournoi.getPrenomJ() + " " + aListJoueursDuTournoi.getNumLicenceJ();
            listM.addElement(tmpList);
        }
        
        //récupération des id des joueurs présent dans le tournoi
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
        for (Joueurs listJoueurEnDehor : listJoueurEnDehors) {
            tmpList2 = (listJoueurEnDehor.getIdJ()) + " " + listJoueurEnDehor.getNomJ() + " " + listJoueurEnDehor.getPrenomJ() + " " + listJoueurEnDehor.getNumLicenceJ();
            listM2.addElement(tmpList2);
        }
        joueursDedans = listJoueursDuTournoi;
        joueursDehors = listJoueurEnDehors;
    }
    
    //récupère l'id du joueur sélectionné
    public void tournoiListGetSelectedJoueurDedans(JList joueurList){
        String s = (String) joueurList.getSelectedValue();
        if(s != null && !s.isEmpty()){
            idJoueurDedans = Integer.valueOf(s.split(" ")[0]);
        }
    }
    
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
            for (Joueurs joueursDedan : joueursDedans) {
                tmpList = (joueursDedan.getIdJ()) + " " + joueursDedan.getNumLicenceJ() + " " + joueursDedan.getNomJ() + " " + joueursDedan.getPrenomJ();
                listM.addElement(tmpList);
            }
            
            DefaultListModel listM2 = new DefaultListModel();
            dehors.setModel(listM2);
            String tmpList2;
            for (Joueurs joueursDehor : joueursDehors) {
                tmpList2 = (joueursDehor.getIdJ()) + " " + joueursDehor.getNumLicenceJ() + " " + joueursDehor.getNomJ() + " " + joueursDehor.getPrenomJ();
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
            for (Joueurs joueursDehor : joueursDehors) {
                tmpList = (joueursDehor.getIdJ()) + " " + joueursDehor.getNumLicenceJ() + " " + joueursDehor.getNomJ() + " " + joueursDehor.getPrenomJ();
                listM.addElement(tmpList);
            }
            
            DefaultListModel listM2 = new DefaultListModel();
            dedans.setModel(listM2);
            String tmpList2;
            for (Joueurs joueursDedan : joueursDedans) {
                tmpList2 = (joueursDedan.getIdJ()) + " " + joueursDedan.getNumLicenceJ() + " " + joueursDedan.getNomJ() + " " + joueursDedan.getPrenomJ();
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
        for (Joueurs joueursDedan : joueursDedans) {
            CONTROLLER_BD.CreerParticipation(joueursDedan.getIdJ(), idTournoiCourant);
        }
    }
    
    //Supprime le tournoi
    public void supprimerTournoiSelectionne(){
        CONTROLLER_BD.supprimerJoueur(idTournoiCourant);
    }
    
    //Met les information d'un joueur dans une HashMap
    private static Map<String, String> getInfosTournoi(Tournoi tournoi){
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

    public static int getNombreParticipants(){
        return CONTROLLER_BD.recupererNombreParticipation(idTournoiCourant);
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

    private Joueurs getJoueurFromId(ArrayList<Joueurs> joueurs, int id){
        boolean trouve = false;
        int i = -1;
        while(!trouve && i < joueurs.size()-1){
            i++;
            if(joueurs.get(i).getIdJ() == id){
                trouve = true;
            }
        }
        return joueurs.get(i);
    }
    
    public void creerPDFListeJoueurs(){
        try {
            ArrayList<Joueurs> ListeJoueurs = lireJoueursFromTournoi(idTournoiCourant);
            Document document = PDF.creerPDF();
            PDF.addContent(document, ListeJoueurs);
            PDF.close(document);
        } catch (DocumentException ex) {
            Logger.getLogger(ControllerTournoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
