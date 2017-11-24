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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML {
    protected DocumentBuilderFactory factory;
    protected DocumentBuilder builder;
    protected Document document;
    protected Element racine;
    private boolean isInit = false;
    private int id = 0;
    
    protected NodeList racineNoeuds;
    
    public void InitXMLFile(){
        factory = DocumentBuilderFactory.newInstance();
        
        try {
	    //Etape 2 : création d'un parseur
	    builder = factory.newDocumentBuilder();
	    File f=new File(System.getProperty("user.dir")+"\\Joueurs.xml");
            if(!f.exists()){
                //Etape 3 : création d'un Document
                document = builder.newDocument();
                //Etape 4 : création de l'Element racine
                racine = document.createElement("joueurs");
                document.appendChild(racine);
            }else{
                try {
                    document= builder.parse(f);
                    racine = document.getDocumentElement();
                } catch (SAXException | IOException ex) {
                    //Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }catch (final ParserConfigurationException e) {
	}
        
        isInit = true;
    }
    
    public void WriteXML(Joueurs j){
        if(!isInit){
            this.InitXMLFile();
        }
        
	try {			
			
	    //Etape 5 : création d'une personne
            id+=1;
	    final Element personne = document.createElement("joueur");
	    racine.appendChild(personne);
			
	    //Etape 6 : création du nom et du prénom
	    final Element idJoueur = document.createElement("idJoueur");
            idJoueur.setAttribute("idJ", String.valueOf(id));
			
	    final Element numLic = document.createElement("numLicence");
	    numLic.setAttribute("numLicence", j.getNumLicenceJ());
            
            final Element nomJoueur = document.createElement("nomJoueur");
            nomJoueur.setAttribute("nomJoueur", j.getNomJ());
			
	    final Element prenomJoueur = document.createElement("prenomJoueur");
	    prenomJoueur.setAttribute("prenomJoueur", j.getPrenomJ());
            
            final Element numEloNorm = document.createElement("numEloNormal");
            numEloNorm.setAttribute("numEloNormal", String.valueOf(j.getNumEloNormalJ()));
			
	    final Element numEloSemiRap = document.createElement("numEloSemiRapide");
	    numEloSemiRap.setAttribute("numEloSemiRapide", String.valueOf(j.getNumEloSemiRapideJ()));
            
            final Element numEloRap = document.createElement("numEloRapide");
	    numEloRap.setAttribute("numEloRapide", String.valueOf(j.getNumEloRapideJ()));
            
            final Element catJ = document.createElement("categorie");
            catJ.setAttribute("categorie", j.getCategorieJ());
			
	    final Element dateNaissance = document.createElement("dateNais");
	    dateNaissance.setAttribute("dateNais", String.valueOf(j.getDateNaisJ()));
            
            final Element sex = document.createElement("sexe");
            sex.setAttribute("sexe", j.getSexeJ());
			
	    final Element fede = document.createElement("federation");
	    fede.setAttribute("federation",j.getFederationJ());
            
            final Element ligueJoueur = document.createElement("ligue");
	    ligueJoueur.setAttribute("ligue", j.getLigueJ());
            
            final Element clubJoueur = document.createElement("club");
	    clubJoueur.setAttribute("club", j.getClubJ());
			
	    personne.appendChild(idJoueur);
	    personne.appendChild(numLic);
            personne.appendChild(nomJoueur);
	    personne.appendChild(prenomJoueur);
            personne.appendChild(numEloNorm);
	    personne.appendChild(numEloSemiRap);
            personne.appendChild(numEloRap);
	    personne.appendChild(catJ);
            personne.appendChild(dateNaissance);
	    personne.appendChild(sex);
            personne.appendChild(fede);
	    personne.appendChild(ligueJoueur);
            personne.appendChild(clubJoueur);
	    
            //Etape 8 : affichage
	    final TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    final Transformer transformer = transformerFactory.newTransformer();
	    final DOMSource source = new DOMSource(document);
	    final StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Joueurs.xml"));
	    //final StreamResult result = new StreamResult(System.out);
			
	    //prologue
	    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
	    		
	    //formatage
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
	    //sortie
	    transformer.transform(source, sortie);	
	}
	catch (TransformerConfigurationException e) {
	    e.printStackTrace();
	}
	catch (TransformerException e) {
	    e.printStackTrace();
	}
        catch (NullPointerException e){
            
        }
    }
    
    public ArrayList<Joueurs> ReadXML(){
        //if(!isInit){
            this.InitXMLFile();
        //}
        int idJ;
        String numLicenceJ;
        String nomJ;
        String prenomJ;
        int numEloNormalJ;
        int numEloSemiRapideJ;
        int numEloRapideJ;
        String categorieJ;
        String dateNaisJ;
        String sexeJ;
        String federationJ;
        String ligueJ;
        String clubJ;
        
        ArrayList<Joueurs> listJoueurs=new ArrayList<Joueurs>();
        
        racineNoeuds = racine.getChildNodes();
        for (int i = 0; i<racineNoeuds.getLength(); i++) {
            if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element joueur = (Element) racineNoeuds.item(i);
                
                Element idtmp = (Element) joueur.getElementsByTagName("idJoueur").item(0);
                idJ = Integer.valueOf(idtmp.getAttribute("idJ"));
                
                Element numLicencetmp = (Element) joueur.getElementsByTagName("numLicence").item(0);
                numLicenceJ = numLicencetmp.getAttribute("numLicence");
                
                Element nomJoueurtmp = (Element) joueur.getElementsByTagName("nomJoueur").item(0);
                nomJ = nomJoueurtmp.getAttribute("nomJoueur");
                
                Element prenomJoueurtmp = (Element) joueur.getElementsByTagName("prenomJoueur").item(0);
                prenomJ = prenomJoueurtmp.getAttribute("prenomJoueur");
                
                Element numEloNormaltmp = (Element) joueur.getElementsByTagName("numEloNormal").item(0);
                numEloNormalJ = Integer.valueOf(numEloNormaltmp.getAttribute("numEloNormal"));
                
                Element numEloSemiRapidetmp = (Element) joueur.getElementsByTagName("numEloSemiRapide").item(0);
                numEloSemiRapideJ = Integer.valueOf(numEloSemiRapidetmp.getAttribute("numEloSemiRapide"));
                
                Element numEloRapidetmp = (Element) joueur.getElementsByTagName("numEloRapide").item(0);
                numEloRapideJ = Integer.valueOf(numEloRapidetmp.getAttribute("numEloRapide"));
                
                Element categorietmp = (Element) joueur.getElementsByTagName("categorie").item(0);
                categorieJ = categorietmp.getAttribute("categorie");
                
                Element dateNaistmp = (Element) joueur.getElementsByTagName("dateNais").item(0);
                dateNaisJ = dateNaistmp.getAttribute("dateNais");
                
                Element sexetmp = (Element) joueur.getElementsByTagName("sexe").item(0);
                sexeJ = sexetmp.getAttribute("sexe");
                
                Element federationtmp = (Element) joueur.getElementsByTagName("federation").item(0);
                federationJ = federationtmp.getAttribute("federation");
                
                Element liguetmp = (Element) joueur.getElementsByTagName("ligue").item(0);
                ligueJ = liguetmp.getAttribute("ligue");
                
                Element clubtmp = (Element) joueur.getElementsByTagName("club").item(0);
                clubJ = clubtmp.getAttribute("club");
                
                Joueurs jtmp= new Joueurs(idJ,numLicenceJ,nomJ,prenomJ,numEloNormalJ,numEloSemiRapideJ,numEloRapideJ,categorieJ,dateNaisJ,sexeJ,federationJ,ligueJ,clubJ);
                
                listJoueurs.add(jtmp);
            }	
        }
       return listJoueurs; 
    }
    public void modifierJoueur(int idJoueur, Joueurs j){
        try {
            this.InitXMLFile();
            //racineNoeuds = racine.getChildNodes();
            Element joueur = (Element) document.getElementsByTagName("joueur").item(idJoueur - 1);
            racine.removeChild(joueur);
            //node.setAttribute("attrib", "attrib_value");
            
            final Element numLic = (Element) joueur.getElementsByTagName("numLicence").item(0);
            numLic.setAttribute("numLicence", j.getNumLicenceJ());
            
            final Element nomJoueur = (Element) joueur.getElementsByTagName("nomJoueur").item(0);
            nomJoueur.setAttribute("nomJoueur", j.getNomJ());
            
            final Element prenomJoueur = (Element) joueur.getElementsByTagName("prenomJoueur").item(0);
            prenomJoueur.setAttribute("prenomJoueur", j.getPrenomJ());
            
            final Element numEloNorm = (Element) joueur.getElementsByTagName("numEloNormal").item(0);
            numEloNorm.setAttribute("numEloNormal", String.valueOf(j.getNumEloNormalJ()));
            
            final Element numEloSemiRap = (Element) joueur.getElementsByTagName("numEloSemiRapide").item(0);
            numEloSemiRap.setAttribute("numEloSemiRapide", String.valueOf(j.getNumEloSemiRapideJ()));
            
            final Element numEloRap = (Element) joueur.getElementsByTagName("numEloRapide").item(0);
            numEloRap.setAttribute("numEloRapide", String.valueOf(j.getNumEloRapideJ()));
            
            final Element catJ = (Element) joueur.getElementsByTagName("categorie").item(0);
            catJ.setAttribute("categorie", j.getCategorieJ());
            
            final Element dateNaissance = (Element) joueur.getElementsByTagName("dateNais").item(0);
            dateNaissance.setAttribute("dateNais", String.valueOf(j.getDateNaisJ()));
            
            final Element sex = (Element) joueur.getElementsByTagName("sexe").item(0);
            sex.setAttribute("sexe", j.getSexeJ());
            
            final Element fede = (Element) joueur.getElementsByTagName("federation").item(0);
            fede.setAttribute("federation",j.getFederationJ());
            
            final Element ligueJoueur = (Element) joueur.getElementsByTagName("ligue").item(0);
            ligueJoueur.setAttribute("ligue", j.getLigueJ());
            
            final Element clubJoueur = (Element) joueur.getElementsByTagName("club").item(0);
            clubJoueur.setAttribute("club", j.getClubJ());
            
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource source = new DOMSource(document);
            final StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Joueurs.xml"));
            //final StreamResult result = new StreamResult(System.out);
            
            //prologue
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            
            //formatage
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            //sortie
            transformer.transform(source, sortie);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimerJoueur(int idJoueur) throws TransformerConfigurationException, TransformerException{
        this.InitXMLFile();
        //racineNoeuds = racine.getChildNodes();
        Node joueur = document.getElementsByTagName("joueur").item(idJoueur - 1);
        racine.removeChild(joueur);
        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Transformer transformer = transformerFactory.newTransformer();
        final DOMSource source = new DOMSource(document);
        final StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Joueurs.xml"));
        //final StreamResult result = new StreamResult(System.out);

        //prologue
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			

        //formatage
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        //sortie
        transformer.transform(source, sortie);	
    }
    
    public Joueurs getJoueur(int idJoueur){
        int idJ;
        String numLicenceJ;
        String nomJ;
        String prenomJ;
        int numEloNormalJ;
        int numEloSemiRapideJ;
        int numEloRapideJ;
        String categorieJ;
        String dateNaisJ;
        String sexeJ;
        String federationJ;
        String ligueJ;
        String clubJ;
        this.InitXMLFile();
        Element joueur = (Element) document.getElementsByTagName("joueur").item(idJoueur - 1);
            //Element joueur = (Element) racineNoeuds.item(idJoueur);
        
            Element idtmp = (Element) joueur.getElementsByTagName("idJoueur").item(0);
            idJ = Integer.valueOf(idtmp.getAttribute("idJ"));

            Element numLicencetmp = (Element) joueur.getElementsByTagName("numLicence").item(0);
            numLicenceJ = numLicencetmp.getAttribute("numLicence");

            Element nomJoueurtmp = (Element) joueur.getElementsByTagName("nomJoueur").item(0);
            nomJ = nomJoueurtmp.getAttribute("nomJoueur");

            Element prenomJoueurtmp = (Element) joueur.getElementsByTagName("prenomJoueur").item(0);
            prenomJ = prenomJoueurtmp.getAttribute("prenomJoueur");

            Element numEloNormaltmp = (Element) joueur.getElementsByTagName("numEloNormal").item(0);
            numEloNormalJ = Integer.valueOf(numEloNormaltmp.getAttribute("numEloNormal"));

            Element numEloSemiRapidetmp = (Element) joueur.getElementsByTagName("numEloSemiRapide").item(0);
            numEloSemiRapideJ = Integer.valueOf(numEloSemiRapidetmp.getAttribute("numEloSemiRapide"));

            Element numEloRapidetmp = (Element) joueur.getElementsByTagName("numEloRapide").item(0);
            numEloRapideJ = Integer.valueOf(numEloRapidetmp.getAttribute("numEloRapide"));

            Element categorietmp = (Element) joueur.getElementsByTagName("categorie").item(0);
            categorieJ = categorietmp.getAttribute("categorie");

            Element dateNaistmp = (Element) joueur.getElementsByTagName("dateNais").item(0);
            dateNaisJ = dateNaistmp.getAttribute("dateNais");

            Element sexetmp = (Element) joueur.getElementsByTagName("sexe").item(0);
            sexeJ = sexetmp.getAttribute("sexe");

            Element federationtmp = (Element) joueur.getElementsByTagName("federation").item(0);
            federationJ = federationtmp.getAttribute("federation");

            Element liguetmp = (Element) joueur.getElementsByTagName("ligue").item(0);
            ligueJ = liguetmp.getAttribute("ligue");

            Element clubtmp = (Element) joueur.getElementsByTagName("club").item(0);
            clubJ = clubtmp.getAttribute("club");

        Joueurs jtmp= new Joueurs(idJ,numLicenceJ,nomJ,prenomJ,numEloNormalJ,numEloSemiRapideJ,numEloRapideJ,categorieJ,dateNaisJ,sexeJ,federationJ,ligueJ,clubJ);

        return jtmp;
    }
}
