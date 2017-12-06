package projetechec;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLTournoi {
    protected DocumentBuilderFactory factory;
    protected DocumentBuilder builder;
    protected Document document;
    protected Element racine;
    
    private boolean isInit = false;
    private static int id;
    
    protected NodeList racineNoeuds;
    
    public void InitXMLFile(){
        factory = DocumentBuilderFactory.newInstance();
        
        try {
            //Création ou lecture du fichier XML
	    builder = factory.newDocumentBuilder();
	    File fileXML = new File(System.getProperty("user.dir")+"\\Tournois.xml");
            
            if(!fileXML.exists()){
                
                document = builder.newDocument();
                racine = document.createElement("tournois");
                racine.setAttribute("id", "0");
                id = 0;
                document.appendChild(racine);
                
            }else{
                
                document = builder.parse(fileXML);
                racine = document.getDocumentElement();
                id = Integer.valueOf(racine.getAttribute("id"));
                
            }
            
	} catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        isInit = true;
    }
    
    public void WriteXML(Tournoi t){
        if(!isInit){
            this.InitXMLFile();
        }
        
	try {	
            
            id = id + 1;
            racine.setAttribute("id", String.valueOf(id));
			
	    Element personne = document.createElement("tournoi");
	    racine.appendChild(personne);
				
	    Element nomTournoi = document.createElement("nomTournoi");
	    nomTournoi.setAttribute("nomTournoi", t.getNomTournoi());
            
            Element dateDebut = document.createElement("dateDebut");
            dateDebut.setAttribute("dateDebut", t.getDateDebut());
			
	    Element dateFin = document.createElement("dateFin");
	    dateFin.setAttribute("dateFin", t.getDateFin());
            
            Element nbRondes = document.createElement("nbRondes");
            nbRondes.setAttribute("nbRondes", String.valueOf(t.getNbRondes()));
			
            Element lieu = document.createElement("lieu");
	    lieu.setAttribute("lieu", t.getLieu());
            
            Element joueurs = document.createElement("joueurs");
			
	    personne.appendChild(nomTournoi);
	    personne.appendChild(dateDebut);
            personne.appendChild(dateFin);
	    personne.appendChild(nbRondes);
            personne.appendChild(lieu);
            personne.appendChild(joueurs);
	    
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);
	    StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Tournois.xml"));
	   
            //Propriétés du fichier
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
	    transformer.transform(source, sortie);	
	} catch (TransformerException | NullPointerException e) {
	}
    }
    
    public ArrayList<Tournoi> ReadXML(){
        this.InitXMLFile();
        
        String nomTournoi;
        String dateDebut;
        String dateFin;
        int nbRondes;
        String lieu;
        
        ArrayList<Tournoi> listTournoi=new ArrayList<>();
        
        racineNoeuds = racine.getChildNodes();
        for (int i = 0; i<racineNoeuds.getLength(); i++) {
            if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element tournoi = (Element) racineNoeuds.item(i);
                
                Element nomtmp = (Element) tournoi.getElementsByTagName("nomTournoi").item(0);
                nomTournoi = nomtmp.getAttribute("nomTournoi");
                
                Element dateDebuttmp = (Element) tournoi.getElementsByTagName("dateDebut").item(0);
                dateDebut = dateDebuttmp.getAttribute("dateDebut");
                
                Element dateFintmp = (Element) tournoi.getElementsByTagName("dateFin").item(0);
                dateFin = dateFintmp.getAttribute("dateFin");
                
                Element nbRondestmp = (Element) tournoi.getElementsByTagName("nbRondes").item(0);
                nbRondes = Integer.valueOf(nbRondestmp.getAttribute("nbRondes"));
                
                Element lieutmp = (Element) tournoi.getElementsByTagName("lieu").item(0);
                lieu = lieutmp.getAttribute("lieu");
                
                Tournoi ttmp= new Tournoi(nomTournoi,dateDebut,dateFin,nbRondes,lieu);
                
                listTournoi.add(ttmp);
            }	
        }
       return listTournoi; 
    }
    
    public void ecrireJoueurDansTournoi(ArrayList<Joueurs> jList, int index){
        try {
            this.InitXMLFile();
            
            Element tournoi = (Element) document.getElementsByTagName("tournoi").item(index);
            Element joueursOld = (Element) tournoi.getElementsByTagName("joueurs").item(0);
            tournoi.removeChild(joueursOld);
            Element joueurs = document.createElement("joueurs");
            tournoi.appendChild(joueurs);
            
            for (Joueurs joueurNouveau : jList) {
                Element joueur = document.createElement("joueur");
                joueurs.appendChild(joueur);
                
                Element idJoueur = document.createElement("idJoueur");
                idJoueur.setAttribute("idJ", String.valueOf(id));
                
                Element numLic = document.createElement("numLicence");
                numLic.setAttribute("numLicence", joueurNouveau.getNumLicenceJ());
                
                Element nomJoueur = document.createElement("nomJoueur");
                nomJoueur.setAttribute("nomJoueur", joueurNouveau.getNomJ());
                
                Element prenomJoueur = document.createElement("prenomJoueur");
                prenomJoueur.setAttribute("prenomJoueur", joueurNouveau.getPrenomJ());
                
                Element numEloNorm = document.createElement("numEloNormal");
                numEloNorm.setAttribute("numEloNormal", String.valueOf(joueurNouveau.getNumEloNormalJ()));
                
                Element numEloSemiRap = document.createElement("numEloSemiRapide");
                numEloSemiRap.setAttribute("numEloSemiRapide", String.valueOf(joueurNouveau.getNumEloSemiRapideJ()));
                
                Element numEloRap = document.createElement("numEloRapide");
                numEloRap.setAttribute("numEloRapide", String.valueOf(joueurNouveau.getNumEloRapideJ()));
                
                Element catJ = document.createElement("categorie");
                catJ.setAttribute("categorie", joueurNouveau.getCategorieJ());
                
                Element dateNaissance = document.createElement("dateNais");
                dateNaissance.setAttribute("dateNais", String.valueOf(joueurNouveau.getDateNaisJ()));
                
                Element sex = document.createElement("sexe");
                sex.setAttribute("sexe", joueurNouveau.getSexeJ());
                
                Element fede = document.createElement("federation");
                fede.setAttribute("federation",joueurNouveau.getFederationJ());
                
                Element ligueJoueur = document.createElement("ligue");
                ligueJoueur.setAttribute("ligue", joueurNouveau.getLigueJ());
                
                Element clubJoueur = document.createElement("club");
                clubJoueur.setAttribute("club", joueurNouveau.getClubJ());
                
                joueur.appendChild(idJoueur);
                joueur.appendChild(numLic);
                joueur.appendChild(nomJoueur);
                joueur.appendChild(prenomJoueur);
                joueur.appendChild(numEloNorm);
                joueur.appendChild(numEloSemiRap);
                joueur.appendChild(numEloRap);
                joueur.appendChild(catJ);
                joueur.appendChild(dateNaissance);
                joueur.appendChild(sex);
                joueur.appendChild(fede);
                joueur.appendChild(ligueJoueur);
                joueur.appendChild(clubJoueur);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Tournois.xml"));
            
            //Propriétés du fichier
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            transformer.transform(source, sortie);	
        } catch (TransformerException ex) {
            Logger.getLogger(XMLTournoi.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public ArrayList<Joueurs> getJoueursFromTournoi(int index){
        ArrayList<Joueurs> jList = new ArrayList<>();
        
        this.InitXMLFile();
        
        Element tournoi = (Element) document.getElementsByTagName("tournoi").item(index);
        Element joueurs = (Element) tournoi.getElementsByTagName("joueurs").item(0);
        NodeList list = joueurs.getElementsByTagName("joueur");
        for (int i = 0; i < list.getLength(); i++) {
            Element joueur = (Element) joueurs.getElementsByTagName("joueur").item(i);
                
            Element idtmp = (Element) joueur.getElementsByTagName("idJoueur").item(0);
            int idJ = Integer.valueOf(idtmp.getAttribute("idJ"));

            Element numLicencetmp = (Element) joueur.getElementsByTagName("numLicence").item(0);
            String numLicenceJ = numLicencetmp.getAttribute("numLicence");

            Element nomJoueurtmp = (Element) joueur.getElementsByTagName("nomJoueur").item(0);
            String nomJ = nomJoueurtmp.getAttribute("nomJoueur");

            Element prenomJoueurtmp = (Element) joueur.getElementsByTagName("prenomJoueur").item(0);
            String prenomJ = prenomJoueurtmp.getAttribute("prenomJoueur");

            Element numEloNormaltmp = (Element) joueur.getElementsByTagName("numEloNormal").item(0);
            String numEloNormalJ = numEloNormaltmp.getAttribute("numEloNormal");

            Element numEloSemiRapidetmp = (Element) joueur.getElementsByTagName("numEloSemiRapide").item(0);
            String numEloSemiRapideJ = numEloSemiRapidetmp.getAttribute("numEloSemiRapide");

            Element numEloRapidetmp = (Element) joueur.getElementsByTagName("numEloRapide").item(0);
            String numEloRapideJ = numEloRapidetmp.getAttribute("numEloRapide");

            Element categorietmp = (Element) joueur.getElementsByTagName("categorie").item(0);
            String categorieJ = categorietmp.getAttribute("categorie");

            Element dateNaistmp = (Element) joueur.getElementsByTagName("dateNais").item(0);
            String dateNaisJ = dateNaistmp.getAttribute("dateNais");

            Element sexetmp = (Element) joueur.getElementsByTagName("sexe").item(0);
            String sexeJ = sexetmp.getAttribute("sexe");

            Element federationtmp = (Element) joueur.getElementsByTagName("federation").item(0);
            String federationJ = federationtmp.getAttribute("federation");

            Element liguetmp = (Element) joueur.getElementsByTagName("ligue").item(0);
            String ligueJ = liguetmp.getAttribute("ligue");

            Element clubtmp = (Element) joueur.getElementsByTagName("club").item(0);
            String clubJ = clubtmp.getAttribute("club");

            Joueurs jtmp= new Joueurs(idJ,numLicenceJ,nomJ,prenomJ,numEloNormalJ,numEloSemiRapideJ,numEloRapideJ,categorieJ,dateNaisJ,sexeJ,federationJ,ligueJ,clubJ);

            jList.add(jtmp);
        }
        
        return jList;
    }
}
