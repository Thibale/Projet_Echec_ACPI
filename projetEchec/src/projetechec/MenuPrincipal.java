package projetechec;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class MenuPrincipal extends javax.swing.JFrame implements ActionListener, WindowListener {

    private static final ControllerJoueur CONTROLLER_JOUEUR = new ControllerJoueur();
    private static final ControllerTournoi CONTROLLER_TOURNOI = new ControllerTournoi();

    private static boolean MODIFICATION = false;

    public static boolean confirmed = true;

    //Boutons utilisés par plusieurs panels
    private JButton buttonMenuPrincipal;

        //Boutons du menuPrincipal
    private JButton buttonCreationJoueurs;
    private JButton buttonCreationTournois;
    private JButton buttonGestionJoueurs;
    private JButton buttonGestionTournois;

        //Boutons et champs de text du panel Création/Modification Joueur
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldDate;

    private JComboBox<String> comboBoxSexe;

    private JTextField textFieldLicence;
    private JTextField textFieldFederation;
    private JTextField textFieldLigue;
    private JTextField textFieldClub;
    private JTextField textFieldEloClassique;
    private JTextField textFieldEloRapide;
    private JTextField textFieldEloSemiRapide;

    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelDate;
    private JLabel labelSexe;
    private JLabel labelNumLicence;
    private JLabel labelFederation;
    private JLabel labelLigue;
    private JLabel labelClub;
    private JLabel labelEloClassique;
    private JLabel labelEloRapide;
    private JLabel labelEloSemiRapide;

    private JTextArea textAreaRetourJoueur;

    private JButton buttonEnregistrerJoueur;
    private JButton buttonResetInfosJoueur;

        //Bouton et list du panel Gestion Joueurs
    private JList listJoueurs;
    private JTextArea textAreaJoueurs;

    private JLabel labelInformationSelectionJoueur;

    private JButton buttonModifierJoueur;
    private JButton buttonSupprimerJoueur;

        //Boutons et champs de text du panel Création/Modification Tournoi
    private JTextField textFieldNomTournoi;
    private JTextField textFieldDateDebut;
    private JTextField textFieldDateFin;
    private JTextField textFieldNombreRondes;
    private JTextField textFieldLieu;

    private JLabel labelNomTournoi;
    private JLabel labelDateDebut;
    private JLabel labelDateFin;
    private JLabel labelNombreRondes;
    private JLabel labelLieu;

    private JTextArea textAreaRetourTournoi;

    private JButton buttonEnregistrerTournoi;
    private JButton buttonResetInfosTournoi;

        //Bouton et list du panel Gestion Tournois
    private JList listTournois;
    private JTextArea textAreaTournois;

    private JLabel labelInformationSelectionTournoi;

    private JButton buttonSelectionnerTournoi;
    private JButton buttonModifierTournoi;
    private JButton buttonSupprimerTournoi;

    private JLabel labelTitreTournoi;

    private JButton buttonAjouterJoueursAuTournoi;
    private JButton buttonSelectionRonde;
    private JButton buttonGenererListParticipant;

        //Bouton du panel EcranTournoi
    private JPanel panelContainerAppareillement;

    private ArrayList<JComboBox> tableauComboBoxJoueur;
    private ArrayList<JComboBox> tableauComboBoxCouleur;
    private ArrayList<JComboBox> tableauComboBoxResultat;

    private JButton buttonValiderAppareillement;

        //Elements panel AjoutJoueursTournoi
    private JButton buttonAjouter;
    private JButton buttonEnlever;
    private JButton buttonConfirmer;
    private JButton buttonRetour;
    private JButton buttonAnnuler;

    private JLabel labelInformationConfirmationAjoutJoueur;

    private JList listJoueursDehors;
    private JList listJoueursDedans;

    public static boolean getMODIFICATION() {
        return MODIFICATION;
    }

    public static void setMODIFICATION(boolean MODIFICATION) {
        MenuPrincipal.MODIFICATION = MODIFICATION;
    }

    MenuPrincipal() {
        initWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanelMenuPrincipal();
    }

    public void initWindow() {
        //Déclare les caractéristiques de la fenêtre
        setTitle("Logiciel de gestion de tournois d'échecs");
        setBounds(600, 100, 800, 800);
    }

    public void createPanelMenuPrincipal() {
        //Créer le panel du menu Principal

        JPanel menuPrincipalMainContent = new JPanel();
        menuPrincipalMainContent.setMaximumSize(new Dimension(700, 700));

        //On définit le layout manager
        menuPrincipalMainContent.setLayout(new BorderLayout());

        JPanel panelAffichageTitre = new JPanel();

        JPanel panelButtonsMenuPrincipal = new JPanel();
        panelButtonsMenuPrincipal.setLayout(new FlowLayout());

        JPanel panelCreationJoueur = new JPanel();

        JLabel affichageTitre = new JLabel("Veuillez sélectionner un sous menu");

        panelAffichageTitre.add(affichageTitre);

        buttonCreationJoueurs = new JButton("Créer un joueur");
        buttonCreationTournois = new JButton("Créer un tournoi");
        buttonGestionJoueurs = new JButton("Gestion des joueurs");
        buttonGestionTournois = new JButton("Gestion des tournois");

        panelCreationJoueur.add(buttonCreationJoueurs);

        panelButtonsMenuPrincipal.add(buttonCreationJoueurs);
        panelButtonsMenuPrincipal.add(buttonCreationTournois);
        panelButtonsMenuPrincipal.add(buttonGestionJoueurs);
        panelButtonsMenuPrincipal.add(buttonGestionTournois);


        menuPrincipalMainContent.add("North", panelAffichageTitre);

        menuPrincipalMainContent.add("Center", panelButtonsMenuPrincipal);

        //La fenêtre est un listener et gère les cas en fonction du bouton
        buttonCreationJoueurs.addActionListener(this);
        buttonCreationTournois.addActionListener(this);
        buttonGestionJoueurs.addActionListener(this);
        buttonGestionTournois.addActionListener(this);

        this.setContentPane(menuPrincipalMainContent);
        addWindowListener(this);
        setVisible(true);
    }

    public void createPanelCreationORModificationJoueur(Map<String, String> infos) {
        //Créer le panel de creation et Modification de joueur

        JPanel creationModificationJoueurMainContent = new JPanel();
        creationModificationJoueurMainContent.setMaximumSize(new Dimension(700, 700));

        //On définit le layout manager
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(5000);
        flowLayout.setVgap(20);
        creationModificationJoueurMainContent.setLayout(flowLayout);

        JPanel panelAffichageTitre = new JPanel();

        String titre;
        if (getMODIFICATION()) {
            titre = "Modification d'un joueur";
        } else {
            titre = "Création  d'un joueur";
        }

        JLabel labelAffichageTitre = new JLabel(titre);

        panelAffichageTitre.add(labelAffichageTitre);

        JPanel panelFormulaireJoueur = new JPanel();
        panelFormulaireJoueur.setMaximumSize(new Dimension(400, 400));
        panelFormulaireJoueur.setLayout(new GridLayout(11, 2, 50, 20));


        //Label du formulaire
        labelNom = new JLabel("Nom : *");
        labelPrenom = new JLabel("Prénom : *");
        labelDate = new JLabel("Date de Naissance : * JJ/MM/AAAA");
        labelSexe = new JLabel("Sexe : *");
        labelNumLicence = new JLabel("Numéro de licence :");
        labelFederation = new JLabel("Fédération :");
        labelLigue = new JLabel("Ligue");
        labelClub = new JLabel("Club");
        labelEloClassique = new JLabel("Elo (classique) :");
        labelEloRapide = new JLabel("Elo (rapide) :");
        labelEloSemiRapide = new JLabel("Elo (semi-rapide) :");

        textFieldNom = new JTextField();
        textFieldPrenom = new JTextField();
        textFieldDate = new JTextField();

        comboBoxSexe = new JComboBox<>(new String[]{"M", "F"});

        textFieldLicence = new JTextField();
        textFieldFederation = new JTextField();
        textFieldLigue = new JTextField();
        textFieldClub = new JTextField();
        textFieldEloClassique = new JTextField();
        textFieldEloRapide = new JTextField();
        textFieldEloSemiRapide = new JTextField();

        if (infos != null) {
            textFieldNom.setText(infos.get("nom"));
            textFieldPrenom.setText(infos.get("prenom"));
            textFieldDate.setText(infos.get("dateNaissance"));
            textFieldLicence.setText(infos.get("numLicence"));
            textFieldFederation.setText(infos.get("federation"));
            textFieldLigue.setText(infos.get("ligue"));
            textFieldClub.setText(infos.get("club"));
            if (infos.get("sexe").equals("M")) {
                comboBoxSexe.setSelectedItem("M");
            } else {
                comboBoxSexe.setSelectedItem("F");
            }
            textFieldEloClassique.setText(infos.get("eloClassique"));
            textFieldEloSemiRapide.setText(infos.get("eloSemiRapide"));
            textFieldEloRapide.setText(infos.get("eloRapide"));
        }

        panelFormulaireJoueur.add(labelNom);
        panelFormulaireJoueur.add(textFieldNom);
        panelFormulaireJoueur.add(labelPrenom);
        panelFormulaireJoueur.add(textFieldPrenom);
        panelFormulaireJoueur.add(labelDate);
        panelFormulaireJoueur.add(textFieldDate);
        panelFormulaireJoueur.add(labelSexe);
        panelFormulaireJoueur.add(comboBoxSexe);
        panelFormulaireJoueur.add(labelNumLicence);
        panelFormulaireJoueur.add(textFieldLicence);
        panelFormulaireJoueur.add(labelFederation);
        panelFormulaireJoueur.add(textFieldFederation);
        panelFormulaireJoueur.add(labelLigue);
        panelFormulaireJoueur.add(textFieldLigue);
        panelFormulaireJoueur.add(labelClub);
        panelFormulaireJoueur.add(textFieldClub);
        panelFormulaireJoueur.add(labelEloClassique);
        panelFormulaireJoueur.add(textFieldEloClassique);
        panelFormulaireJoueur.add(labelEloRapide);
        panelFormulaireJoueur.add(textFieldEloRapide);
        panelFormulaireJoueur.add(labelEloSemiRapide);
        panelFormulaireJoueur.add(textFieldEloSemiRapide);

        JPanel panelButtonTextArea = new JPanel();
        panelButtonTextArea.setLayout(new BoxLayout(panelButtonTextArea, BoxLayout.PAGE_AXIS));
        panelButtonTextArea.setMinimumSize(new Dimension(500, 100));

        JPanel panelTextArea = new JPanel();
        panelTextArea.setLayout(new BoxLayout(panelTextArea, BoxLayout.PAGE_AXIS));

        JScrollPane scrollPaneRetourJoueur = new JScrollPane();
        textAreaRetourJoueur = new JTextArea();
        textAreaRetourJoueur.setColumns(20);
        textAreaRetourJoueur.setRows(6);
        //textAreaRetourJoueur.setMinimumSize(new Dimension(300, 100));
        scrollPaneRetourJoueur.setViewportView(textAreaRetourJoueur);
        scrollPaneRetourJoueur.setAutoscrolls(true);

        panelTextArea.add(scrollPaneRetourJoueur);

        JPanel panelButtonsJoueur = new JPanel();
        panelButtonsJoueur.setLayout(new BoxLayout(panelButtonsJoueur, BoxLayout.LINE_AXIS));

        buttonEnregistrerJoueur = new JButton("Enregistrer Joueur");
        buttonResetInfosJoueur = new JButton("Réinitialiser");
        buttonMenuPrincipal = new JButton("Menu Principal");
        panelButtonsJoueur.add(buttonEnregistrerJoueur);
        panelButtonsJoueur.add(buttonResetInfosJoueur);
        panelButtonsJoueur.add(buttonMenuPrincipal);

        panelButtonTextArea.add(panelTextArea);
        panelButtonTextArea.add(panelButtonsJoueur);

        creationModificationJoueurMainContent.add(panelAffichageTitre);

        creationModificationJoueurMainContent.add(panelFormulaireJoueur);

        creationModificationJoueurMainContent.add(panelButtonTextArea);

        buttonEnregistrerJoueur.addActionListener(this);
        buttonResetInfosJoueur.addActionListener(this);
        buttonMenuPrincipal.addActionListener(this);

        this.setContentPane(creationModificationJoueurMainContent);
        addWindowListener(this);
        setVisible(true);
    }

    public void createPanelGestionJoueur() {
        //Créer le panel de gestion des joueurs

        JPanel gestionJoueurMainContent = new JPanel();
        gestionJoueurMainContent.setMaximumSize(new Dimension(700, 700));

        //On définit le layout manager
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(500);
        flowLayout.setVgap(20);
        gestionJoueurMainContent.setLayout(flowLayout);

        JPanel panelAffichageTitre = new JPanel();
        JLabel labelAffichageTitre = new JLabel("Gestion des Joueurs");
        panelAffichageTitre.add(labelAffichageTitre);

        JPanel panelListsJoueur = new JPanel();
        panelListsJoueur.setLayout(new GridLayout(1, 2, 50, 20));
        panelListsJoueur.setMinimumSize(new Dimension(500, 300));

        //List et textArea
        JPanel panelTextArea = new JPanel();
        panelTextArea.setLayout(new BoxLayout(panelTextArea, BoxLayout.PAGE_AXIS));

        JScrollPane scrollPaneAffichageListJoueurs = new JScrollPane();
        listJoueurs = new JList();
        listJoueurs.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        listJoueurs.setSize(30, 200);
        scrollPaneAffichageListJoueurs.setViewportView(listJoueurs);
        scrollPaneAffichageListJoueurs.setAutoscrolls(true);

        JScrollPane scrollPaneAffichageDetailJoueur = new JScrollPane();
        textAreaJoueurs = new JTextArea();
        textAreaJoueurs.setColumns(20);
        textAreaJoueurs.setRows(30);
        scrollPaneAffichageDetailJoueur.setViewportView(textAreaJoueurs);
        scrollPaneAffichageDetailJoueur.setAutoscrolls(true);

        panelTextArea.add(scrollPaneAffichageDetailJoueur);

        listJoueurs.setModel(CONTROLLER_JOUEUR.setJoueurInListModel(textAreaJoueurs));

        labelInformationSelectionJoueur = new JLabel();

        panelListsJoueur.add(scrollPaneAffichageListJoueurs);
        panelListsJoueur.add(scrollPaneAffichageDetailJoueur);

        JPanel panelButtonTextArea = new JPanel();
        panelButtonTextArea.setLayout(new BoxLayout(panelButtonTextArea, BoxLayout.PAGE_AXIS));
        panelButtonTextArea.setMinimumSize(new Dimension(500, 100));

        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));

        panelLabel.add(labelInformationSelectionJoueur);

        JPanel panelButtonsJoueur = new JPanel();
        panelButtonsJoueur.setLayout(new BoxLayout(panelButtonsJoueur, BoxLayout.LINE_AXIS));

        buttonModifierJoueur = new JButton("Modifier Joueur");
        buttonSupprimerJoueur = new JButton("Supprimer Joueur");
        buttonMenuPrincipal = new JButton("Menu Principal");
        panelButtonsJoueur.add(buttonModifierJoueur);
        panelButtonsJoueur.add(buttonSupprimerJoueur);
        panelButtonsJoueur.add(buttonMenuPrincipal);

        panelButtonTextArea.add(panelLabel);
        panelButtonTextArea.add(panelButtonsJoueur);

        gestionJoueurMainContent.add(panelAffichageTitre);

        gestionJoueurMainContent.add(panelListsJoueur);

        gestionJoueurMainContent.add(panelButtonTextArea);

        buttonModifierJoueur.addActionListener(this);
        buttonSupprimerJoueur.addActionListener(this);
        buttonMenuPrincipal.addActionListener(this);

        listJoueurs.addListSelectionListener(e -> {
            CONTROLLER_JOUEUR.joueurListGetSelectedJoueur(listJoueurs);
            CONTROLLER_JOUEUR.setInfoJoueurInTextArea(textAreaJoueurs);
        });

        this.setContentPane(gestionJoueurMainContent);
        addWindowListener(this);
        setVisible(true);
    }

    public void createPanelCreationORModificationTournoi(Map<String, String> infos) {
        //Créer le panel de creation et Modification de joueur

        JPanel creationModificationTournoiMainContent = new JPanel();
        creationModificationTournoiMainContent.setMaximumSize(new Dimension(700, 700));

        //On définit le layout manager
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(5000);
        flowLayout.setVgap(20);
        creationModificationTournoiMainContent.setLayout(flowLayout);

        JPanel panelAffichageTitre = new JPanel();

        String titre;
        if (getMODIFICATION()) {
            titre = "Modification d'un tournoi";
        } else {
            titre = "Création d'un tournoi";
        }

        JLabel labelAffichageTitre = new JLabel(titre);

        panelAffichageTitre.add(labelAffichageTitre);

        JPanel panelFormulaireTournoi = new JPanel();
        panelFormulaireTournoi.setMaximumSize(new Dimension(400, 400));
        panelFormulaireTournoi.setLayout(new GridLayout(11, 2, 50, 20));

        //Label du formulaire
        labelNomTournoi = new JLabel("Nom du tournoi : *");
        labelDateDebut = new JLabel("Date de début : *   JJ/MM/AAAA");
        labelDateFin = new JLabel("Date de fin : *     JJ/MM/AAAA");
        labelNombreRondes = new JLabel("Nombre de rondes : *");
        labelLieu = new JLabel("Lieu :");

        textFieldNomTournoi = new JTextField();
        textFieldDateDebut = new JTextField();
        textFieldDateFin = new JTextField();
        textFieldNombreRondes = new JTextField();
        textFieldLieu = new JTextField();

        if (infos != null) {
            textFieldNomTournoi.setText(infos.get("nom"));
            textFieldDateDebut.setText(infos.get("dateDebut"));
            textFieldDateFin.setText(infos.get("dateFin"));
            textFieldNombreRondes.setText(infos.get("nbRondes"));
            textFieldLieu.setText(infos.get("lieu"));
        }

        panelFormulaireTournoi.add(labelNomTournoi);
        panelFormulaireTournoi.add(textFieldNomTournoi);
        panelFormulaireTournoi.add(labelDateDebut);
        panelFormulaireTournoi.add(textFieldDateDebut);
        panelFormulaireTournoi.add(labelDateFin);
        panelFormulaireTournoi.add(textFieldDateFin);
        panelFormulaireTournoi.add(labelNombreRondes);
        panelFormulaireTournoi.add(textFieldNombreRondes);
        panelFormulaireTournoi.add(labelLieu);
        panelFormulaireTournoi.add(textFieldLieu);

        JPanel panelButtonTextArea = new JPanel();
        panelButtonTextArea.setLayout(new BoxLayout(panelButtonTextArea, BoxLayout.PAGE_AXIS));
        panelButtonTextArea.setMinimumSize(new Dimension(500, 100));

        JPanel panelTextArea = new JPanel();
        panelTextArea.setLayout(new BoxLayout(panelTextArea, BoxLayout.PAGE_AXIS));

        JScrollPane scrollPaneRetourTournoi = new JScrollPane();
        textAreaRetourTournoi = new JTextArea();
        textAreaRetourTournoi.setColumns(20);
        textAreaRetourTournoi.setRows(6);
        scrollPaneRetourTournoi.setViewportView(textAreaRetourTournoi);
        scrollPaneRetourTournoi.setAutoscrolls(true);

        panelTextArea.add(scrollPaneRetourTournoi);

        JPanel panelButtonsTournoi = new JPanel();
        panelButtonsTournoi.setLayout(new BoxLayout(panelButtonsTournoi, BoxLayout.LINE_AXIS));

        buttonEnregistrerTournoi = new JButton("Enregistrer Tournoi");
        buttonResetInfosTournoi = new JButton("Réinitialiser");
        buttonMenuPrincipal = new JButton("Menu Principal");
        panelButtonsTournoi.add(buttonEnregistrerTournoi);
        panelButtonsTournoi.add(buttonResetInfosTournoi);
        panelButtonsTournoi.add(buttonMenuPrincipal);

        panelButtonTextArea.add(panelTextArea);
        panelButtonTextArea.add(panelButtonsTournoi);

        creationModificationTournoiMainContent.add(panelAffichageTitre);

        creationModificationTournoiMainContent.add(panelFormulaireTournoi);

        creationModificationTournoiMainContent.add(panelButtonTextArea);

        buttonEnregistrerTournoi.addActionListener(this);
        buttonResetInfosTournoi.addActionListener(this);
        buttonMenuPrincipal.addActionListener(this);

        this.setContentPane(creationModificationTournoiMainContent);
        addWindowListener(this);
        setVisible(true);
    }

    public void createPanelGestionTournoi() {
        //Créer le panel de gestion des tournois

        JPanel gestionTournoiMainContent = new JPanel();
        gestionTournoiMainContent.setMaximumSize(new Dimension(700, 700));

        //On définit le layout manager
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(500);
        flowLayout.setVgap(20);
        gestionTournoiMainContent.setLayout(flowLayout);

        JPanel panelAffichageTitre = new JPanel();
        JLabel labelAffichageTitre = new JLabel("Gestion des Tournois");
        panelAffichageTitre.add(labelAffichageTitre);

        JPanel panelListsTournoi = new JPanel();
        panelListsTournoi.setLayout(new GridLayout(1, 2, 50, 20));
        panelListsTournoi.setMinimumSize(new Dimension(500, 300));

        //List et textArea
        JPanel panelTextArea = new JPanel();
        panelTextArea.setLayout(new BoxLayout(panelTextArea, BoxLayout.PAGE_AXIS));

        JScrollPane scrollPaneAffichageListTournois = new JScrollPane();
        listTournois = new JList();
        listTournois.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        listTournois.setSize(30, 200);
        scrollPaneAffichageListTournois.setViewportView(listTournois);
        scrollPaneAffichageListTournois.setAutoscrolls(true);


        JScrollPane scrollPaneAffichageDetailTournoi = new JScrollPane();
        textAreaTournois = new JTextArea();
        textAreaTournois.setColumns(20);
        textAreaTournois.setRows(30);
        scrollPaneAffichageDetailTournoi.setViewportView(textAreaTournois);
        scrollPaneAffichageDetailTournoi.setAutoscrolls(true);

        panelTextArea.add(scrollPaneAffichageDetailTournoi);

        listTournois.setModel(ControllerTournoi.setTournoisInListModel(textAreaJoueurs));

        labelInformationSelectionTournoi = new JLabel();

        panelListsTournoi.add(scrollPaneAffichageListTournois);
        panelListsTournoi.add(scrollPaneAffichageDetailTournoi);

        JPanel panelButtonTextArea = new JPanel();
        panelButtonTextArea.setLayout(new BoxLayout(panelButtonTextArea, BoxLayout.PAGE_AXIS));
        panelButtonTextArea.setMinimumSize(new Dimension(500, 100));

        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));

        panelLabel.add(labelInformationSelectionTournoi);

        JPanel panelButtonsTournoi = new JPanel();
        panelButtonsTournoi.setLayout(new BoxLayout(panelButtonsTournoi, BoxLayout.LINE_AXIS));

        buttonSelectionnerTournoi = new JButton("Sélectionner Tournoi");
        buttonModifierTournoi = new JButton("Modifier Tournoi");
        buttonSupprimerTournoi = new JButton("Supprimer Tournoi");
        buttonMenuPrincipal = new JButton("Menu Principal");
        panelButtonsTournoi.add(buttonSelectionnerTournoi);
        panelButtonsTournoi.add(buttonModifierTournoi);
        panelButtonsTournoi.add(buttonSupprimerTournoi);
        panelButtonsTournoi.add(buttonMenuPrincipal);

        panelButtonTextArea.add(panelLabel);
        panelButtonTextArea.add(panelButtonsTournoi);

        gestionTournoiMainContent.add(panelAffichageTitre);

        gestionTournoiMainContent.add(panelListsTournoi);

        gestionTournoiMainContent.add(panelButtonTextArea);

        buttonSelectionnerTournoi.addActionListener(this);
        buttonModifierTournoi.addActionListener(this);
        buttonSupprimerTournoi.addActionListener(this);
        buttonMenuPrincipal.addActionListener(this);

        listTournois.addListSelectionListener(e -> {
            CONTROLLER_TOURNOI.tournoiListGetSelectedTournoi(listTournois);
            CONTROLLER_TOURNOI.setInfoTournoiInTextArea(textAreaTournois);
        });

        this.setContentPane(gestionTournoiMainContent);
        addWindowListener(this);
        setVisible(true);
    }

    public void createPanelEcranTournoi() {
        //Créé le panel d'écran princpal du tournoi

        JPanel ecranTournoiMainContent = new JPanel();
        ecranTournoiMainContent.setMaximumSize(new Dimension(700, 700));

        //On définit le layout manager
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(500);
        flowLayout.setVgap(20);
        ecranTournoiMainContent.setLayout(flowLayout);

        JPanel panelAffichageTitreEcranTournoi = new JPanel();
        panelAffichageTitreEcranTournoi.add(labelTitreTournoi);

        panelContainerAppareillement = new JPanel(flowLayout);

        JPanel panelButtonsEcranTournoi = new JPanel();
        flowLayout = new FlowLayout();
        flowLayout.setHgap(10);
        panelButtonsEcranTournoi.setLayout(flowLayout);
        panelButtonsEcranTournoi.setMinimumSize(new Dimension(500, 300));



        JPanel panelAppareillementJoueurs = new JPanel();
        JScrollPane scrollPaneAppareillementJoueurs = new JScrollPane();
        scrollPaneAppareillementJoueurs.setViewportView(panelAppareillementJoueurs);
        scrollPaneAppareillementJoueurs.setAutoscrolls(true);

        panelContainerAppareillement.add(scrollPaneAppareillementJoueurs);

        buttonAjouterJoueursAuTournoi = new JButton("Ajouter des Joueurs au tournoi");
        buttonSelectionRonde = new JButton("Sélectionner une ronde");
        buttonGenererListParticipant = new JButton("Générer la liste des participants");
        buttonMenuPrincipal = new JButton("Menu Principal");
        panelButtonsEcranTournoi.add(buttonAjouterJoueursAuTournoi);
        panelButtonsEcranTournoi.add(buttonSelectionRonde);
        panelButtonsEcranTournoi.add(buttonGenererListParticipant);
        panelButtonsEcranTournoi.add(buttonMenuPrincipal);

        ecranTournoiMainContent.add(panelAffichageTitreEcranTournoi);

        ecranTournoiMainContent.add(panelButtonsEcranTournoi);

        ecranTournoiMainContent.add(panelAppareillementJoueurs);

        buttonAjouterJoueursAuTournoi.addActionListener(this);
        buttonSelectionRonde.addActionListener(this);
        buttonGenererListParticipant.addActionListener(this);
        buttonMenuPrincipal.addActionListener(this);

        this.setContentPane(ecranTournoiMainContent);
        addWindowListener(this);
        setVisible(true);
    }

    public void createPanelAjoutJoueurTournoi() {
        //Créer le panel de gestion des tournois

        JPanel ajoutJoueurTournoiMainContent = new JPanel();
        //ajoutJoueurTournoiMainContent.setMaximumSize(new Dimension(700, 700));

        //On définit le layout manager
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(500);
        flowLayout.setVgap(20);
        ajoutJoueurTournoiMainContent.setLayout(flowLayout);

        JPanel panelAffichageLabelLists = new JPanel();
        panelAffichageLabelLists.setLayout(new GridLayout(1, 2, 200, 20));

        JLabel labelListEnDehors = new JLabel("Joueurs qui ne sont pas dans le tournoi");
        JLabel labelListDedans = new JLabel("Joueurs déjà présent dans le tournoi");

        panelAffichageLabelLists.add(labelListEnDehors);
        panelAffichageLabelLists.add(labelListDedans);

        JPanel panelListsJoueurs = new JPanel();
        //panelListsJoueurs.setLayout(new GridLayout(1, 3, 20, 20));
        panelListsJoueurs.setLayout(new FlowLayout());

        JPanel panelButtonAddRemove = new JPanel();
        flowLayout = new FlowLayout();
        //flowLayout.setHgap(500);
        //flowLayout.setVgap(100);
        panelButtonAddRemove.setLayout(flowLayout);

        buttonAjouter = new JButton("Ajouter");
        buttonEnlever = new JButton("Enlever");

        panelButtonAddRemove.add(buttonAjouter);
        panelButtonAddRemove.add(buttonEnlever);

        JScrollPane scrollPaneAffichageListJoueursDehors = new JScrollPane();
        listJoueursDehors = new JList();
        listJoueursDehors.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        listJoueursDehors.setSize(30, 500);
        scrollPaneAffichageListJoueursDehors.setSize(30, 500);
        scrollPaneAffichageListJoueursDehors.setViewportView(listJoueursDehors);
        scrollPaneAffichageListJoueursDehors.setAutoscrolls(true);

        JScrollPane scrollPaneAffichageListJoueursDedans = new JScrollPane();
        listJoueursDedans = new JList();
        listJoueursDedans.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        listJoueursDedans.setSize(30, 1000);
        scrollPaneAffichageListJoueursDedans.setViewportView(listJoueursDedans);
        scrollPaneAffichageListJoueursDedans.setAutoscrolls(true);

        CONTROLLER_TOURNOI.setAjoutJoueursInTournoiJList(listJoueursDedans, listJoueursDehors);

        panelListsJoueurs.add(scrollPaneAffichageListJoueursDehors);
        panelListsJoueurs.add(panelButtonAddRemove);
        panelListsJoueurs.add(scrollPaneAffichageListJoueursDedans);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.PAGE_AXIS));
        panelButtons.setMinimumSize(new Dimension(500, 100));

        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));

        labelInformationConfirmationAjoutJoueur = new JLabel();
        panelLabel.add(labelInformationConfirmationAjoutJoueur);

        JPanel panelButtonsAjoutJoueurs = new JPanel();
        panelButtonsAjoutJoueurs.setLayout(new BoxLayout(panelButtonsAjoutJoueurs, BoxLayout.LINE_AXIS));

        buttonConfirmer = new JButton("Confirmer");
        buttonRetour = new JButton("Retour");
        buttonAnnuler = new JButton("Annuler");
        panelButtonsAjoutJoueurs.add(buttonConfirmer);
        panelButtonsAjoutJoueurs.add(buttonRetour);
        panelButtonsAjoutJoueurs.add(buttonAnnuler);

        panelButtons.add(panelLabel);
        panelButtons.add(panelButtonsAjoutJoueurs);

        ajoutJoueurTournoiMainContent.add(panelAffichageLabelLists);

        ajoutJoueurTournoiMainContent.add(panelListsJoueurs);

        ajoutJoueurTournoiMainContent.add(panelButtons);

        buttonAjouter.addActionListener(this);
        buttonEnlever.addActionListener(this);
        buttonConfirmer.addActionListener(this);
        buttonRetour.addActionListener(this);
        buttonAnnuler.addActionListener(this);

        listJoueursDehors.addListSelectionListener(e -> {
            CONTROLLER_TOURNOI.tournoiListGetSelectedJoueurDehors(listJoueursDehors);
        });

        listJoueursDedans.addListSelectionListener(e -> {
            CONTROLLER_TOURNOI.tournoiListGetSelectedJoueurDedans(listJoueursDedans);
        });

        this.setContentPane(ajoutJoueurTournoiMainContent);
        addWindowListener(this);
        setVisible(true);
    }

    public void resetInformationFormulaireJoueur() {
        textFieldNom.setText("");
        textFieldPrenom.setText("");
        textFieldDate.setText("");
        textFieldLicence.setText("");
        textFieldFederation.setText("");
        textFieldLigue.setText("");
        textFieldClub.setText("");
        textFieldEloClassique.setText("");
        textFieldEloRapide.setText("");
        textFieldEloSemiRapide.setText("");
        textAreaRetourJoueur.setText("");
        labelNom.setForeground(Color.black);
        labelPrenom.setForeground(Color.black);
        labelSexe.setForeground(Color.black);
        labelDate.setForeground(Color.black);
    }

    public void resetInformationFormulaireTournoi() {
        textFieldNomTournoi.setText("");
        textFieldDateDebut.setText("");
        textFieldDateFin.setText("");
        textFieldNombreRondes.setText("");
        textFieldLieu.setText("");
        textAreaRetourTournoi.setText("");
        labelNomTournoi.setForeground(Color.black);
        labelDateDebut.setForeground(Color.black);
        labelDateFin.setForeground(Color.black);
        labelNombreRondes.setForeground(Color.black);
    }

    private void refreshAffichageListJoueur() {
        DefaultListModel listM = CONTROLLER_JOUEUR.setJoueurInListModel(textAreaJoueurs);
        listJoueurs.setModel(listM);
    }

    private void refreshAffichageListTournoi() {
        DefaultListModel listM = ControllerTournoi.setTournoisInListModel(textAreaTournois);
        listTournois.setModel(listM);
    }

    public void enregistrerJoueur() {
        Map<String, String> informationsJoueurs = new HashMap<>();

        informationsJoueurs.put("numLicence", textFieldLicence.getText());
        informationsJoueurs.put("nom", textFieldNom.getText());
        informationsJoueurs.put("prenom", textFieldPrenom.getText());
        informationsJoueurs.put("eloClassique", textFieldEloClassique.getText());
        informationsJoueurs.put("eloRapide", textFieldEloRapide.getText());
        informationsJoueurs.put("eloSemiRapide", textFieldEloSemiRapide.getText());
        informationsJoueurs.put("dateNaissance", textFieldDate.getText());
        informationsJoueurs.put("sexe", comboBoxSexe.getSelectedItem().toString());
        informationsJoueurs.put("federation", textFieldFederation.getText());
        informationsJoueurs.put("ligue", textFieldLigue.getText());
        informationsJoueurs.put("club", textFieldClub.getText());

        boolean estCree;

        if (!getMODIFICATION()) {
            estCree = CONTROLLER_JOUEUR.creerJoueur(informationsJoueurs, labelNom, labelPrenom, labelSexe, labelDate, textAreaRetourJoueur);
        } else {
            estCree = CONTROLLER_JOUEUR.modifieJoueur(informationsJoueurs, labelNom, labelPrenom, labelSexe, labelDate, textAreaRetourJoueur);
        }

        if (estCree) {
            resetInformationFormulaireJoueur();
            if (!getMODIFICATION()) {
                textAreaRetourJoueur.setText("Joueur créé avec succès !");
            } else {
                textAreaRetourJoueur.setText("Joueur modifié avec succès !");
            }

        }
    }

    public void enregistrerTournoi() {
        Map<String, String> informationsTournoi = new HashMap<>();

        informationsTournoi.put("nom", textFieldNomTournoi.getText());
        informationsTournoi.put("dateDebut", textFieldDateDebut.getText());
        informationsTournoi.put("dateFin", textFieldDateFin.getText());
        informationsTournoi.put("nbRondes", textFieldNombreRondes.getText());
        informationsTournoi.put("lieu", textFieldLieu.getText());

        boolean estCree;
        if (!getMODIFICATION()) {
            estCree = CONTROLLER_TOURNOI.enregistrerTournoi(informationsTournoi, labelNomTournoi, labelDateDebut, labelDateFin, labelNombreRondes, textAreaRetourTournoi);
        } else {
            estCree = CONTROLLER_TOURNOI.modifieTournoi(informationsTournoi, labelNomTournoi, labelDateDebut, labelDateFin, labelNombreRondes, textAreaRetourTournoi);
        }

        if (estCree) {
            resetInformationFormulaireTournoi();
            if (!getMODIFICATION()) {
                textAreaRetourTournoi.setText("Tournoi créé avec succès !");
            } else {
                textAreaRetourTournoi.setText("Tournoi modifié avec succès !");
            }
        }
    }

    public void setAppareillementJoueur(){
        //panelContainerAppareillement

        JPanel ensembleLignesAppareillement = new EnsembleLigneAppareillement();

        JScrollPane scrollPaneAppareillementJoueurs = new JScrollPane();
        scrollPaneAppareillementJoueurs.setViewportView(ensembleLignesAppareillement);
        scrollPaneAppareillementJoueurs.setAutoscrolls(true);

        JPanel panelButtonValider = new JPanel();
        buttonValiderAppareillement = new JButton("Valider");

        panelButtonValider.add(buttonValiderAppareillement);
        buttonValiderAppareillement.addActionListener(this);

        panelContainerAppareillement.add(scrollPaneAppareillementJoueurs);
        panelContainerAppareillement.add(panelButtonValider);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Actions de plusieurs panels
        if (e.getSource() == buttonMenuPrincipal) {
            ControllerTournoi.setIdTournoiCourant(-1);
            ControllerJoueur.setIdJoueurCourant(-1);
            createPanelMenuPrincipal();
        }

        //Actions MenuPrincipal
        if (e.getSource() == buttonCreationJoueurs) {
            setMODIFICATION(false);
            createPanelCreationORModificationJoueur(null);
        }
        if (e.getSource() == buttonCreationTournois) {
            setMODIFICATION(false);
            createPanelCreationORModificationTournoi(null);
        }
        if (e.getSource() == buttonGestionJoueurs) {
            ControllerJoueur.setIdJoueurCourant(-1);
            createPanelGestionJoueur();
        }
        if (e.getSource() == buttonGestionTournois) {
            ControllerTournoi.setIdTournoiCourant(-1);
            createPanelGestionTournoi();
        }

        //Actions CréationModificationJoueur
        if (e.getSource() == buttonEnregistrerJoueur) {
            enregistrerJoueur();
        }
        if (e.getSource() == buttonResetInfosJoueur) {
            resetInformationFormulaireJoueur();
        }

        //Actions de GestionJoueurs
        if (e.getSource() == buttonModifierJoueur) {
            if (ControllerJoueur.getIdJoueurCourant() == -1) {
                labelInformationSelectionJoueur.setText("Veuillez sélectionner un joueur");
            } else {
                setMODIFICATION(true);
                createPanelCreationORModificationJoueur(ControllerJoueur.getInfoJoueurCourant());
            }
        }
        if (e.getSource() == buttonSupprimerJoueur) {
            if (ControllerJoueur.getIdJoueurCourant() == -1) {
                labelInformationSelectionJoueur.setText("Veuillez sélectionner un joueur");
            } else {
                CONTROLLER_JOUEUR.joueurListGetSelectedJoueur(listJoueurs);
                CONTROLLER_JOUEUR.supprimerJoueurSelectionne();

                refreshAffichageListJoueur();
            }
        }

        //Actions CréationModificationTournoi
        if (e.getSource() == buttonEnregistrerTournoi) {
            enregistrerTournoi();
        }
        if (e.getSource() == buttonResetInfosTournoi) {
            resetInformationFormulaireTournoi();
        }

        //Action de Gestion Tournoi
        if (e.getSource() == buttonSelectionnerTournoi) {
            if (ControllerTournoi.getIdTournoiCourant() == -1) {
                labelInformationSelectionTournoi.setText("Veuillez sélectionner un tournoi");
            } else {
                String titre = ControllerTournoi.getInfoTournoiCourant().get("nom");
                labelTitreTournoi = new JLabel();
                labelTitreTournoi.setText(titre);
                createPanelEcranTournoi();
            }
        }
        if (e.getSource() == buttonModifierTournoi) {
            if (ControllerTournoi.getIdTournoiCourant() == -1) {
                labelInformationSelectionTournoi.setText("Veuillez sélectionner un tournoi");
            } else {
                setMODIFICATION(true);
                createPanelCreationORModificationTournoi(ControllerTournoi.getInfoTournoiCourant());
            }
        }
        if (e.getSource() == buttonSupprimerTournoi) {
            if (ControllerTournoi.getIdTournoiCourant() == -1) {
                labelInformationSelectionTournoi.setText("Veuillez sélectionner un tournoi");
            } else {
                CONTROLLER_TOURNOI.tournoiListGetSelectedTournoi(listJoueurs);
                CONTROLLER_TOURNOI.supprimerTournoiSelectionne();

                refreshAffichageListTournoi();
            }
        }

        //Action de Ecran Tournoi
        if(e.getSource() == buttonAjouterJoueursAuTournoi){
            createPanelAjoutJoueurTournoi();
        }
        if(e.getSource() == buttonSelectionRonde){

        }
        if(e.getSource() == buttonGenererListParticipant){
            CONTROLLER_TOURNOI.creerPDFListeJoueurs();
        }
        if(e.getSource() == buttonValiderAppareillement){
            //enregistrer les rencontres dnas la base de données
        }

        //Action de Ajout Joueurs Tournoi
        if(e.getSource() == buttonAjouter){
            CONTROLLER_TOURNOI.ajoutJoueurToTournoiList(listJoueursDedans, listJoueursDehors);
        }
        if(e.getSource() == buttonEnlever){
            CONTROLLER_TOURNOI.retireJoueurToTournoiList(listJoueursDedans, listJoueursDehors);
        }
        if(e.getSource() == buttonConfirmer){
            CONTROLLER_TOURNOI.ajoutJoueursTournoi();
            labelInformationConfirmationAjoutJoueur.setText("Enregistrement confirmé");
            confirmed = true;
        }
        if(e.getSource() == buttonRetour){
            if(!confirmed){
                confirmed = true;
                labelInformationConfirmationAjoutJoueur.setText("Vous n'avez pas enregistré, appuyez de nouveau sur retour pour annuler");
            }else{
                labelInformationConfirmationAjoutJoueur.setText("");
                confirmed = false;

                createPanelEcranTournoi();
            }
        }
        if(e.getSource() == buttonAnnuler){
            createPanelEcranTournoi();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }
    @Override
    public void windowOpened(WindowEvent e) {
    }
    @Override
    public void windowClosing(WindowEvent e) {
    }
    @Override
    public void windowIconified(WindowEvent e) {
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    @Override
    public void windowActivated(WindowEvent e) {
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
