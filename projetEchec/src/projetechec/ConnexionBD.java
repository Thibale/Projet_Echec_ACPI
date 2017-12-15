package projetechec;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList;
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
    
    public void insertJoueur(String[] informationsJoueur){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "INSERT INTO Joueurs"
                        + "(numLicence, nom, prenom, dateNaissance, eloClassique, eloRapide, eloSemiRapide, sexe, categorie, federation, ligue, club) VALUES"
                        + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setString(1, informationsJoueur[0]);
            pst.setString(2, informationsJoueur[1]);
            pst.setString(3, informationsJoueur[2]);
            pst.setString(4, informationsJoueur[3]);
            pst.setString(5, informationsJoueur[4]);
            pst.setString(6, informationsJoueur[5]);
            pst.setString(7, informationsJoueur[6]);
            pst.setString(8, informationsJoueur[7]);
            pst.setString(9, informationsJoueur[8]);
            pst.setString(10, informationsJoueur[9]);
            pst.setString(11, informationsJoueur[10]);
            pst.setString(12, informationsJoueur[11]);
            
            pst.executeUpdate();
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String[]> selectAllJoueurs(){
        ArrayList<String[]> list = new ArrayList<>();
        try {         
            initConnexion();
            String sql;
            sql = "SELECT * FROM Joueurs";
            
            st = cn.createStatement();
            
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                String[] infos = new String[12];
                infos[0] = rs.getString(1);
                infos[1] = rs.getString(2);
                infos[2] = rs.getString(3);
                infos[3] = rs.getString(4);
                infos[4] = rs.getString(5);
                infos[5] = rs.getString(6);
                infos[6] = rs.getString(7);
                infos[7] = rs.getString(8);
                infos[8] = rs.getString(9);
                infos[9] = rs.getString(10);
                infos[10] = rs.getString(11);
                infos[11] = rs.getString(12);
                list.add(infos);
            }
            
            deconnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public void updateJoueur(int id, String[] informationsJoueur){
        try {
            initConnexion();
            String sqlPrepared;
            sqlPrepared = "UPDATE Joueurs"
                        + "SET numLicence = ?, nom = ?, prenom = ?, dateNaissance = ?, eloClassique = ?, eloRapide = ?, eloSemiRapide = ?, sexe = ?, categorie = ?, federation = ?, ligue = ?, club = ?"
                        + "WHERE id = ?";
            
            pst = cn.prepareStatement(sqlPrepared);
            
            pst.setString(1, informationsJoueur[0]);
            pst.setString(2, informationsJoueur[1]);
            pst.setString(3, informationsJoueur[2]);
            pst.setString(4, informationsJoueur[3]);
            pst.setString(5, informationsJoueur[4]);
            pst.setString(6, informationsJoueur[5]);
            pst.setString(7, informationsJoueur[6]);
            pst.setString(8, informationsJoueur[7]);
            pst.setString(9, informationsJoueur[8]);
            pst.setString(10, informationsJoueur[9]);
            pst.setString(11, informationsJoueur[10]);
            pst.setString(12, informationsJoueur[11]);
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
            sqlPrepared = "DELETE FROM Joueurs"
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
