package projetechec; // t'aura peut être besoin de modifier ça (probablement)

import java.awt.Color;

/**
 *
 * @author boissinj
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        remove(jPanel2);
        add(jPanel1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        boutonMenuPrincipal = new javax.swing.JButton();
        labelNom = new javax.swing.JLabel();
        champNom = new javax.swing.JTextField();
        labelPrenom = new javax.swing.JLabel();
        labelDateDeNaissance = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelSexe = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        champPrenom = new javax.swing.JTextField();
        champDateDeNaissance = new javax.swing.JTextField();
        champNumLicence = new javax.swing.JTextField();
        champFederation = new javax.swing.JTextField();
        champLigue = new javax.swing.JTextField();
        champClub = new javax.swing.JTextField();
        champEloNormal = new javax.swing.JTextField();
        champEloSemiRapide = new javax.swing.JTextField();
        champEloRapide = new javax.swing.JTextField();
        boutonEnregistrer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RetourCreation = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        comboBoxSexe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));

        jButton2.setText("Afficher Les Joueurs");
        jButton2.setMaximumSize(new java.awt.Dimension(200, 29));
        jButton2.setMinimumSize(new java.awt.Dimension(200, 29));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 29));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Créer un joueur");
        jButton3.setMaximumSize(new java.awt.Dimension(200, 29));
        jButton3.setMinimumSize(new java.awt.Dimension(200, 29));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 29));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(300, 300, 300))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 800));

        boutonMenuPrincipal.setText("Menu Principal");
        boutonMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonMenuPrincipalActionPerformed(evt);
            }
        });

        labelNom.setText("Nom *");

        champNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champNomActionPerformed(evt);
            }
        });

        labelPrenom.setText("Prénom *");

        labelDateDeNaissance.setText("Date de naissance * ");

        jLabel4.setText("Elo Normal");

        jLabel5.setText("Elo SemiRapide");

        jLabel6.setText("Elo Rapide");

        labelSexe.setText("Sexe * ");

        jLabel8.setText("Federation");

        jLabel9.setText("Ligue");

        jLabel10.setText("Club");

        jLabel11.setText("Numéro de Licence");

        champPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champPrenomActionPerformed(evt);
            }
        });

        champDateDeNaissance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champDateDeNaissanceActionPerformed(evt);
            }
        });

        champNumLicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champNumLicenceActionPerformed(evt);
            }
        });

        champFederation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champFederationActionPerformed(evt);
            }
        });

        champLigue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champLigueActionPerformed(evt);
            }
        });

        champClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champClubActionPerformed(evt);
            }
        });

        champEloNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champEloNormalActionPerformed(evt);
            }
        });

        champEloSemiRapide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champEloSemiRapideActionPerformed(evt);
            }
        });

        champEloRapide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champEloRapideActionPerformed(evt);
            }
        });

        boutonEnregistrer.setText("Enregistrer");
        boutonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonEnregistrerActionPerformed(evt);
            }
        });

        RetourCreation.setColumns(20);
        RetourCreation.setRows(5);
        jScrollPane1.setViewportView(RetourCreation);

        jLabel12.setFont(new java.awt.Font("Ubuntu", 2, 10)); // NOI18N
        jLabel12.setText("(*) = Champ Obligatoire");

        comboBoxSexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F"}));
        comboBoxSexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSexeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDateDeNaissance)
                                    .addComponent(labelSexe)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel12)
                                    .addComponent(labelPrenom))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(champClub, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champLigue, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champFederation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champNumLicence, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champDateDeNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champNom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champEloNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champEloSemiRapide, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(champEloRapide, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(boutonEnregistrer)
                        .addGap(344, 344, 344))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boutonMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNom)
                    .addComponent(champNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrenom)
                    .addComponent(champPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDateDeNaissance)
                    .addComponent(champDateDeNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSexe)
                    .addComponent(comboBoxSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(champNumLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(champFederation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(champLigue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(champClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(champEloNormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(champEloSemiRapide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(champEloRapide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boutonEnregistrer)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boutonMenuPrincipal)
                    .addGap(771, 771, 771)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jPanel2.setVisible(true);
        jPanel1.setVisible(false);
        remove(jPanel1);
        add(jPanel2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void boutonMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonMenuPrincipalActionPerformed
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        remove(jPanel2);
        add(jPanel1);
    }//GEN-LAST:event_boutonMenuPrincipalActionPerformed

    private void champNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champNomActionPerformed

    private void champPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champPrenomActionPerformed

    private void champDateDeNaissanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champDateDeNaissanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champDateDeNaissanceActionPerformed

    private void champNumLicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champNumLicenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champNumLicenceActionPerformed

    private void champFederationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champFederationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champFederationActionPerformed

    private void champLigueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champLigueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champLigueActionPerformed

    private void champClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champClubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champClubActionPerformed

    private void champEloNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champEloNormalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champEloNormalActionPerformed

    private void champEloSemiRapideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champEloSemiRapideActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champEloSemiRapideActionPerformed

    private void champEloRapideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champEloRapideActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champEloRapideActionPerformed

    private void boutonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonEnregistrerActionPerformed
        String nom = champNom.getText(); //Vérification des champs qui ne peuvent pas être nuls
        String prenom = champPrenom.getText();
        String dateDeNaissance = champDateDeNaissance.getText();
        String sexe = comboBoxSexe.getSelectedItem().toString();
        String licence = champNumLicence.getText();
        labelNom.setForeground(Color.black);
        labelPrenom.setForeground(Color.black);
        labelSexe.setForeground(Color.black);
        labelDateDeNaissance.setForeground(Color.black);
        if(verifDonneeEnregistrementJoueur(nom, prenom, dateDeNaissance, sexe)){
        RetourCreation.setText(nom + '\n' + prenom + '\n' + dateDeNaissance + '\n' + sexe + '\n' + licence);
        }
        else{
        RetourCreation.setText("Erreur de Merde");        
        }
    }//GEN-LAST:event_boutonEnregistrerActionPerformed

    private void comboBoxSexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSexeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSexeActionPerformed
    
    private boolean verifDonneeEnregistrementJoueur(String nom, String prenom, String dateDeNaissance, String sexe){
        boolean res = true;
        if("".equals(nom) || "".equals(prenom) || "".equals(sexe) || "".equals(dateDeNaissance)){ //vérifie si les données sont nulles ou non
            res = false; //false si nulles
            if("".equals(nom)){
                labelNom.setForeground(Color.red);
            }
            if("".equals(prenom)){
                labelPrenom.setForeground(Color.red);
            }
            if("".equals(sexe)){
                labelSexe.setForeground(Color.red);
            }
            if("".equals(dateDeNaissance)){
                labelDateDeNaissance.setForeground(Color.red);
            }
        }
        return res;
    }
    /**t
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea RetourCreation;
    private javax.swing.JButton boutonEnregistrer;
    private javax.swing.JButton boutonMenuPrincipal;
    private javax.swing.JTextField champClub;
    private javax.swing.JTextField champDateDeNaissance;
    private javax.swing.JTextField champEloNormal;
    private javax.swing.JTextField champEloRapide;
    private javax.swing.JTextField champEloSemiRapide;
    private javax.swing.JTextField champFederation;
    private javax.swing.JTextField champLigue;
    private javax.swing.JTextField champNom;
    private javax.swing.JTextField champNumLicence;
    private javax.swing.JTextField champPrenom;
    private javax.swing.JComboBox<String> comboBoxSexe;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDateDeNaissance;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JLabel labelSexe;
    // End of variables declaration//GEN-END:variables
}
