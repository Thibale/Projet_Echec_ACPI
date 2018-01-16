package projetechec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LigneAppareillement extends JPanel{
    String[] couleurs = {"N", "B"};
    private String[] resultats = {"1", "0", "F"};
    private JComboBox comboBoxJoueur1;
    private JComboBox comboBoxCouleur1;
    private JComboBox comboBoxResultat1;
    private JLabel labelSeparateur;
    private JComboBox comboBoxResultat2;
    private JComboBox comboBoxCouleur2;
    private JComboBox comboBoxJoueur2;

    public LigneAppareillement() {
        super(new FlowLayout());
        //super(new GridLayout(1,7, 5, 5));
        comboBoxJoueur1 = new JComboBox();
        comboBoxJoueur1.setMinimumSize(new Dimension(10, 10));
        comboBoxCouleur1 = new JComboBox(couleurs);
        comboBoxCouleur1.setMaximumSize(new Dimension(5, 10));
        comboBoxResultat1 = new JComboBox(resultats);
        comboBoxResultat1.setMaximumSize(new Dimension(5, 10));
        labelSeparateur = new JLabel("      -     ");
        comboBoxResultat2 = new JComboBox(resultats);
        comboBoxResultat2.setMaximumSize(new Dimension(5, 10));
        comboBoxCouleur2 = new JComboBox(couleurs);
        comboBoxCouleur2.setMaximumSize(new Dimension(5, 10));
        comboBoxJoueur2 = new JComboBox();
        comboBoxJoueur2.setMinimumSize(new Dimension(10, 10));

        comboBoxJoueur1.setModel(new DefaultComboBoxModel(ControllerTournoi.setJoueurFromTournoiInStringList().toArray()));
        comboBoxJoueur1.setSelectedIndex(-1);
        comboBoxJoueur2.setModel(new DefaultComboBoxModel(ControllerTournoi.setJoueurFromTournoiInStringList().toArray()));
        comboBoxJoueur2.setSelectedIndex(-1);

        comboBoxJoueur1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();

                Object item = e.getItem();

            }
        });

        this.add(comboBoxJoueur1);
        this.add(comboBoxCouleur1);
        this.add(comboBoxResultat1);
        this.add(labelSeparateur);
        this.add(comboBoxResultat2);
        this.add(comboBoxCouleur2);
        this.add(comboBoxJoueur2);
    }

    public JComboBox getComboBoxJoueur1() {
        return comboBoxJoueur1;
    }

    public void setComboBoxJoueur1(JComboBox comboBoxJoueur1) {
        this.comboBoxJoueur1 = comboBoxJoueur1;
    }

    public JComboBox getComboBoxCouleur1() {
        return comboBoxCouleur1;
    }

    public void setComboBoxCouleur1(JComboBox comboBoxCouleur1) {
        this.comboBoxCouleur1 = comboBoxCouleur1;
    }

    public JComboBox getComboBoxResultat1() {
        return comboBoxResultat1;
    }

    public void setComboBoxResultat1(JComboBox comboBoxResultat1) {
        this.comboBoxResultat1 = comboBoxResultat1;
    }

    public JComboBox getComboBoxResultat2() {
        return comboBoxResultat2;
    }

    public void setComboBoxResultat2(JComboBox comboBoxResultat2) {
        this.comboBoxResultat2 = comboBoxResultat2;
    }

    public JComboBox getComboBoxCouleur2() {
        return comboBoxCouleur2;
    }

    public void setComboBoxCouleur2(JComboBox comboBoxCouleur2) {
        this.comboBoxCouleur2 = comboBoxCouleur2;
    }

    public JComboBox getComboBoxJoueur2() {
        return comboBoxJoueur2;
    }

    public void setComboBoxJoueur2(JComboBox comboBoxJoueur2) {
        this.comboBoxJoueur2 = comboBoxJoueur2;
    }

}
