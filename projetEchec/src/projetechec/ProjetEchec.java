package projetechec;

public class ProjetEchec {
    
    
    public static void main(String[] args) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        })
        ;
       /*
       Joueurs j = new Joueurs(numero+=1,"294J","Falcone","Tibo",1234,5678,9101,"2006-01-01",'H',"Fr","ligue","nimes");
       Joueurs j2 = new Joueurs(numero+=1,"293J","Bert","Flo",1264,5698,3101,"1969-01-01",'F',"Fr","ligue","nimes");

       XML xml1 = new XML();
       xml1.WriteXML(j);
       xml1.WriteXML(j2);
*/
    }
   
}

