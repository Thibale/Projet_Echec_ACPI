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
                    " PRIMARY KEY ( id ))";  
            
            st.executeUpdate(sql);
            
            sql =  "CREATE TABLE IF NOT EXISTS Tournois " + 
                    "(id bigint auto_increment not NULL, " + 
                    " nom VARCHAR(64), " + 
                    " dateDebut VARCHAR(16), " +  
                    " dateFin VARCHAR(16), " +  
                    " nbRondes VARCHAR(64), " +  
                    " lieu VARCHAR(64), " +   
                    " PRIMARY KEY ( id ))";  
            
            st.executeUpdate(sql);
            
            sql =  "CREATE TABLE IF NOT EXISTS Participer " + 
                    "(idJoueur bigint, " + 
                    " idTournoi bigint , " +    
                    " PRIMARY KEY ( idJoueur, idTournoi ))";  
            
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
            sqlPrepared = "INSERT INTO Joueurs"
                        + "(numLicence, nom, prenom, dateNaissance, eloClassique, eloRapide, eloSemiRapide, sexe, categorie, federation, ligue, club) VALUES"
                        + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            
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
            sql = "SELECT * FROM Joueurs ORDER BY nom ASC, prenom ASC;";
            
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
    
    public void updateJoueur(int id, Map<String, String> informationsJoueur){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "UPDATE Joueurs"
                        + "SET numLicence = ?, nom = ?, prenom = ?, dateNaissance = ?, eloClassique = ?, eloRapide = ?, eloSemiRapide = ?, sexe = ?, categorie = ?, federation = ?, ligue = ?, club = ?"
                        + "WHERE id = ?";
            
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
            
            pst.setInt(13, id);
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteJoueur(int id){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "DELETE FROM Joueurs "
                        + "WHERE id = ?";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setInt(1, id);
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
