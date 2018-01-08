package projetechec;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnexionBD {
    
    static final String JDBC_DRIVER = "org.h2.Driver"; 
    static final String USER_DIR = System.getProperty("user.dir");
    static final String URL_BD = "jdbc:h2:"+USER_DIR+"\\DATABASE";
    static final String LOGIN = "admin"; 
    static final String MDP = ""; 
    
    private ResultSet rs = null;
    
    private Statement st = null;
    private PreparedStatement pst = null;
    
    private Connection cn = null;
    
    public ConnexionBD(){
     
    }
    
    public void initConnexion(){
        try {
            Class.forName(JDBC_DRIVER);
            cn = DriverManager.getConnection(URL_BD, LOGIN, MDP);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initAllTables(){
        initConnexion();
        try {
            st = cn.createStatement();
            String sql;
            
            sql =  "CREATE TABLE IF NOT EXISTS Joueurs " + 
                    "(id bigint auto_increment not NULL, " + 
                    " numLicence VARCHAR(16), " +  
                    " nom VARCHAR(64), " +  
                    " prenom VARCHAR(64), " +  
                    " dateNaissance VARCHAR(64), " + 
                    " eloClassique VARCHAR(64), " +  
                    " eloRapide VARCHAR(64), " +  
                    " eloSemiRapide VARCHAR(64), " +  
                    " sexe VARCHAR(64), " +  
                    " categorie VARCHAR(64), " +  
                    " federation VARCHAR(64), " +  
                    " ligue VARCHAR(64), " +  
                    " club VARCHAR(64), " +  
                    " PRIMARY KEY ( id )); ";  
            
            st.executeUpdate(sql);
            
            sql =  "CREATE TABLE IF NOT EXISTS Tournois " + 
                    "(id bigint auto_increment not NULL, " + 
                    " nom VARCHAR(64), " + 
                    " dateDebut VARCHAR(16), " +  
                    " dateFin VARCHAR(16), " +  
                    " nbRondes VARCHAR(64), " +  
                    " lieu VARCHAR(64), " +   
                    " PRIMARY KEY ( id )); ";  
            
            st.executeUpdate(sql);
            
            sql =  "CREATE TABLE IF NOT EXISTS Participer " +
                    "(idJoueur bigint, " +
                    " idTournoi bigint , " +
                    " PRIMARY KEY ( idJoueur, idTournoi ), " +
                    " FOREIGN KEY (idJoueur) references Joueurs(id) ON DELETE CASCADE, " +
                    " FOREIGN KEY (idTournoi) references Tournois(id) ON DELETE CASCADE); ";

            st.executeUpdate(sql);

            sql =  "CREATE TABLE IF NOT EXISTS Rondes " +
                    "(idRonde bigint, " +
                    " idTournoi bigint , " +
                    " PRIMARY KEY (idRonde, idTournoi ), " +
                    " FOREIGN KEY (idTournoi) references Tournois(id) ON DELETE CASCADE); ";

            st.executeUpdate(sql);

            sql =  "CREATE TABLE IF NOT EXISTS Rencontres " +
                    "(idRencontre bigint auto_increment, " +
                    "idRonde bigint, " +
                    "idJoueur1 bigint, " +
                    "idJoueur2 bigint, " +
                    "scoreJ1 VARCHAR(16), " +
                    "scoreJ2 VARCHAR(16), " +
                    "idGagnant bigint, " +
                    "PRIMARY KEY (idRencontre), " +
                    "FOREIGN KEY (idRonde) references Rondes(idRonde) ON DELETE CASCADE, " +
                    "FOREIGN KEY (idJoueur1) references Joueurs(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (idJoueur2) references Joueurs(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (idGagnant) references Joueurs(id) ON DELETE CASCADE); ";

            st.executeUpdate(sql);

            this.deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertJoueur(Map<String, String> informationsJoueur){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "INSERT INTO Joueurs "
                        + "(numLicence, nom, prenom, dateNaissance, eloClassique, eloRapide, eloSemiRapide, sexe, categorie, federation, ligue, club) VALUES "
                        + "(?,?,?,?,?,?,?,?,?,?,?,?); ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setString(1, informationsJoueur.get("numLicence"));
            pst.setString(2, informationsJoueur.get("nom"));
            pst.setString(3, informationsJoueur.get("prenom"));
            pst.setString(4, informationsJoueur.get("dateNaissance"));
            pst.setString(5, informationsJoueur.get("eloClassique"));
            pst.setString(6, informationsJoueur.get("eloRapide"));
            pst.setString(7, informationsJoueur.get("eloSemiRapide"));
            pst.setString(8, informationsJoueur.get("sexe"));
            pst.setString(9, informationsJoueur.get("categorie"));
            pst.setString(10, informationsJoueur.get("federation"));
            pst.setString(11, informationsJoueur.get("ligue"));
            pst.setString(12, informationsJoueur.get("club"));
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Map<String, String>> selectAllJoueurs(){
        ArrayList<Map<String, String>> list = new ArrayList<>();
        try {         
            initConnexion();
            String sql;
            sql = "SELECT * FROM Joueurs ORDER BY nom ASC, prenom ASC; ";
            
            st = cn.createStatement();
            
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", Integer.toString(rs.getInt(1)));
                map.put("numLicence", rs.getString(2));
                map.put("nom", rs.getString(3));
                map.put("prenom", rs.getString(4));
                map.put("dateNaissance", rs.getString(5));
                map.put("eloClassique", rs.getString(6));
                map.put("eloRapide", rs.getString(7));
                map.put("eloSemiRapide", rs.getString(8));
                map.put("sexe", rs.getString(9));
                map.put("categorie", rs.getString(10));
                map.put("federation", rs.getString(11));
                map.put("ligue", rs.getString(12));
                map.put("club", rs.getString(13));
                list.add(map);
            }
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public void updateJoueur(int idJoueur, Map<String, String> informationsJoueur){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "UPDATE Joueurs "
                        + "SET numLicence = ?, nom = ?, prenom = ?, dateNaissance = ?, eloClassique = ?, eloRapide = ?, eloSemiRapide = ?, sexe = ?, categorie = ?, federation = ?, ligue = ?, club = ? "
                        + "WHERE id = ?; ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setString(1, informationsJoueur.get("numLicence"));
            pst.setString(2, informationsJoueur.get("nom"));
            pst.setString(3, informationsJoueur.get("prenom"));
            pst.setString(4, informationsJoueur.get("dateNaissance"));
            pst.setString(5, informationsJoueur.get("eloClassique"));
            pst.setString(6, informationsJoueur.get("eloRapide"));
            pst.setString(7, informationsJoueur.get("eloSemiRapide"));
            pst.setString(8, informationsJoueur.get("sexe"));
            pst.setString(9, informationsJoueur.get("categorie"));
            pst.setString(10, informationsJoueur.get("federation"));
            pst.setString(11, informationsJoueur.get("ligue"));
            pst.setString(12, informationsJoueur.get("club"));
            
            pst.setInt(13, idJoueur);
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteJoueur(int idJoueur){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "DELETE FROM Joueurs "
                        + "WHERE id = ?; ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setInt(1, idJoueur);
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertTournoi(Map<String, String> informationsTournoi){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "INSERT INTO Tournois "
                        + "(nom, dateDebut, dateFin, nbRondes, lieu) VALUES "
                        + "(?,?,?,?,?); ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setString(1, informationsTournoi.get("nom"));
            pst.setString(2, informationsTournoi.get("dateDebut"));
            pst.setString(3, informationsTournoi.get("dateFin"));
            pst.setString(4, informationsTournoi.get("nbRondes"));
            pst.setString(5, informationsTournoi.get("lieu"));

            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Map<String, String>> selectAllTournois(){
        ArrayList<Map<String, String>> list = new ArrayList<>();
        try {         
            initConnexion();
            String sql;
            sql = "SELECT * FROM Tournois ORDER BY nom ASC; ";
            
            st = cn.createStatement();
            
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Map<String, String> map = new HashMap<>();
                
                map.put("id", Integer.toString(rs.getInt(1)));
                map.put("nom", rs.getString(2));
                map.put("dateDebut", rs.getString(3));
                map.put("dateFin", rs.getString(4));
                map.put("nbRondes", rs.getString(5));
                map.put("lieu", rs.getString(6));
                list.add(map);
            }
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public void updateTournoi(int idTournoi, Map<String, String> informationsTournoi){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "UPDATE Tournois "
                        + "SET nom = ?, dateDebut = ?, dateFin = ?, nbRondes = ?, lieu = ? "
                        + "WHERE id = ?; ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setString(1, informationsTournoi.get("nom"));
            pst.setString(2, informationsTournoi.get("dateDebut"));
            pst.setString(3, informationsTournoi.get("dateFin"));
            pst.setString(4, informationsTournoi.get("nbRondes"));
            pst.setString(5, informationsTournoi.get("lieu"));
            
            pst.setInt(6, idTournoi);

            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteTournoi(int idTournoi){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "DELETE FROM Tournois "
                        + "WHERE id = ?; ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setInt(1, idTournoi);
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void deleteAllParticipationTournoi(int idTournoi){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "DELETE FROM Participer "
                        + "WHERE idTournoi = ?; ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setInt(1, idTournoi);
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertParticiper(int idJoueur, int idTournoi){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "INSERT INTO Participer "
                        + "(idJoueur, idTournoi) VALUES "
                        + "(?,?); ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setInt(1, idJoueur);
            pst.setInt(2, idTournoi);

            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteParticiper(int idJoueur, int idTournoi){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "DELETE FROM Participer "
                        + "WHERE idJoueur = ? "
                        + "AND idTournoi = ?; ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setInt(1, idJoueur);
            pst.setInt(2, idTournoi);
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Map<String, String>> selectJoueursFromTournoi(int idTournoi){
        ArrayList<Map<String, String>> list = new ArrayList<>();
        try {         
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "SELECT * FROM Joueurs "
                        + "JOIN Participer ON Joueurs.id = Participer.idJoueur "
                        + "WHERE idTournoi = ?"
                        + "ORDER BY nom ASC, prenom ASC; ";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setInt(1, idTournoi);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                Map<String, String> map = new HashMap<>();
                
                map.put("id", Integer.toString(rs.getInt(1)));
                map.put("numLicence", rs.getString(2));
                map.put("nom", rs.getString(3));
                map.put("prenom", rs.getString(4));
                map.put("dateNaissance", rs.getString(5));
                map.put("eloClassique", rs.getString(6));
                map.put("eloRapide", rs.getString(7));
                map.put("eloSemiRapide", rs.getString(8));
                map.put("sexe", rs.getString(9));
                map.put("categorie", rs.getString(10));
                map.put("federation", rs.getString(11));
                map.put("ligue", rs.getString(12));
                map.put("club", rs.getString(13));
                
                list.add(map);
            }
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    public int getNombreParticipants(int idTournoi){
        int resultat = 0;
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "SELECT COUNT(*) "
                    + "FROM Participer "
                    + "WHERE idTournoi = ?; ";

            pst = cn.prepareStatement(sqlPrepared);

            pst.setInt(1, idTournoi);

            rs = pst.executeQuery();

            rs.next();
            resultat = rs.getInt(1);

            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultat;
    }

    public void insertRonde(int idTournoi, int numeroRonde){

    }

    public void selectAllRondes(int idTournoi){

    }

    public void deleteRonde(int idTournoi, int numeroRonde){

    }

    public void insertRencontre(Map<String, String> informationsRencontre){

    }

    public void deleteRencontre(int idRencontre){

    }

    public void getCouleursJoueesRencontre(int idTournoi, int idJoueurs){

    }

    public void getJoueursRencontres(int idTournoi, int idJoueurs){

    }
    
    public void deconnexion(){
        try{
            if(rs!=null) rs.close();
        } catch(SQLException se2) {}
        try{
            if(pst!=null) pst.close();
        } catch(SQLException se2) {}
        try{
            if(st!=null) st.close();
        } catch(SQLException se2) {}
        try {
            if(cn!=null) cn.close();
        } catch(SQLException se){}
    } 
}
