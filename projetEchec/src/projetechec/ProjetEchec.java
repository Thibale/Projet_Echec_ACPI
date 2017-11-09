package projetechec;

public class ProjetEchec {
    public static void main(String[] args) {
       Joueurs j = new Joueurs(1,"294J","Falcone","Tibo",1234,5678,9101,"junM","01-01-1997","H","Fr","ligue","nimes");
       Joueurs j2 = new Joueurs(2,"293J","Bert","Flo",1264,5698,3101,"junF","01-01-1997","F","Fr","ligue","nimes");
       XML xml1 = new XML();
       xml1.WriteXML(j);
       xml1.WriteXML(j2);
    }
    
}
