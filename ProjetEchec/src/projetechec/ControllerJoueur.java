package projetechec;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ControllerJoueur {
    
    public static XML xmlJoueur = new XML();
    public static XMLTournoi xmlTournoi = new XMLTournoi();
    
    public static int idTournoiCourant = -1;
    public static int idJoueurDedans = -1;
    public static int idJoueurDehors = -1;
    public static ArrayList<Joueurs> joueursDedans;
    public static ArrayList<Joueurs> joueursDehors;
    
    public static boolean ajoutJoueurToTournoiConfirmed = false;
    
    public Joueurs creerJoueur(String numLicence,String nom,String prenom,String numEloNormal,String numEloSemiRapide,String numEloRapide,String dateNais,String sexe,String federation,String ligue,String club){
        Joueurs j=new Joueurs(numLicence,nom, prenom, numEloNormal, numEloSemiRapide, numEloRapide, this.calculCategorie(sexe, dateNais), dateNais, sexe, federation, ligue, club);
        return j;
    }
    
    //Convert la date au format 0000-00-00
    public String conversionDate(String date){
        String tmp = "";
        if(date.length() >= 10){
            tmp = tmp + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);
            tmp += "-";
            tmp = tmp + date.charAt(3) + date.charAt(4);
            tmp += "-";
            tmp = tmp + date.charAt(0) + date.charAt(1);
        }
        return tmp;
    }
    
    //Verifier que le joueur est né
    public boolean verifDateNaiss(String dateNaissance){
        String tmp = this.conversionDate(dateNaissance);
        boolean verif = true;
        LocalDate dateNaiss = LocalDate.parse(tmp);
        LocalDate curDate = LocalDate.now();
        if (dateNaiss.compareTo(curDate) > 0){
            verif = false;
        }
        return verif;
    }
    
    //Verifier que la date soit au bon format (00/00/0000)
    public boolean verifMatchDate(String date){
        return date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"); 
    }
    
    //Verifier que la date existe
    public boolean verifDateValide(String date){
        String tmp =  this.conversionDate(date);
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
    
    //Verifier que le format du nom est correcte
    public boolean verifFormatNomValide(String chaineTester){
        boolean res = true;
        if(!chaineTester.matches("\\p{L}*\\s\\p{L}*") && !chaineTester.matches("\\p{L}*[-]\\p{L}*") && !chaineTester.matches("\\p{L}*")){
            res = false;
        }
        return res;
    }
    
    //Verifier que la taille du nom est correcte
    public boolean verifTailleNomJoueur(String chaineTester){
        boolean verif = true;
        if(chaineTester.length() > 50){
            verif = false;
        }
        return verif;
    }
    
    //Verifier que le format des elo est valide(3 à 4 chiffres et pas de lettres)
    public boolean verifFormatEloValide(String elo){
        boolean res = true;
        if("NC".equals(elo)){
            elo = "";
        }
        if(!"".equals(elo)){

            if((!elo.matches("[0-9]{4}") && !elo.matches("[0-9]{3}"))){
                res = false;
            }
        }
        return res;
    }
    
    //Verifier que le num Elo est positif
    public boolean verifFormatEloPositif(String elo){
        boolean res = true;
        if("NC".equals(elo)){
            elo = "";
        }
        if(!"".equals(elo)){
            if(!elo.matches("[^-]*")){
                res = false;
            }
        }
        return res;
    }
    
    //Verifier que le num Elo est compris entre 900 et 3000
    public boolean verifFormatElo900To3000(String elo){
        boolean res = true;
        if("NC".equals(elo)){
            elo = "";
        }
        if((!"".equals(elo)) && verifFormatEloValide(elo)){
            if(Integer.valueOf(elo) < 900 || Integer.valueOf(elo) > 3000){
                res = false;
            }
        }
        return res;
    }
    
    //Verifier que le format de la ligue et de la féderation est valide (3 caracteres)
    public boolean verifFormatLigueFedValide(String chaineTester){
        boolean res = true;
        if(!"".equals(chaineTester)){
            if(!chaineTester.matches("[A-Za-z-]{3}")){
                res = false;
            }
        }
        return res;
    }
    
    //Verifie que la chaine est vide
    public boolean stringEstVide(String chaineTester){
        return "".equals(chaineTester);
    }
    
    //Verifier que les champs obligatoire sont bien rempli
    public boolean verifDonneeEnregistrementJoueur(Joueurs j){
        boolean res = true;
        if(this.stringEstVide(j.getNomJ())){
            res = false;
        }
        if(this.stringEstVide(j.getPrenomJ())){
            res = false;
        }
        if(this.stringEstVide(j.getSexeJ())){
            res = false;
        }
        if(this.stringEstVide(j.getDateNaisJ())){
            res = false;
        }
        return res;
    }
    
    //Verrifier que le numero de licence a un format de type A12345
    public boolean verifNumLicenceValide(String chaineTester){
        boolean res = true;
        if(!"".equals(chaineTester)){
            if(!chaineTester.matches("[A-Z]{1}[0-9]{5}")){
                res = false;
            }
        }
        return res;
    }
    
    ////Verifier que le joueur existe dans list
    public boolean verifJoueurExistantDansList(ArrayList<Joueurs> jList, Joueurs j){
        boolean verif = false;
        for(int i = 0 ; i < jList.size() ; i++){
            verif = verifJoueurExistant(j,jList.get(i));
        }
        return verif;
    }
    
    //Verifier que le joueur existe
    public boolean verifJoueurExistant(Joueurs j, Joueurs j2){
        boolean verif = false;
        if(!"".equals(j.getNumLicenceJ())){
                if(j.getNumLicenceJ().equals(j2.getNumLicenceJ())){
                    verif = true;
                }
            }else{
                if(j.getNomJ().equals(j2.getNomJ()) && j.getPrenomJ().equals(j2.getPrenomJ()) && j.getDateNaisJ().equals(j2.getDateNaisJ())){
                    verif = true;
                }
            }
        return verif;
    }
    
    //Calcul la categorie
    public String calculCategorie(String sexe, String date){
        String tmp = this.conversionDate(date);
        String cat = "";
        if(this.verifFormatDateValide(date)){
            LocalDate dob = LocalDate.parse(tmp);
            LocalDate curDate = LocalDate.now();
            int age = Period.between(dob, curDate).getYears();
            if(age < 8){
                cat = cat+"pPo";
            }else if(age < 10){
                cat = cat+"Po";
            }else if(age < 12){
                cat = cat+"Pu";
            }else if(age < 14){
                cat = cat+"Ben";
            }else if(age < 16){
                cat = cat+"Min";
            }else if(age < 18){
                cat = cat+"Cad";
            }else if(age < 20){
                cat = cat+"Jun";
            }else if(age < 50){
                cat = cat+"Sen";
            }else if(age < 60){
                cat = cat+"SeP";
            }else{
                cat = cat+"Vet";
            }
            cat = cat+sexe;
        }else{
            cat = "Categorie non accessible.";
        }
        return cat;
    }
    
    public boolean allVerifJoueur(Joueurs j, JLabel nomLabel, JLabel prenomLabel, JLabel sexeLabel, JLabel dateLabel, JTextArea retour){
        String stmp="Données incorrectes: ";
        boolean verif = true;
        if(!verifDonneeEnregistrementJoueur(j))
        {
            verif= false;
            if(stringEstVide(j.getNomJ())){
                nomLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Nom Joueur manquant";
            } 
            if(stringEstVide(j.getPrenomJ())){
                prenomLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Prénom Joueur manquant";
            }
            if(stringEstVide(j.getSexeJ())){
                sexeLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Sexe Joueur manquant";
            }
            if(stringEstVide(j.getDateNaisJ())){
                dateLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Date de naissance manquante";
            }
        }else{
            if(!verifFormatNomValide(j.getNomJ())){
                verif= false;
                nomLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Nom Joueur invalide";
            }
            if(!verifFormatNomValide(j.getPrenomJ())){
                verif= false;
                prenomLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Prénom Joueur invalide";
            }
        }
        
        if(!verifTailleNomJoueur(j.getNomJ())){
            nomLabel.setForeground(Color.red);
            stmp += System.lineSeparator()+"Nom de joueur limité à 50 caractères.";
        }
        
        if(!verifTailleNomJoueur(j.getPrenomJ())){
            prenomLabel.setForeground(Color.red);
            stmp += System.lineSeparator()+"Prénom de joueur limité à 50 caractères.";
        }
        
        if(!verifNumLicenceValide(j.getNumLicenceJ())){
            verif = false;
            stmp += System.lineSeparator()+"Erreur, Format de licence incorrecte, format attendu : A12345";
        }
        
        if(!verifFormatDateValide(j.getDateNaisJ()))
        {
            verif = false;
            if(!verifMatchDate(j.getDateNaisJ())){
                dateLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!verifDateValide(j.getDateNaisJ())){
                    dateLabel.setForeground(Color.red);
                    stmp += System.lineSeparator()+"Erreur, date incorrecte";
                }
            }
        } 
        else{
            if(!verifDateNaiss(j.getDateNaisJ())){
                verif= false;
                dateLabel.setForeground(Color.red);
                stmp += System.lineSeparator()+"Erreur, date de naissance supérieure à la date actuelle.";
            }
        }
        
        if(!verifFormatEloValide(j.getNumEloNormalJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo Classique invalide.";
        }
        
        if(!verifFormatEloPositif(j.getNumEloNormalJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo Classique négatif.";
        }
        
        if(!verifFormatElo900To3000(j.getNumEloNormalJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo Classique doit être compris entre 900 et 3000.";
        }
        
        if(!verifFormatEloValide(j.getNumEloRapideJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo Rapide invalide.";
        }
        
        if(!verifFormatEloPositif(j.getNumEloRapideJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo Rapide négatif.";
        }
        
        if(!verifFormatElo900To3000(j.getNumEloRapideJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo Rapide doit être compris entre 900 et 3000.";
        }
        
        if(!verifFormatEloValide(j.getNumEloSemiRapideJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo SemiRapide invalide.";
        }
        
        if(!verifFormatEloPositif(j.getNumEloSemiRapideJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo SemiRapide négatif.";
        }
        
        if(!verifFormatElo900To3000(j.getNumEloSemiRapideJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Elo SemiRapide doit être compris entre 900 et 3000.";
        }
        
        if(!verifFormatLigueFedValide(j.getLigueJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, ligue invalide.";
        }
        
        if(!verifFormatLigueFedValide(j.getFederationJ())){
            verif= false;
            stmp += System.lineSeparator()+"Erreur, Federation invalide.";
        }
        
        if(verif){
            
            ArrayList<Joueurs> listJ = xmlJoueur.ReadXML();
            if(verifJoueurExistantDansList(listJ,j)){
                stmp += System.lineSeparator()+"Erreur, ce joueur existe déjà .";
            }else{
                verif = true;
            }
        }
        retour.setText(stmp);
      
        return verif;
    }
    
    public boolean saveJoueur(Joueurs j, JLabel nomLabel, JLabel prenomLabel, JLabel sexeLabel, JLabel dateLabel, JTextArea retour){
        
        boolean verif = allVerifJoueur(j, nomLabel, prenomLabel, sexeLabel, dateLabel, retour);        
        
        if(verif){
            retour.setText("Joueur créé avec succès !");
            xmlJoueur.WriteXML(j);
            return true;
        }
        return false;
    }
    
    public boolean modifieJoueur(Joueurs j, int idJ, JLabel nomLabel, JLabel prenomLabel, JLabel sexeLabel, JLabel dateLabel, JTextArea retour){
        
        boolean verif = allVerifJoueur(j, nomLabel, prenomLabel, sexeLabel, dateLabel, retour);        
        
        if(verif){
            retour.setText("Joueur modifié !");
            xmlJoueur.modifierJoueur(idJ, j);
            return true;
        }
        return false;
    }
    
}
