package projetechec;

public class ProjetEchec {

    public static void main(String[] args) {
        ConnexionBD cn = new ConnexionBD();
        cn.initAllTables();
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal());
    }
}