package projetechec;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.transform.TransformerException;

public class MenuPrincipal extends javax.swing.JFrame {

    private static ControllerJoueur controllerJoueur= new ControllerJoueur();
    public static XMLTournoi xml2 = new XMLTournoi();
    
    public static int idTournoiCourant = -1;
    public static int idJoueurCourant = -1;
    public static int idJoueurDedans = -1;
    public static int idJoueurDehors = -1;
    public static ArrayList<Joueurs> joueursDedans;
    public static ArrayList<Joueurs> joueursDehors;
    
    public static int IDJ;
    public static Joueurs Jmodif;
    
    public static int IDT;
    public static Tournoi Tmodif;
    
    public static boolean confirmed = true;
    
    public MenuPrincipal() {
        initComponents();
        initPanel(menuPrinc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPrinc = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        createTournament = new javax.swing.JButton();
        createPlayer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        SelectionTournoi = new javax.swing.JButton();
        creationJoueur = new javax.swing.JPanel();
        nomLabel = new javax.swing.JLabel();
        prenomLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        sexeLabel = new javax.swing.JLabel();
        licenceLabel = new javax.swing.JLabel();
        federationLabel = new javax.swing.JLabel();
        ligueLabel = new javax.swing.JLabel();
        clubLabel = new javax.swing.JLabel();
        eloNormalLabel = new javax.swing.JLabel();
        eloRapideLabel = new javax.swing.JLabel();
        eloSemiRapideLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        nomTextField = new javax.swing.JTextField();
        mainMenuButton = new javax.swing.JButton();
        prenomTextField = new javax.swing.JTextField();
        dateTextField = new javax.swing.JTextField();
        licenceTextField = new javax.swing.JTextField();
        federationTextField = new javax.swing.JTextField();
        ligueTextField = new javax.swing.JTextField();
        clubTextField = new javax.swing.JTextField();
        eloNormalTextField = new javax.swing.JTextField();
        eloSemiRapideTextField = new javax.swing.JTextField();
        eloRapideTextField = new javax.swing.JTextField();
        noteLabel = new javax.swing.JLabel();
        titleMenuLabel = new javax.swing.JLabel();
        dateFormatLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        retourTextArea = new javax.swing.JTextArea();
        afficherJoueur = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AffJTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        retourMenuAff = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        affichageJoueurList = new javax.swing.JList<>();
        supprimerJoueurButton = new javax.swing.JButton();
        modifierJoueurButton = new javax.swing.JButton();
        ErreurSelectJoueur = new javax.swing.JLabel();
        creationTournoi = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        dated = new javax.swing.JLabel();
        datef = new javax.swing.JLabel();
        nbr = new javax.swing.JLabel();
        lieu = new javax.swing.JLabel();
        nomTextField1 = new javax.swing.JTextField();
        datedTextField2 = new javax.swing.JTextField();
        dateFTextField3 = new javax.swing.JTextField();
        nbRTextField4 = new javax.swing.JTextField();
        lieuTextField5 = new javax.swing.JTextField();
        dateFormatLabel2 = new javax.swing.JLabel();
        dateFormatLabel3 = new javax.swing.JLabel();
        enregistreT = new javax.swing.JButton();
        menuprincT = new javax.swing.JButton();
        cleanT = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        msgErreurT = new javax.swing.JTextArea();
        selectionTournoi = new javax.swing.JPanel();
        SelectionTournoiMenuPrincjButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        selectionTournoijList = new javax.swing.JList<>();
        selectionTournoiSelectionnerjButton = new javax.swing.JButton();
        selectionTournoiMessagejLabel = new javax.swing.JLabel();
        supprimerTournoi = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        affichageTournois = new javax.swing.JTextArea();
        modifierTournoi = new javax.swing.JButton();
        afficheTournoiTitre = new javax.swing.JLabel();
        ecranTournoi = new javax.swing.JPanel();
        ajouterJoueurjButton = new javax.swing.JButton();
        ecranTournoiMenuPrincjButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ajoutJoueurTournoi = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ajoutJoueurTounroiJoueurDehorsjList = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        ajoutJoueurTounroiJoueurDedansjList = new javax.swing.JList<>();
        ajoutJoueurTournoiAjouterjButton = new javax.swing.JButton();
        AjouteJoueurTournoiRemovejButton = new javax.swing.JButton();
        AjoutJoueurTournoiRetourjButton = new javax.swing.JButton();
        ajoutJoueurTournoiConfirmerjButton = new javax.swing.JButton();
        ajoutJoueurTournoiMessagejLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        modifierJoueur = new javax.swing.JPanel();
        nomLabel1 = new javax.swing.JLabel();
        prenomLabel1 = new javax.swing.JLabel();
        dateLabel1 = new javax.swing.JLabel();
        sexeLabel1 = new javax.swing.JLabel();
        licenceLabel1 = new javax.swing.JLabel();
        federationLabel1 = new javax.swing.JLabel();
        ligueLabel1 = new javax.swing.JLabel();
        clubLabel1 = new javax.swing.JLabel();
        eloNormalLabel1 = new javax.swing.JLabel();
        eloRapideLabel1 = new javax.swing.JLabel();
        eloSemiRapideLabel1 = new javax.swing.JLabel();
        saveButton1 = new javax.swing.JButton();
        nomTextField2 = new javax.swing.JTextField();
        prenomTextField1 = new javax.swing.JTextField();
        dateTextField1 = new javax.swing.JTextField();
        licenceTextField1 = new javax.swing.JTextField();
        federationTextField1 = new javax.swing.JTextField();
        ligueTextField1 = new javax.swing.JTextField();
        clubTextField1 = new javax.swing.JTextField();
        eloNormalTextField1 = new javax.swing.JTextField();
        eloSemiRapideTextField1 = new javax.swing.JTextField();
        eloRapideTextField1 = new javax.swing.JTextField();
        noteLabel1 = new javax.swing.JLabel();
        titleMenuLabel1 = new javax.swing.JLabel();
        dateFormatLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        retourTextArea1 = new javax.swing.JTextArea();
        mainMenuButton1 = new javax.swing.JButton();
        modifierTournoiJPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nom1 = new javax.swing.JLabel();
        dated1 = new javax.swing.JLabel();
        datef1 = new javax.swing.JLabel();
        nbr1 = new javax.swing.JLabel();
        lieu1 = new javax.swing.JLabel();
        nomTextField3 = new javax.swing.JTextField();
        datedTextField3 = new javax.swing.JTextField();
        dateFTextField4 = new javax.swing.JTextField();
        nbRTextField5 = new javax.swing.JTextField();
        lieuTextField6 = new javax.swing.JTextField();
        dateFormatLabel4 = new javax.swing.JLabel();
        dateFormatLabel5 = new javax.swing.JLabel();
        SauvModif = new javax.swing.JButton();
        menuprincT1 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        msgErreurT1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));
        setSize(new java.awt.Dimension(800, 800));

        menuPrinc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuPrinc.setMaximumSize(new java.awt.Dimension(800, 800));
        menuPrinc.setMinimumSize(new java.awt.Dimension(800, 800));
        menuPrinc.setName(""); // NOI18N
        menuPrinc.setPreferredSize(new java.awt.Dimension(800, 800));

        jLabel2.setText("Veuillez sélectionner un sous menu");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Menu Principal");

        createTournament.setText("Création d'un tournoi");
        createTournament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTournamentActionPerformed(evt);
            }
        });

        createPlayer.setText("Création d'un joueur");
        createPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlayerActionPerformed(evt);
            }
        });

        jButton1.setText("Gestion des joueurs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SelectionTournoi.setText("Gestion des tournois");
        SelectionTournoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionTournoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPrincLayout = new javax.swing.GroupLayout(menuPrinc);
        menuPrinc.setLayout(menuPrincLayout);
        menuPrincLayout.setHorizontalGroup(
            menuPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPrincLayout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
            .addGroup(menuPrincLayout.createSequentialGroup()
                .addGroup(menuPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPrincLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addGroup(menuPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(menuPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createTournament, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(menuPrincLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPrincLayout.setVerticalGroup(
            menuPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPrincLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addGroup(menuPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createTournament, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectionTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(448, Short.MAX_VALUE))
        );

        getContentPane().add(menuPrinc, java.awt.BorderLayout.CENTER);

        creationJoueur.setMaximumSize(new java.awt.Dimension(800, 800));
        creationJoueur.setMinimumSize(new java.awt.Dimension(800, 800));

        nomLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomLabel.setText("Nom : *");

        prenomLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomLabel.setText("Prenom : *");

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLabel.setText("Date de naissance : *");

        sexeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sexeLabel.setText("Sexe : *");

        licenceLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        licenceLabel.setText("Numéro de licence :");

        federationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        federationLabel.setText("Fédération :");

        ligueLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ligueLabel.setText("Ligue :");

        clubLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clubLabel.setText("Club :");

        eloNormalLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eloNormalLabel.setText("Elo (Classique) :");

        eloRapideLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eloRapideLabel.setText("Elo (rapide) :");

        eloSemiRapideLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eloSemiRapideLabel.setText("Elo (Semi rapide) :");

        saveButton.setText("Sauvegarder");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        mainMenuButton.setText("Menu Principal");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        noteLabel.setFont(new java.awt.Font("Ubuntu", 3, 12)); // NOI18N
        noteLabel.setText("nb : (*) champs obligatoire");

        titleMenuLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        titleMenuLabel.setText("Création d'une fiche joueur");

        dateFormatLabel.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        dateFormatLabel.setText("JJ/MM/AAAA");

        clearButton.setText("Réinitialiser");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        retourTextArea.setColumns(20);
        retourTextArea.setRows(5);
        retourTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(retourTextArea);

        javax.swing.GroupLayout creationJoueurLayout = new javax.swing.GroupLayout(creationJoueur);
        creationJoueur.setLayout(creationJoueurLayout);
        creationJoueurLayout.setHorizontalGroup(
            creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creationJoueurLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creationJoueurLayout.createSequentialGroup()
                        .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noteLabel)
                            .addGroup(creationJoueurLayout.createSequentialGroup()
                                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eloSemiRapideLabel)
                                    .addComponent(eloNormalLabel)
                                    .addComponent(clubLabel)
                                    .addComponent(ligueLabel)
                                    .addComponent(federationLabel)
                                    .addComponent(licenceLabel)
                                    .addComponent(dateLabel)
                                    .addComponent(prenomLabel)
                                    .addComponent(nomLabel)
                                    .addComponent(eloRapideLabel)
                                    .addComponent(sexeLabel))
                                .addGap(48, 48, 48)
                                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prenomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(creationJoueurLayout.createSequentialGroup()
                                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFormatLabel))
                                    .addComponent(licenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(federationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ligueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clubTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eloNormalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eloSemiRapideTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eloRapideTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, creationJoueurLayout.createSequentialGroup()
                                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(mainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creationJoueurLayout.createSequentialGroup()
                        .addComponent(titleMenuLabel)
                        .addGap(319, 319, 319))))
        );
        creationJoueurLayout.setVerticalGroup(
            creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creationJoueurLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleMenuLabel)
                .addGap(26, 26, 26)
                .addComponent(noteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel)
                    .addComponent(nomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomLabel)
                    .addComponent(prenomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFormatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexeLabel)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(licenceLabel)
                    .addComponent(licenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(federationLabel)
                    .addComponent(federationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ligueLabel)
                    .addComponent(ligueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clubLabel)
                    .addComponent(clubTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eloNormalLabel)
                    .addComponent(eloNormalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eloSemiRapideLabel)
                    .addComponent(eloSemiRapideTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eloRapideLabel)
                    .addComponent(eloRapideTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(creationJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(332, Short.MAX_VALUE))
        );

        getContentPane().add(creationJoueur, java.awt.BorderLayout.PAGE_START);

        afficherJoueur.setMaximumSize(new java.awt.Dimension(800, 800));
        afficherJoueur.setMinimumSize(new java.awt.Dimension(800, 800));
        afficherJoueur.setRequestFocusEnabled(false);

        AffJTextArea1.setColumns(20);
        AffJTextArea1.setRows(5);
        jScrollPane1.setViewportView(AffJTextArea1);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Affichage des joueurs");

        retourMenuAff.setText("Retour menu principal");
        retourMenuAff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourMenuAffActionPerformed(evt);
            }
        });

        jScrollPane2.setAutoscrolls(true);

        affichageJoueurList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                affichageJoueurListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(affichageJoueurList);

        supprimerJoueurButton.setText("Supprimer Joueur");
        supprimerJoueurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerJoueurButtonActionPerformed(evt);
            }
        });

        modifierJoueurButton.setText("Modifier Joueur");
        modifierJoueurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierJoueurButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout afficherJoueurLayout = new javax.swing.GroupLayout(afficherJoueur);
        afficherJoueur.setLayout(afficherJoueurLayout);
        afficherJoueurLayout.setHorizontalGroup(
            afficherJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(afficherJoueurLayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(afficherJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, afficherJoueurLayout.createSequentialGroup()
                        .addComponent(modifierJoueurButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(afficherJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(afficherJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, afficherJoueurLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(supprimerJoueurButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(retourMenuAff, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(afficherJoueurLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1677, Short.MAX_VALUE))
            .addGroup(afficherJoueurLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(ErreurSelectJoueur)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        afficherJoueurLayout.setVerticalGroup(
            afficherJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(afficherJoueurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(afficherJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(ErreurSelectJoueur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(afficherJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifierJoueurButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retourMenuAff, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimerJoueurButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(388, Short.MAX_VALUE))
        );

        getContentPane().add(afficherJoueur, java.awt.BorderLayout.PAGE_END);

        creationTournoi.setMaximumSize(new java.awt.Dimension(800, 800));
        creationTournoi.setMinimumSize(new java.awt.Dimension(800, 800));
        creationTournoi.setPreferredSize(new java.awt.Dimension(800, 800));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("Création d'un tournoi");

        nom.setText("Nom : *");

        dated.setText("Date debut : *");

        datef.setText("Date fin : *");

        nbr.setText("Nombre de rondes : *");

        lieu.setText("Lieu :");

        dateFormatLabel2.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        dateFormatLabel2.setText("JJ/MM/AAAA");

        dateFormatLabel3.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        dateFormatLabel3.setText("JJ/MM/AAAA");

        enregistreT.setText("Sauvegarder");
        enregistreT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistreTActionPerformed(evt);
            }
        });

        menuprincT.setText("Menu principal");
        menuprincT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuprincTActionPerformed(evt);
            }
        });

        cleanT.setText("Réinitialiser");
        cleanT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanTActionPerformed(evt);
            }
        });

        msgErreurT.setColumns(20);
        msgErreurT.setRows(5);
        jScrollPane4.setViewportView(msgErreurT);

        javax.swing.GroupLayout creationTournoiLayout = new javax.swing.GroupLayout(creationTournoi);
        creationTournoi.setLayout(creationTournoiLayout);
        creationTournoiLayout.setHorizontalGroup(
            creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creationTournoiLayout.createSequentialGroup()
                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creationTournoiLayout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel4))
                    .addGroup(creationTournoiLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(creationTournoiLayout.createSequentialGroup()
                                .addComponent(cleanT, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enregistreT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menuprincT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(creationTournoiLayout.createSequentialGroup()
                                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nom)
                                    .addComponent(dated)
                                    .addComponent(datef)
                                    .addComponent(nbr)
                                    .addComponent(lieu))
                                .addGap(14, 14, 14)
                                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lieuTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nbRTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(creationTournoiLayout.createSequentialGroup()
                                        .addComponent(datedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFormatLabel2))
                                    .addGroup(creationTournoiLayout.createSequentialGroup()
                                        .addComponent(dateFTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFormatLabel3)))))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        creationTournoiLayout.setVerticalGroup(
            creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creationTournoiLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nom)
                    .addComponent(nomTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dated)
                    .addComponent(datedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFormatLabel2))
                .addGap(18, 18, 18)
                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateFTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFormatLabel3))
                .addGap(18, 18, 18)
                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nbRTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbr))
                .addGap(21, 21, 21)
                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lieu)
                    .addComponent(lieuTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(creationTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enregistreT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleanT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuprincT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(389, 389, 389))
        );

        nomTextField1.getAccessibleContext().setAccessibleName("nomT");
        datedTextField2.getAccessibleContext().setAccessibleName("DateDT");
        dateFTextField3.getAccessibleContext().setAccessibleName("DateFinT");
        nbRTextField4.getAccessibleContext().setAccessibleName("nbRonde");
        lieuTextField5.getAccessibleContext().setAccessibleName("lieuT");

        getContentPane().add(creationTournoi, java.awt.BorderLayout.LINE_END);

        selectionTournoi.setMaximumSize(new java.awt.Dimension(800, 800));
        selectionTournoi.setMinimumSize(new java.awt.Dimension(800, 800));

        SelectionTournoiMenuPrincjButton.setText("Menu Principal");
        SelectionTournoiMenuPrincjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionTournoiMenuPrincjButtonActionPerformed(evt);
            }
        });

        selectionTournoijList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                selectionTournoijListValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(selectionTournoijList);

        selectionTournoiSelectionnerjButton.setText("Sélectionner");
        selectionTournoiSelectionnerjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionTournoiSelectionnerjButtonActionPerformed(evt);
            }
        });

        supprimerTournoi.setText("Supprimer");
        supprimerTournoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerTournoiActionPerformed(evt);
            }
        });

        affichageTournois.setColumns(20);
        affichageTournois.setRows(5);
        jScrollPane9.setViewportView(affichageTournois);

        modifierTournoi.setText("Modifier");
        modifierTournoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierTournoiActionPerformed(evt);
            }
        });

        afficheTournoiTitre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        afficheTournoiTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        afficheTournoiTitre.setText("Affichage des joueurs");

        javax.swing.GroupLayout selectionTournoiLayout = new javax.swing.GroupLayout(selectionTournoi);
        selectionTournoi.setLayout(selectionTournoiLayout);
        selectionTournoiLayout.setHorizontalGroup(
            selectionTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectionTournoiLayout.createSequentialGroup()
                .addGroup(selectionTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(selectionTournoiLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(selectionTournoiLayout.createSequentialGroup()
                        .addGroup(selectionTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(selectionTournoiLayout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(selectionTournoiMessagejLabel))
                            .addGroup(selectionTournoiLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(selectionTournoiSelectionnerjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(modifierTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(supprimerTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SelectionTournoiMenuPrincjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(selectionTournoiLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(afficheTournoiTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        selectionTournoiLayout.setVerticalGroup(
            selectionTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectionTournoiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(afficheTournoiTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(selectionTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(selectionTournoiMessagejLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectionTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectionTournoiMenuPrincjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimerTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionTournoiSelectionnerjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifierTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(265, 265, 265))
        );

        getContentPane().add(selectionTournoi, java.awt.BorderLayout.LINE_START);

        ecranTournoi.setMaximumSize(new java.awt.Dimension(800, 800));
        ecranTournoi.setMinimumSize(new java.awt.Dimension(800, 800));

        ajouterJoueurjButton.setText("Ajouter des joueurs");
        ajouterJoueurjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterJoueurjButtonActionPerformed(evt);
            }
        });

        ecranTournoiMenuPrincjButton.setText("Menu principal");
        ecranTournoiMenuPrincjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecranTournoiMenuPrincjButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Cette page affichera plus tard les différentes fonctionnalités du tournoi (départage etc...)");

        javax.swing.GroupLayout ecranTournoiLayout = new javax.swing.GroupLayout(ecranTournoi);
        ecranTournoi.setLayout(ecranTournoiLayout);
        ecranTournoiLayout.setHorizontalGroup(
            ecranTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecranTournoiLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(ecranTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(ecranTournoiLayout.createSequentialGroup()
                        .addComponent(ajouterJoueurjButton)
                        .addGap(18, 18, 18)
                        .addComponent(ecranTournoiMenuPrincjButton)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        ecranTournoiLayout.setVerticalGroup(
            ecranTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecranTournoiLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(ecranTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterJoueurjButton)
                    .addComponent(ecranTournoiMenuPrincjButton))
                .addGap(69, 69, 69)
                .addComponent(jLabel8)
                .addContainerGap(653, Short.MAX_VALUE))
        );

        getContentPane().add(ecranTournoi, java.awt.BorderLayout.CENTER);

        ajoutJoueurTournoi.setMaximumSize(new java.awt.Dimension(800, 800));
        ajoutJoueurTournoi.setMinimumSize(new java.awt.Dimension(800, 800));

        ajoutJoueurTounroiJoueurDehorsjList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ajoutJoueurTounroiJoueurDehorsjListValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(ajoutJoueurTounroiJoueurDehorsjList);

        ajoutJoueurTounroiJoueurDedansjList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ajoutJoueurTounroiJoueurDedansjListValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(ajoutJoueurTounroiJoueurDedansjList);

        ajoutJoueurTournoiAjouterjButton.setText("Ajouter");
        ajoutJoueurTournoiAjouterjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutJoueurTournoiAjouterjButtonActionPerformed(evt);
            }
        });

        AjouteJoueurTournoiRemovejButton.setText("Enlever");
        AjouteJoueurTournoiRemovejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouteJoueurTournoiRemovejButtonActionPerformed(evt);
            }
        });

        AjoutJoueurTournoiRetourjButton.setText("Retour");
        AjoutJoueurTournoiRetourjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutJoueurTournoiRetourjButtonActionPerformed(evt);
            }
        });

        ajoutJoueurTournoiConfirmerjButton.setText("Confirmer");
        ajoutJoueurTournoiConfirmerjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutJoueurTournoiConfirmerjButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Joueur déjà présent dans le tournoi");

        jLabel7.setText("Joueur qui ne sont pas dans le tournoi");

        javax.swing.GroupLayout ajoutJoueurTournoiLayout = new javax.swing.GroupLayout(ajoutJoueurTournoi);
        ajoutJoueurTournoi.setLayout(ajoutJoueurTournoiLayout);
        ajoutJoueurTournoiLayout.setHorizontalGroup(
            ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                .addGroup(ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(42, 42, 42))
                            .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addGroup(ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                                .addGroup(ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ajoutJoueurTournoiAjouterjButton)
                                    .addComponent(AjouteJoueurTournoiRemovejButton))
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel6))))
                    .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(ajoutJoueurTournoiMessagejLabel))
                    .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(ajoutJoueurTournoiConfirmerjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(AjoutJoueurTournoiRetourjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        ajoutJoueurTournoiLayout.setVerticalGroup(
            ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                .addGroup(ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(jScrollPane6)))
                    .addGroup(ajoutJoueurTournoiLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(ajoutJoueurTournoiAjouterjButton)
                        .addGap(110, 110, 110)
                        .addComponent(AjouteJoueurTournoiRemovejButton)))
                .addGap(18, 18, 18)
                .addComponent(ajoutJoueurTournoiMessagejLabel)
                .addGap(9, 9, 9)
                .addGroup(ajoutJoueurTournoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AjoutJoueurTournoiRetourjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajoutJoueurTournoiConfirmerjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(306, Short.MAX_VALUE))
        );

        getContentPane().add(ajoutJoueurTournoi, java.awt.BorderLayout.CENTER);

        modifierJoueur.setMaximumSize(new java.awt.Dimension(800, 800));
        modifierJoueur.setMinimumSize(new java.awt.Dimension(800, 800));

        nomLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomLabel1.setText("Nom : *");

        prenomLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomLabel1.setText("Prénom : *");

        dateLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLabel1.setText("Date de naissance : *");

        sexeLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sexeLabel1.setText("Sexe : *");

        licenceLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        licenceLabel1.setText("Numéro de licence :");

        federationLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        federationLabel1.setText("Fédération :");

        ligueLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ligueLabel1.setText("Ligue :");

        clubLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clubLabel1.setText("Club :");

        eloNormalLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eloNormalLabel1.setText("Elo (Classique) :");

        eloRapideLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eloRapideLabel1.setText("Elo (rapide) :");

        eloSemiRapideLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eloSemiRapideLabel1.setText("Elo (Semi rapide) :");

        saveButton1.setText("Sauvegarder");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });

        noteLabel1.setFont(new java.awt.Font("Ubuntu", 3, 12)); // NOI18N
        noteLabel1.setText("nb : (*) champs obligatoire");

        titleMenuLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        titleMenuLabel1.setText("Modification d'un joueur");

        dateFormatLabel1.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        dateFormatLabel1.setText("JJ/MM/AAAA");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        retourTextArea1.setColumns(20);
        retourTextArea1.setRows(5);
        jScrollPane8.setViewportView(retourTextArea1);

        mainMenuButton1.setText("Menu Principal");
        mainMenuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modifierJoueurLayout = new javax.swing.GroupLayout(modifierJoueur);
        modifierJoueur.setLayout(modifierJoueurLayout);
        modifierJoueurLayout.setHorizontalGroup(
            modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifierJoueurLayout.createSequentialGroup()
                .addContainerGap(1798, Short.MAX_VALUE)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifierJoueurLayout.createSequentialGroup()
                        .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noteLabel1)
                            .addGroup(modifierJoueurLayout.createSequentialGroup()
                                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eloSemiRapideLabel1)
                                    .addComponent(eloNormalLabel1)
                                    .addComponent(clubLabel1)
                                    .addComponent(ligueLabel1)
                                    .addComponent(federationLabel1)
                                    .addComponent(licenceLabel1)
                                    .addComponent(dateLabel1)
                                    .addComponent(prenomLabel1)
                                    .addComponent(nomLabel1)
                                    .addComponent(eloRapideLabel1)
                                    .addComponent(sexeLabel1))
                                .addGap(48, 48, 48)
                                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prenomTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(modifierJoueurLayout.createSequentialGroup()
                                        .addComponent(dateTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFormatLabel1))
                                    .addComponent(licenceTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(federationTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ligueTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clubTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eloNormalTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eloSemiRapideTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eloRapideTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(modifierJoueurLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(mainMenuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifierJoueurLayout.createSequentialGroup()
                        .addComponent(titleMenuLabel1)
                        .addGap(319, 319, 319))))
        );
        modifierJoueurLayout.setVerticalGroup(
            modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifierJoueurLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleMenuLabel1)
                .addGap(26, 26, 26)
                .addComponent(noteLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel1)
                    .addComponent(nomTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomLabel1)
                    .addComponent(prenomTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel1)
                    .addComponent(dateTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFormatLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexeLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(licenceLabel1)
                    .addComponent(licenceTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(federationLabel1)
                    .addComponent(federationTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ligueLabel1)
                    .addComponent(ligueTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clubLabel1)
                    .addComponent(clubTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eloNormalLabel1)
                    .addComponent(eloNormalTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eloSemiRapideLabel1)
                    .addComponent(eloSemiRapideTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eloRapideLabel1)
                    .addComponent(eloRapideTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modifierJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainMenuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(332, Short.MAX_VALUE))
        );

        getContentPane().add(modifierJoueur, java.awt.BorderLayout.PAGE_START);

        modifierTournoiJPanel.setMaximumSize(new java.awt.Dimension(800, 800));
        modifierTournoiJPanel.setMinimumSize(new java.awt.Dimension(800, 800));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setText("Modification d'un tournoi");

        nom1.setText("Nom : *");

        dated1.setText("Date debut : *");

        datef1.setText("Date fin : *");

        nbr1.setText("Nombre de rondes : *");

        lieu1.setText("Lieu :");

        dateFormatLabel4.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        dateFormatLabel4.setText("JJ/MM/AAAA");

        dateFormatLabel5.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        dateFormatLabel5.setText("JJ/MM/AAAA");

        SauvModif.setText("Sauvegarder");
        SauvModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SauvModifActionPerformed(evt);
            }
        });

        menuprincT1.setText("Menu principal");
        menuprincT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuprincT1ActionPerformed(evt);
            }
        });

        msgErreurT1.setColumns(20);
        msgErreurT1.setRows(5);
        jScrollPane10.setViewportView(msgErreurT1);

        javax.swing.GroupLayout modifierTournoiJPanelLayout = new javax.swing.GroupLayout(modifierTournoiJPanel);
        modifierTournoiJPanel.setLayout(modifierTournoiJPanelLayout);
        modifierTournoiJPanelLayout.setHorizontalGroup(
            modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifierTournoiJPanelLayout.createSequentialGroup()
                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modifierTournoiJPanelLayout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel5))
                    .addGroup(modifierTournoiJPanelLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modifierTournoiJPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(SauvModif, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(menuprincT1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(modifierTournoiJPanelLayout.createSequentialGroup()
                                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nom1)
                                    .addComponent(dated1)
                                    .addComponent(datef1)
                                    .addComponent(nbr1)
                                    .addComponent(lieu1))
                                .addGap(14, 14, 14)
                                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lieuTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nbRTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(modifierTournoiJPanelLayout.createSequentialGroup()
                                        .addComponent(datedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFormatLabel4))
                                    .addGroup(modifierTournoiJPanelLayout.createSequentialGroup()
                                        .addComponent(dateFTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFormatLabel5)))))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        modifierTournoiJPanelLayout.setVerticalGroup(
            modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifierTournoiJPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nom1)
                    .addComponent(nomTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dated1)
                    .addComponent(datedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFormatLabel4))
                .addGap(18, 18, 18)
                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datef1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateFTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFormatLabel5))
                .addGap(18, 18, 18)
                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nbRTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbr1))
                .addGap(21, 21, 21)
                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lieu1)
                    .addComponent(lieuTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(modifierTournoiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SauvModif, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuprincT1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(389, 389, 389))
        );

        getContentPane().add(modifierTournoiJPanel, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initPanel(JPanel panel){
        
        menuPrinc.setVisible(false);
        creationJoueur.setVisible(false);
        afficherJoueur.setVisible(false);
        creationTournoi.setVisible(false);
        selectionTournoi.setVisible(false);
        ecranTournoi.setVisible(false);
        ajoutJoueurTournoi.setVisible(false);
        modifierJoueur.setVisible(false);
        modifierTournoiJPanel.setVisible(false);
        
        remove(menuPrinc);
        remove(creationJoueur);
        remove(afficherJoueur);
        remove(creationTournoi);
        remove(selectionTournoi);
        remove(ecranTournoi);
        remove(ajoutJoueurTournoi);
        remove(modifierJoueur);
        remove(modifierTournoiJPanel);
        
        panel.setVisible(true);
        add(panel);
        
    }
        
    private void createPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlayerActionPerformed
        
        initPanel(creationJoueur);
    }//GEN-LAST:event_createPlayerActionPerformed

    private void accesModifJoueur(int idJ, Map<String, String> infos){
        
        initPanel(modifierJoueur);
        
        nomTextField2.setText(infos.get("nom"));
        prenomTextField1.setText(infos.get("prenom"));
        dateTextField1.setText(infos.get("dateNaissance"));
        licenceTextField1.setText(infos.get("numLicence"));
        federationTextField1.setText(infos.get("federation"));
        ligueTextField1.setText(infos.get("ligue"));
        clubTextField1.setText(infos.get("club"));
        eloNormalTextField1.setText(infos.get("eloClassique"));
        eloSemiRapideTextField1.setText(infos.get("eloSemiRapide"));
        eloRapideTextField1.setText(infos.get("eloRapide"));
        retourTextArea1.setText("");
        
        IDJ = idJ;
    }
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        resetInfoJoueur();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void refreshAffichage(JTextArea textArea){
        DefaultListModel listM = controllerJoueur.setJoueurInListModel(textArea);
        affichageJoueurList.setModel(listM);
        }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshAffichage(AffJTextArea1);
        initPanel(afficherJoueur);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void createTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTournamentActionPerformed
        initPanel(creationTournoi);
    }//GEN-LAST:event_createTournamentActionPerformed

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
        resetInfoJoueur();
        initPanel(menuPrinc);
    }//GEN-LAST:event_mainMenuButtonActionPerformed

    private void retourMenuAffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourMenuAffActionPerformed
        ErreurSelectJoueur.setText("");
        initPanel(menuPrinc);
    }//GEN-LAST:event_retourMenuAffActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Map<String, String> infosJoueurs = new HashMap<>(); 
        
        infosJoueurs.put("numLicence", licenceTextField.getText());
        infosJoueurs.put("nom", nomTextField.getText());
        infosJoueurs.put("prenom", prenomTextField.getText());
        infosJoueurs.put("eloClassique", eloNormalTextField.getText());
        infosJoueurs.put("eloRapide", eloRapideTextField.getText());
        infosJoueurs.put("eloSemiRapide", eloSemiRapideTextField.getText());
        infosJoueurs.put("dateNaissance", dateTextField.getText());
        infosJoueurs.put("sexe", jComboBox1.getSelectedItem().toString());
        infosJoueurs.put("federation", federationTextField .getText());
        infosJoueurs.put("ligue", ligueTextField.getText());
        infosJoueurs.put("club", clubTextField.getText());
                
        boolean estCree = controllerJoueur.creerJoueur(infosJoueurs, nomLabel, prenomLabel, sexeLabel, dateLabel, retourTextArea);
        
        if(estCree){
            resetInfoJoueur();
            retourTextArea.setText("Joueur créé avec succès !");
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed
    
    public void resetInfoJoueur(){
        nomTextField.setText("");
        prenomTextField.setText("");
        dateTextField.setText("");
        licenceTextField.setText("");
        federationTextField.setText("");
        ligueTextField.setText("");
        clubTextField.setText("");
        eloNormalTextField.setText("");
        eloSemiRapideTextField.setText("");
        eloRapideTextField.setText("");
        retourTextArea.setText("");
        nomLabel.setForeground(Color.black);
        prenomLabel.setForeground(Color.black);
        sexeLabel.setForeground(Color.black);
        dateLabel.setForeground(Color.black);
    }
    
    private void cleanTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanTActionPerformed
        nomTextField1.setText("");
        datedTextField2.setText("");
        dateFTextField3.setText("");
        nbRTextField4.setText("");
        lieuTextField5.setText("");
        msgErreurT.setText("");
        nom.setForeground(Color.black);
        dated.setForeground(Color.black);
        datef.setForeground(Color.black);
        nbr.setForeground(Color.black);
    }//GEN-LAST:event_cleanTActionPerformed

    private void menuprincTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuprincTActionPerformed
        nomTextField1.setText("");
        datedTextField2.setText("");
        dateFTextField3.setText("");
        nbRTextField4.setText("");
        lieuTextField5.setText("");
        msgErreurT.setText("");
        nom.setForeground(Color.black);
        dated.setForeground(Color.black);
        datef.setForeground(Color.black);
        nbr.setForeground(Color.black);
        
        initPanel(menuPrinc);
    }//GEN-LAST:event_menuprincTActionPerformed

    private void enregistreTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistreTActionPerformed
        String nomTournoi=nomTextField1.getText();
        String dateDebut= datedTextField2.getText();
        String dateFin=dateFTextField3.getText();
        String nbRondes=nbRTextField4.getText();
        String lieu=lieuTextField5.getText();
        nom.setForeground(Color.black);
        dated.setForeground(Color.black);
        datef.setForeground(Color.black);
        nbr.setForeground(Color.black);
        Tournoi t = new Tournoi(nomTournoi,dateDebut,dateFin,nbRondes,lieu);
        String stmp="Données incorrectes: ";
        boolean test = true;
        if(!t.verifDonneesSensiblesCompletes())
        {
            test= false;
            if(t.nomTournoiEstVide()){
                nom.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Nom Tournoi manquant";
            }
            if(t.dateDebutEstVide()){
                dated.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Date de début manquante";
            }
            if(t.dateFinEstVide()){
                datef.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Date de fin manquante";
            }
            if(t.nbRondesEstVide()){
                nbr.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Nombre de rondes manquant";
            }
        }
        if(!t.verifTailleNomTournoi()){
            nom.setForeground(Color.red);
            stmp += System.getProperty("line.separator")+"Nom de tournoi limité à 50 caractères.";
        }
        if(!t.verifFormatDateValide(dateDebut))
        {
            test= false;
            if(!t.verifMatchDate(dateDebut)){
                dated.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!t.verifDateValide(dateDebut)){
                    dated.setForeground(Color.red);
                    stmp += System.getProperty("line.separator")+"Erreur, date incorrecte";
                }
            }
        } 
        if(!t.verifFormatDateValide(dateFin))
        {
            test= false;
            if(!t.verifMatchDate(dateFin)){
                dated.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!t.verifDateValide(dateFin)){
                    dated.setForeground(Color.red);
                    stmp += System.getProperty("line.separator")+"Erreur, date incorrecte";
                }
            }
        }
        if(t.verifFormatDateValide(dateDebut) && t.verifFormatDateValide(dateFin)){
            if(!t.verifDateDebut(dateDebut)){
                test= false;
                dated.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Erreur, date de début infèrieure à la date actuelle.";
            }
            if(!t.verifDateDebutAvantDateFin(dateDebut, dateFin)){
                test= false;
                stmp += System.getProperty("line.separator")+"Erreur, date de début plus récente que date de fin.";
            }
        }
        if(!t.verifNbRondes()){
            test = false;
            stmp += System.getProperty("line.separator")+"Erreur, le nombre de rondes doit être positif.";
        }
        msgErreurT.setText(stmp);
        if(test){
            msgErreurT.setText("Tournoi créé avec succès !");
            xml2.WriteXML(t);
        }
    }//GEN-LAST:event_enregistreTActionPerformed

    private void affichageJoueurListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_affichageJoueurListValueChanged
        controllerJoueur.joueurListGetSelectedJoueur(affichageJoueurList, AffJTextArea1); 
        controllerJoueur.setInfoJoueurInTextArea(affichageJoueurList, AffJTextArea1); 
    }//GEN-LAST:event_affichageJoueurListValueChanged

    private void supprimerJoueurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerJoueurButtonActionPerformed
        if(ControllerJoueur.getIdJoueurCourant() == -1){
            ErreurSelectJoueur.setText("Veuillez sélectionner un joueur");
        }else{
            controllerJoueur.joueurListGetSelectedJoueur(affichageJoueurList, AffJTextArea1);
            controllerJoueur.supprimerJoueurSelectionne();
            refreshAffichage(AffJTextArea1);
        }
    }//GEN-LAST:event_supprimerJoueurButtonActionPerformed

    private void modifierJoueurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierJoueurButtonActionPerformed
        if(ControllerJoueur.getIdJoueurCourant()== -1){
            ErreurSelectJoueur.setText("Veuillez sélectionner un joueur");
        }else{
            ArrayList<Map<String, String>> listeInfoJoueurs= controllerJoueur.lireJoueurInStringList();
            String s = (String) affichageJoueurList.getSelectedValue();
            int intTmp = -1;
            if(s != null && !s.isEmpty()){
                intTmp = Integer.valueOf(s.split(" ")[0]);
            }
            if(intTmp != -1){
                accesModifJoueur(intTmp, listeInfoJoueurs.get(intTmp-1));
            }

            refreshAffichage(AffJTextArea1);
        }
    }//GEN-LAST:event_modifierJoueurButtonActionPerformed

    private void SelectionTournoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectionTournoiActionPerformed

        idTournoiCourant = -1;
        
        ArrayList<Tournoi> listT = xml2.ReadXML();
        DefaultListModel listM = new DefaultListModel();
        selectionTournoijList.setModel(listM);
        String tmp="";
        String tmpList = "";
        for (int i=0;i<listT.size();i++){
            tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
            tmpList =(i+1)+" Tournoi n°"+(i+1)+" "+listT.get(i).getNomTournoi();
            listM.addElement(tmpList);
            tmp=tmp+listT.get(i).TtoString()+System.getProperty("line.separator");
        }
        affichageTournois.setText(tmp);
        
        initPanel(selectionTournoi);

    }//GEN-LAST:event_SelectionTournoiActionPerformed

    private void SelectionTournoiMenuPrincjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectionTournoiMenuPrincjButtonActionPerformed
        selectionTournoijList.setModel(new DefaultListModel());
        selectionTournoiMessagejLabel.setText("");
        
        idTournoiCourant = -1;
        
        initPanel(menuPrinc);
    }//GEN-LAST:event_SelectionTournoiMenuPrincjButtonActionPerformed

    private void selectionTournoiSelectionnerjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionTournoiSelectionnerjButtonActionPerformed
        if(MenuPrincipal.idTournoiCourant == -1){
            selectionTournoiMessagejLabel.setText("Veuillez sélectionner un tournoi");
        }else{
            selectionTournoijList.setModel(new DefaultListModel());

            selectionTournoiMessagejLabel.setText("");
            
            initPanel(ecranTournoi);
        }
    }//GEN-LAST:event_selectionTournoiSelectionnerjButtonActionPerformed

    private void selectionTournoijListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_selectionTournoijListValueChanged
        ArrayList<Tournoi> listT = xml2.ReadXML();
        String afftmp;
        String s = (String) selectionTournoijList.getSelectedValue();
        if(s != null && !s.isEmpty()){
            String tmp = s.split(" ")[0];
            MenuPrincipal.idTournoiCourant = Integer.valueOf(tmp);
            afftmp=listT.get(Integer.valueOf(tmp)-1).TtoString()+System.getProperty("line.separator");
            affichageTournois.setText(afftmp);
        }
        
    }//GEN-LAST:event_selectionTournoijListValueChanged

    private void ecranTournoiMenuPrincjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecranTournoiMenuPrincjButtonActionPerformed
        
        idTournoiCourant = -1;
        
        initPanel(menuPrinc);
    }//GEN-LAST:event_ecranTournoiMenuPrincjButtonActionPerformed

    private void ajouterJoueurjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterJoueurjButtonActionPerformed
        
        ArrayList<Joueurs> listJ = xml2.getJoueursFromTournoi(MenuPrincipal.idTournoiCourant-1);
        DefaultListModel listM = new DefaultListModel();
        ajoutJoueurTounroiJoueurDedansjList.setModel(listM);
        String tmp="";
        String tmpList = "";
        for (int i=0;i<listJ.size();i++){
            //tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
            tmpList =(i+1)+" "+listJ.get(i).getNumLicenceJ()+ " " +listJ.get(i).getNomJ()+ " " +listJ.get(i).getPrenomJ();
            listM.addElement(tmpList);
        }
        
        ArrayList<Joueurs> listJ2 = controllerJoueur.lireJoueur();
        ArrayList<Integer> toRemove = new ArrayList<>();
        for (Joueurs listJ1 : listJ) {
            for (int i = 0; i<listJ2.size(); i++){
                if(!"".equals(listJ1.getNumLicenceJ())){
                    if(listJ1.getNumLicenceJ().equals(listJ2.get(i).getNumLicenceJ())){
                        toRemove.add(i);
                    }
                }else{
                    if(listJ1.getNomJ().equals(listJ2.get(i).getNomJ()) && listJ1.getPrenomJ().equals(listJ2.get(i).getPrenomJ()) && listJ1.getDateNaisJ().equals(listJ2.get(i).getDateNaisJ())){
                        toRemove.add(i);
                    }
                }
            }
        }
        Collections.sort(toRemove);
        for (int i = toRemove.size()-1; i >= 0; i--){
            int integer = toRemove.get(i);
            Joueurs j = listJ2.get(integer);
            listJ2.remove(j);
        }
        
        
        DefaultListModel listM2 = new DefaultListModel();
        ajoutJoueurTounroiJoueurDehorsjList.setModel(listM2);
        String tmpList2 = "";
        for (int i=0;i<listJ2.size();i++){
            //tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
            tmpList2 =(i+1)+" "+listJ2.get(i).getNumLicenceJ()+ " " +listJ2.get(i).getNomJ()+ " " +listJ2.get(i).getPrenomJ();
            listM2.addElement(tmpList2);
        }
        MenuPrincipal.joueursDedans = listJ;
        MenuPrincipal.joueursDehors = listJ2;
        
        
        
        initPanel(ajoutJoueurTournoi);
    }//GEN-LAST:event_ajouterJoueurjButtonActionPerformed

    private void AjoutJoueurTournoiRetourjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutJoueurTournoiRetourjButtonActionPerformed
        if(!confirmed){
            confirmed = true;
            ajoutJoueurTournoiMessagejLabel.setText("Vous n'avez pas enregistré, appuyez de nouveau sur retour pour annuler");
        }else{
            ajoutJoueurTournoiMessagejLabel.setText("");
            confirmed = false;
            
            initPanel(ecranTournoi);
        }
    }//GEN-LAST:event_AjoutJoueurTournoiRetourjButtonActionPerformed

    private void ajoutJoueurTounroiJoueurDehorsjListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ajoutJoueurTounroiJoueurDehorsjListValueChanged
        //mettre autre part
        ArrayList<Joueurs> listJ = MenuPrincipal.joueursDehors;
        String afftmp;
        String s = (String) ajoutJoueurTounroiJoueurDehorsjList.getSelectedValue();
        if(s != null && !s.isEmpty()){
            String tmp = s.split(" ")[0];
            MenuPrincipal.idJoueurDehors = Integer.valueOf(tmp);
        }
    }//GEN-LAST:event_ajoutJoueurTounroiJoueurDehorsjListValueChanged

    private void ajoutJoueurTournoiAjouterjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutJoueurTournoiAjouterjButtonActionPerformed
        //mettre autre part
        if(MenuPrincipal.idJoueurDehors != -1){
            MenuPrincipal.joueursDedans.add(MenuPrincipal.joueursDehors.get(MenuPrincipal.idJoueurDehors-1));
            MenuPrincipal.joueursDehors.remove(MenuPrincipal.idJoueurDehors-1);
            
            DefaultListModel listM = new DefaultListModel();
            ajoutJoueurTounroiJoueurDedansjList.setModel(listM);
            String tmp="";
            String tmpList = "";
            for (int i=0;i<MenuPrincipal.joueursDedans.size();i++){
                //tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
                tmpList =(i+1)+" "+MenuPrincipal.joueursDedans.get(i).getNumLicenceJ()+ " " +MenuPrincipal.joueursDedans.get(i).getNomJ()+ " " +MenuPrincipal.joueursDedans.get(i).getPrenomJ();
                listM.addElement(tmpList);
            }
            
            DefaultListModel listM2 = new DefaultListModel();
            ajoutJoueurTounroiJoueurDehorsjList.setModel(listM2);
            String tmpList2 = "";
            for (int i=0;i<MenuPrincipal.joueursDehors.size();i++){
                //tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
                tmpList2 =(i+1)+" "+MenuPrincipal.joueursDehors.get(i).getNumLicenceJ()+ " " +MenuPrincipal.joueursDehors.get(i).getNomJ()+ " " +MenuPrincipal.joueursDehors.get(i).getPrenomJ();
                listM2.addElement(tmpList2);
            }
            
            MenuPrincipal.idJoueurDehors = -1;
            confirmed = false;
        }
    }//GEN-LAST:event_ajoutJoueurTournoiAjouterjButtonActionPerformed

    private void ajoutJoueurTounroiJoueurDedansjListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ajoutJoueurTounroiJoueurDedansjListValueChanged
        //mettre autre part
        ArrayList<Joueurs> listJ = MenuPrincipal.joueursDedans;
        String afftmp;
        String s = (String) ajoutJoueurTounroiJoueurDedansjList.getSelectedValue();
        if(s != null && !s.isEmpty()){
            String tmp = s.split(" ")[0];
            MenuPrincipal.idJoueurDedans = Integer.valueOf(tmp);
        }
    }//GEN-LAST:event_ajoutJoueurTounroiJoueurDedansjListValueChanged

    private void AjouteJoueurTournoiRemovejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouteJoueurTournoiRemovejButtonActionPerformed
        //mettre autre part
        if(MenuPrincipal.idJoueurDedans != -1){
            MenuPrincipal.joueursDehors.add(MenuPrincipal.joueursDedans.get(MenuPrincipal.idJoueurDedans-1));
            MenuPrincipal.joueursDedans.remove(MenuPrincipal.idJoueurDedans-1);
            
            DefaultListModel listM = new DefaultListModel();
            ajoutJoueurTounroiJoueurDehorsjList.setModel(listM);
            String tmp="";
            String tmpList = "";
            for (int i=0;i<MenuPrincipal.joueursDehors.size();i++){
                //tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
                tmpList =(i+1)+" "+MenuPrincipal.joueursDehors.get(i).getNumLicenceJ()+ " " +MenuPrincipal.joueursDehors.get(i).getNomJ()+ " " +MenuPrincipal.joueursDehors.get(i).getPrenomJ();
                listM.addElement(tmpList);
            }
            
            DefaultListModel listM2 = new DefaultListModel();
            ajoutJoueurTounroiJoueurDedansjList.setModel(listM2);
            String tmpList2 = "";
            for (int i=0;i<MenuPrincipal.joueursDedans.size();i++){
                //tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
                tmpList2 =(i+1)+" "+MenuPrincipal.joueursDedans.get(i).getNumLicenceJ()+ " " +MenuPrincipal.joueursDedans.get(i).getNomJ()+ " " +MenuPrincipal.joueursDedans.get(i).getPrenomJ();
                listM2.addElement(tmpList2);
            }
            
            MenuPrincipal.idJoueurDedans = -1;
            confirmed = false;
        }
    }//GEN-LAST:event_AjouteJoueurTournoiRemovejButtonActionPerformed

    private void ajoutJoueurTournoiConfirmerjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutJoueurTournoiConfirmerjButtonActionPerformed
        xml2.ecrireJoueurDansTournoi(joueursDedans, idTournoiCourant-1);
        ajoutJoueurTournoiMessagejLabel.setText("Enregistrement confirmé");
        confirmed = true;
    }//GEN-LAST:event_ajoutJoueurTournoiConfirmerjButtonActionPerformed

    public void resetInfoModifJoueur(){
        nomTextField2.setText("");
        prenomTextField1.setText("");
        dateTextField1.setText("");
        licenceTextField1.setText("");
        federationTextField1.setText("");
        ligueTextField1.setText("");
        clubTextField1.setText("");
        eloNormalTextField1.setText("");
        eloSemiRapideTextField1.setText("");
        eloRapideTextField1.setText("");
        retourTextArea1.setText("");
        nomLabel1.setForeground(Color.black);
        prenomLabel1.setForeground(Color.black);
        sexeLabel1.setForeground(Color.black);
        dateLabel1.setForeground(Color.black);
    }
    
    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        
        boolean estCree;
        
        String nom = nomTextField2.getText();
        String prenom = prenomTextField1.getText();
        String dateDeNaissance = dateTextField1.getText();
        String sexe = jComboBox2.getSelectedItem().toString();
        String licence = licenceTextField1.getText();
        String eloN = eloNormalTextField1.getText();
        String eloR = eloRapideTextField1.getText();
        String eloSR = eloSemiRapideTextField1.getText();
        String fed = federationTextField1.getText();
        String lig = ligueTextField1.getText();
        String clb = clubTextField1.getText();
        
        //Joueurs j = controllerJoueur.creerJoueur(licence,nom,prenom,eloN,eloSR,eloR,dateDeNaissance,sexe,fed,lig,clb);
        //estCree = controllerJoueur.modifieJoueur(j, IDJ, nomLabel1, prenomLabel1, sexeLabel1, dateLabel1, retourTextArea1);
        //if(estCree){
          //  resetInfoModifJoueur();
            //retourTextArea1.setText("Joueur modifié !");
        //}
        
    }//GEN-LAST:event_saveButton1ActionPerformed

    private void mainMenuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButton1ActionPerformed
        resetInfoModifJoueur();
        
        initPanel(menuPrinc);
    }//GEN-LAST:event_mainMenuButton1ActionPerformed

    private void supprimerTournoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerTournoiActionPerformed
        if(MenuPrincipal.idTournoiCourant == -1){
            selectionTournoiMessagejLabel.setText("Veuillez sélectionner un tournoi");
        }else{
            String s = (String) selectionTournoijList.getSelectedValue();
            if(s != null && !s.isEmpty()){
                int intTmp = Integer.valueOf(s.split(" ")[0]);
                try { 
                    xml2.supprimerTournoi(intTmp);
                } catch (TransformerException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<Tournoi> listT = xml2.ReadXML();
                DefaultListModel listM = new DefaultListModel();
                selectionTournoijList.setModel(listM);
                String tmp="";
                String tmpList = "";
                for (int i=0;i<listT.size();i++){
                    tmp=tmp+" Tournoi n°"+(i+1)+System.getProperty("line.separator");
                    tmpList =(i+1)+" Tournoi n°"+(i+1)+" "+listT.get(i).getNomTournoi();
                    listM.addElement(tmpList);
                }
                affichageTournois.setText("");
            }
        }
    }//GEN-LAST:event_supprimerTournoiActionPerformed

    private void modifierTournoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierTournoiActionPerformed
        if(MenuPrincipal.idTournoiCourant == -1){
            selectionTournoiMessagejLabel.setText("Veuillez sélectionner un tournoi");
        }else{
            ArrayList<Tournoi> listT = xml2.ReadXML();
            String s = (String) selectionTournoijList.getSelectedValue();
            int intTmp = -1;
            if(s != null && !s.isEmpty()){
                intTmp = Integer.valueOf(s.split(" ")[0]);

            }
            if(intTmp != -1){
                //Faut pas faire comme ça faut créer un nouveau pannel
                xml2.modifierTournoi(intTmp, listT.get(intTmp-1));
                accesModifTournoi(intTmp, listT.get(intTmp-1));
            }
        }
    }//GEN-LAST:event_modifierTournoiActionPerformed

    private void SauvModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SauvModifActionPerformed
        String nomTournoi=nomTextField3.getText();
        String dateDebut= datedTextField3.getText();
        String dateFin=dateFTextField4.getText();
        String nbRondes=nbRTextField5.getText();
        String lieu=lieuTextField6.getText();
        nom.setForeground(Color.black);
        dated.setForeground(Color.black);
        datef.setForeground(Color.black);
        nbr.setForeground(Color.black);
        
        Tournoi t = new Tournoi(nomTournoi,dateDebut,dateFin,nbRondes,lieu);
        String stmp="Données incorrectes: ";
        boolean test = true;
        if(!t.verifDonneesSensiblesCompletes())
        {
            test= false;
            if(t.nomTournoiEstVide()){
                nom.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Nom Tournoi manquant";
            }
            if(t.dateDebutEstVide()){
                dated.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Date de début manquante";
            }
            if(t.dateFinEstVide()){
                datef.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Date de fin manquante";
            }
            if(t.nbRondesEstVide()){
                nbr.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Nombre de rondes manquant";
            }
        }
        if(!t.verifTailleNomTournoi()){
            nom.setForeground(Color.red);
            stmp += System.getProperty("line.separator")+"Nom de tournoi limité à 50 caractères.";
        }
        if(!t.verifFormatDateValide(dateDebut))
        {
            test= false;
            if(!t.verifMatchDate(dateDebut)){
                dated.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!t.verifDateValide(dateDebut)){
                    dated.setForeground(Color.red);
                    stmp += System.getProperty("line.separator")+"Erreur, date incorrecte";
                }
            }
        } 
        if(!t.verifFormatDateValide(dateFin))
        {
            test= false;
            if(!t.verifMatchDate(dateFin)){
                dated.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Erreur, date invalide format attendu : JJ/MM/AAAA";
            }else{
                if(!t.verifDateValide(dateFin)){
                    dated.setForeground(Color.red);
                    stmp += System.getProperty("line.separator")+"Erreur, date incorrecte";
                }
            }
        }
        if(t.verifFormatDateValide(dateDebut) && t.verifFormatDateValide(dateFin)){
            if(!t.verifDateDebut(dateDebut)){
                test= false;
                dated.setForeground(Color.red);
                stmp += System.getProperty("line.separator")+"Erreur, date de é©but inférieure à la date actuelle.";
            }
            if(!t.verifDateDebutAvantDateFin(dateDebut, dateFin)){
                test= false;
                stmp += System.getProperty("line.separator")+"Erreur, date de début plus récente que date de fin.";
            }
        }
        if(!t.verifNbRondes()){
            test = false;
            stmp += System.getProperty("line.separator")+"Erreur, le nombre de rondes doit être positif.";
        }
        msgErreurT1.setText(stmp);
        if(test){
            msgErreurT1.setText("Tournoi modifié!");
            xml2.modifierTournoi(IDT,t);
        }
    }//GEN-LAST:event_SauvModifActionPerformed

    private void menuprincT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuprincT1ActionPerformed

        msgErreurT1.setText("");
        nom.setForeground(Color.black);
        dated.setForeground(Color.black);
        datef.setForeground(Color.black);
        nbr.setForeground(Color.black);
        
        initPanel(menuPrinc);
    }//GEN-LAST:event_menuprincT1ActionPerformed
    private void accesModifTournoi(int idT, Tournoi T){
        

        nomTextField3.setText(T.getNomTournoi());
        datedTextField3.setText(T.getDateDebut());
        dateFTextField4.setText(T.getDateFin());
        nbRTextField5.setText(""+T.getNbRondes());
        lieuTextField6.setText(T.getLieu());
        retourTextArea1.setText("");
        IDT = idT;
        Tmodif = T;
        
        initPanel(modifierTournoiJPanel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AffJTextArea1;
    private javax.swing.JButton AjoutJoueurTournoiRetourjButton;
    private javax.swing.JButton AjouteJoueurTournoiRemovejButton;
    private javax.swing.JLabel ErreurSelectJoueur;
    private javax.swing.JButton SauvModif;
    private javax.swing.JButton SelectionTournoi;
    private javax.swing.JButton SelectionTournoiMenuPrincjButton;
    private javax.swing.JList<String> affichageJoueurList;
    private javax.swing.JTextArea affichageTournois;
    private javax.swing.JLabel afficheTournoiTitre;
    private javax.swing.JPanel afficherJoueur;
    private javax.swing.JList<String> ajoutJoueurTounroiJoueurDedansjList;
    private javax.swing.JList<String> ajoutJoueurTounroiJoueurDehorsjList;
    private javax.swing.JPanel ajoutJoueurTournoi;
    private javax.swing.JButton ajoutJoueurTournoiAjouterjButton;
    private javax.swing.JButton ajoutJoueurTournoiConfirmerjButton;
    private javax.swing.JLabel ajoutJoueurTournoiMessagejLabel;
    private javax.swing.JButton ajouterJoueurjButton;
    private javax.swing.JButton cleanT;
    private javax.swing.JToggleButton clearButton;
    private javax.swing.JLabel clubLabel;
    private javax.swing.JLabel clubLabel1;
    private javax.swing.JTextField clubTextField;
    private javax.swing.JTextField clubTextField1;
    private javax.swing.JButton createPlayer;
    private javax.swing.JButton createTournament;
    private javax.swing.JPanel creationJoueur;
    private javax.swing.JPanel creationTournoi;
    private javax.swing.JTextField dateFTextField3;
    private javax.swing.JTextField dateFTextField4;
    private javax.swing.JLabel dateFormatLabel;
    private javax.swing.JLabel dateFormatLabel1;
    private javax.swing.JLabel dateFormatLabel2;
    private javax.swing.JLabel dateFormatLabel3;
    private javax.swing.JLabel dateFormatLabel4;
    private javax.swing.JLabel dateFormatLabel5;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabel1;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JTextField dateTextField1;
    private javax.swing.JLabel dated;
    private javax.swing.JLabel dated1;
    private javax.swing.JTextField datedTextField2;
    private javax.swing.JTextField datedTextField3;
    private javax.swing.JLabel datef;
    private javax.swing.JLabel datef1;
    private javax.swing.JPanel ecranTournoi;
    private javax.swing.JButton ecranTournoiMenuPrincjButton;
    private javax.swing.JLabel eloNormalLabel;
    private javax.swing.JLabel eloNormalLabel1;
    private javax.swing.JTextField eloNormalTextField;
    private javax.swing.JTextField eloNormalTextField1;
    private javax.swing.JLabel eloRapideLabel;
    private javax.swing.JLabel eloRapideLabel1;
    private javax.swing.JTextField eloRapideTextField;
    private javax.swing.JTextField eloRapideTextField1;
    private javax.swing.JLabel eloSemiRapideLabel;
    private javax.swing.JLabel eloSemiRapideLabel1;
    private javax.swing.JTextField eloSemiRapideTextField;
    private javax.swing.JTextField eloSemiRapideTextField1;
    private javax.swing.JButton enregistreT;
    private javax.swing.JLabel federationLabel;
    private javax.swing.JLabel federationLabel1;
    private javax.swing.JTextField federationTextField;
    private javax.swing.JTextField federationTextField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel licenceLabel;
    private javax.swing.JLabel licenceLabel1;
    private javax.swing.JTextField licenceTextField;
    private javax.swing.JTextField licenceTextField1;
    private javax.swing.JLabel lieu;
    private javax.swing.JLabel lieu1;
    private javax.swing.JTextField lieuTextField5;
    private javax.swing.JTextField lieuTextField6;
    private javax.swing.JLabel ligueLabel;
    private javax.swing.JLabel ligueLabel1;
    private javax.swing.JTextField ligueTextField;
    private javax.swing.JTextField ligueTextField1;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JButton mainMenuButton1;
    private javax.swing.JPanel menuPrinc;
    private javax.swing.JButton menuprincT;
    private javax.swing.JButton menuprincT1;
    private javax.swing.JPanel modifierJoueur;
    private javax.swing.JButton modifierJoueurButton;
    private javax.swing.JButton modifierTournoi;
    private javax.swing.JPanel modifierTournoiJPanel;
    private javax.swing.JTextArea msgErreurT;
    private javax.swing.JTextArea msgErreurT1;
    private javax.swing.JTextField nbRTextField4;
    private javax.swing.JTextField nbRTextField5;
    private javax.swing.JLabel nbr;
    private javax.swing.JLabel nbr1;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel nom1;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel nomLabel1;
    private javax.swing.JTextField nomTextField;
    private javax.swing.JTextField nomTextField1;
    private javax.swing.JTextField nomTextField2;
    private javax.swing.JTextField nomTextField3;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JLabel noteLabel1;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JLabel prenomLabel1;
    private javax.swing.JTextField prenomTextField;
    private javax.swing.JTextField prenomTextField1;
    private javax.swing.JButton retourMenuAff;
    private javax.swing.JTextArea retourTextArea;
    private javax.swing.JTextArea retourTextArea1;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveButton1;
    private javax.swing.JPanel selectionTournoi;
    private javax.swing.JLabel selectionTournoiMessagejLabel;
    private javax.swing.JButton selectionTournoiSelectionnerjButton;
    private javax.swing.JList<String> selectionTournoijList;
    private javax.swing.JLabel sexeLabel;
    private javax.swing.JLabel sexeLabel1;
    private javax.swing.JButton supprimerJoueurButton;
    private javax.swing.JButton supprimerTournoi;
    private javax.swing.JLabel titleMenuLabel;
    private javax.swing.JLabel titleMenuLabel1;
    // End of variables declaration//GEN-END:variables
}
