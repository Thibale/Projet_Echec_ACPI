package projetechec;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EnsembleLigneAppareillement extends JPanel {

    private ArrayList<LigneAppareillement> ligneAppareillements;

    public EnsembleLigneAppareillement(LayoutManager layout) {
        super(layout);
        //this.setMaximumSize(new Dimension(100, 300));
        this.add(ligneTitre());
        ajouterLignesVides();
    }

    public EnsembleLigneAppareillement(ArrayList<LigneAppareillement> lignes) {
        super(new FlowLayout());
        for (LigneAppareillement ligne : lignes) {
            this.add(ligne);
        }
    }

    private JPanel ligneTitre(){
        JPanel panelTitre = new JPanel(new GridLayout(1,7, 1, 5));

        JLabel labelJoueur1 = new JLabel("Joueur 1");
        JLabel labelCouleur1 = new JLabel("Couleur");
        JLabel labelResultat1 = new JLabel("Score");
        JLabel labelSeparateur = new JLabel("  - ");
        JLabel labelResultat2 = new JLabel("Score");
        JLabel labelCouleur2 = new JLabel("Couleur");
        JLabel labelJoueur2 = new JLabel("Joueur 2");

        panelTitre.add(labelJoueur1);
        panelTitre.add(labelCouleur1);
        panelTitre.add(labelResultat1);
        panelTitre.add(labelSeparateur);
        panelTitre.add(labelResultat2);
        panelTitre.add(labelCouleur2);
        panelTitre.add(labelJoueur2);

        return panelTitre;
    }

    public void addLigne(LigneAppareillement ligne){
        this.add(ligne);
    }

    public void addListLigne(ArrayList<LigneAppareillement> lignes){
        for (LigneAppareillement ligne : lignes) {
            this.add(ligne);
        }
    }

    public void ajouterLignesVides(){
        int nbParticipants = ControllerTournoi.getNombreParticipants();
        int nombreLignes;
        if(nbParticipants %2 == 0){
            nombreLignes = nbParticipants/2;
        } else {
            nombreLignes = (nbParticipants/2) + 1;
        }

        for(int i = 0; i < nombreLignes; i++){
            LigneAppareillement ligne = new LigneAppareillement();
            addLigne(ligne);
        }
    }


}
