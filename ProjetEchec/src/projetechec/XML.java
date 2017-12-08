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
    private static int id;
    
    protected NodeList racineNoeuds;
    
    public void InitXMLFile(){
        factory = DocumentBuilderFactory.newInstance();
        
        try {
            //Création ou lecture du fichier XML
	    builder = factory.newDocumentBuilder();
	    File fileXML = new File(System.getProperty("user.dir")+"\\Joueurs.xml");
            
            if(!fileXML.exists()){
                
                document = builder.newDocument();
                racine = document.createElement("joueurs");
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
    
    public void WriteXML(Joueurs j){
        
        if(!isInit){
            this.InitXMLFile();
        }
        
	try {			
            
            id = id + 1;
            racine.setAttribute("id", String.valueOf(id));
            
	    Element joueur = document.createElement("joueur");
	    racine.appendChild(joueur);

	    Element idJoueur = document.createElement("idJoueur");
            idJoueur.setAttribute("idJ", String.valueOf(id));
			
	    Element numLic = document.createElement("numLicence");
	    numLic.setAttribute("numLicence", j.getNumLicenceJ());
            
            Element nomJoueur = document.createElement("nomJoueur");
            nomJoueur.setAttribute("nomJoueur", j.getNomJ());
			
	    Element prenomJoueur = document.createElement("prenomJoueur");
	    prenomJoueur.setAttribute("prenomJoueur", j.getPrenomJ());
            
            Element numEloNorm = document.createElement("numEloNormal");
            numEloNorm.setAttribute("numEloNormal", String.valueOf(j.getNumEloNormalJ()));
			
	    Element numEloSemiRap = document.createElement("numEloSemiRapide");
	    numEloSemiRap.setAttribute("numEloSemiRapide", String.valueOf(j.getNumEloSemiRapideJ()));
            
            Element numEloRap = document.createElement("numEloRapide");
	    numEloRap.setAttribute("numEloRapide", String.valueOf(j.getNumEloRapideJ()));
            
            Element catJ = document.createElement("categorie");
            catJ.setAttribute("categorie", j.getCategorieJ());
			
	    Element dateNaissance = document.createElement("dateNais");
	    dateNaissance.setAttribute("dateNais", String.valueOf(j.getDateNaisJ()));
            
            Element sex = document.createElement("sexe");
            sex.setAttribute("sexe", j.getSexeJ());
			
	    Element fede = document.createElement("federation");
	    fede.setAttribute("federation",j.getFederationJ());
            
            Element ligueJoueur = document.createElement("ligue");
	    ligueJoueur.setAttribute("ligue", j.getLigueJ());
            
            Element clubJoueur = document.createElement("club");
	    clubJoueur.setAttribute("club", j.getClubJ());
			
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
	    
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);
	    StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Joueurs.xml"));
	
            
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
    
    public ArrayList<Joueurs> ReadXML(){
        this.InitXMLFile();
        
        int idJ;
        String numLicenceJ;
        String nomJ;
        String prenomJ;
        String numEloNormalJ;
        String numEloSemiRapideJ;
        String numEloRapideJ;
        String categorieJ;
        String dateNaisJ;
        String sexeJ;
        String federationJ;
        String ligueJ;
        String clubJ;
        
        ArrayList<Joueurs> listJoueurs=new ArrayList<>();
        
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
                numEloNormalJ = numEloNormaltmp.getAttribute("numEloNormal");
                
                Element numEloSemiRapidetmp = (Element) joueur.getElementsByTagName("numEloSemiRapide").item(0);
                numEloSemiRapideJ = numEloSemiRapidetmp.getAttribute("numEloSemiRapide");
                
                Element numEloRapidetmp = (Element) joueur.getElementsByTagName("numEloRapide").item(0);
                numEloRapideJ = numEloRapidetmp.getAttribute("numEloRapide");
                
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
        
        this.InitXMLFile();
        
        try {
            Element joueur = (Element) document.getElementsByTagName("joueur").item(idJoueur - 1);
            //racine.removeChild(joueur);
            
            
            final Element numLic = (Element) joueur.getElementsByTagName("numLicence").item(0);
            numLic.setAttribute("numLicence", j.getNumLicenceJ());
            //joueur.removeChild(joueur.getElementsByTagName("numLicence").item(0));
            
            
            final Element nomJoueur = (Element) joueur.getElementsByTagName("nomJoueur").item(0);
            nomJoueur.setAttribute("nomJoueur", j.getNomJ());
            //joueur.removeChild(joueur.getElementsByTagName("nomJoueur").item(0));
            
            
            final Element prenomJoueur = (Element) joueur.getElementsByTagName("prenomJoueur").item(0);
            prenomJoueur.setAttribute("prenomJoueur", j.getPrenomJ());
            //joueur.removeChild(joueur.getElementsByTagName("prenomJoueur").item(0));
            
            final Element numEloNorm = (Element) joueur.getElementsByTagName("numEloNormal").item(0);
            numEloNorm.setAttribute("numEloNormal", String.valueOf(j.getNumEloNormalJ()));
            //joueur.removeChild(joueur.getElementsByTagName("numEloNormal").item(0));  
            
            final Element numEloSemiRap = (Element) joueur.getElementsByTagName("numEloSemiRapide").item(0);
            numEloSemiRap.setAttribute("numEloSemiRapide", String.valueOf(j.getNumEloSemiRapideJ()));
            //joueur.removeChild(joueur.getElementsByTagName("numEloSemiRapide").item(0));
            
            final Element numEloRap = (Element) joueur.getElementsByTagName("numEloRapide").item(0);
            numEloRap.setAttribute("numEloRapide", String.valueOf(j.getNumEloRapideJ()));
            //joueur.removeChild(joueur.getElementsByTagName("numEloRapide").item(0));
            
            final Element catJ = (Element) joueur.getElementsByTagName("categorie").item(0);
            catJ.setAttribute("categorie", j.getCategorieJ());
            //joueur.removeChild(joueur.getElementsByTagName("categorie").item(0));
            
            final Element dateNaissance = (Element) joueur.getElementsByTagName("dateNais").item(0);
            dateNaissance.setAttribute("dateNais", String.valueOf(j.getDateNaisJ()));
            //joueur.removeChild(joueur.getElementsByTagName("dateNais").item(0));   
            
            
            final Element sex = (Element) joueur.getElementsByTagName("sexe").item(0);
            sex.setAttribute("sexe", j.getSexeJ());
            //joueur.removeChild(joueur.getElementsByTagName("sexe").item(0));
            
            final Element fede = (Element) joueur.getElementsByTagName("federation").item(0);
            fede.setAttribute("federation",j.getFederationJ());
            //joueur.removeChild(joueur.getElementsByTagName("federation").item(0));
            
            final Element ligueJoueur = (Element) joueur.getElementsByTagName("ligue").item(0);
            ligueJoueur.setAttribute("ligue", j.getLigueJ());
            //joueur.removeChild(joueur.getElementsByTagName("ligue").item(0));
            
            final Element clubJoueur = (Element) joueur.getElementsByTagName("club").item(0);
            clubJoueur.setAttribute("club", j.getClubJ());
            //joueur.removeChild(joueur.getElementsByTagName("dateNais").item(0));
            
            
            /*joueur.appendChild(numLic);
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
            joueur.appendChild(clubJoueur);*/
            
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);
	    StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Joueurs.xml"));
	
            
            //Propriétés du fichier
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            transformer.transform(source, sortie);

        } catch (TransformerException ex) {
        }
    }
    
    public void supprimerJoueur(int idJoueur) throws TransformerConfigurationException, TransformerException{
        this.InitXMLFile();
        System.out.println(idJoueur);
        Node joueur = document.getElementsByTagName("joueur").item(idJoueur - 1);
        racine.removeChild(joueur);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Joueurs.xml"));


        //Propriétés du fichier
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        transformer.transform(source, sortie);	
    }
    
    public Joueurs getJoueur(int idJoueur){
        int idJ;
        String numLicenceJ;
        String nomJ;
        String prenomJ;
        String numEloNormalJ;
        String numEloSemiRapideJ;
        String numEloRapideJ;
        String categorieJ;
        String dateNaisJ;
        String sexeJ;
        String federationJ;
        String ligueJ;
        String clubJ;
        
        this.InitXMLFile();
        
        Element joueur = (Element) document.getElementsByTagName("joueur").item(idJoueur - 1);

        Element idtmp = (Element) joueur.getElementsByTagName("idJoueur").item(0);
        idJ = Integer.valueOf(idtmp.getAttribute("idJ"));

        Element numLicencetmp = (Element) joueur.getElementsByTagName("numLicence").item(0);
        numLicenceJ = numLicencetmp.getAttribute("numLicence");

        Element nomJoueurtmp = (Element) joueur.getElementsByTagName("nomJoueur").item(0);
        nomJ = nomJoueurtmp.getAttribute("nomJoueur");

        Element prenomJoueurtmp = (Element) joueur.getElementsByTagName("prenomJoueur").item(0);
        prenomJ = prenomJoueurtmp.getAttribute("prenomJoueur");

        Element numEloNormaltmp = (Element) joueur.getElementsByTagName("numEloNormal").item(0);
        numEloNormalJ = numEloNormaltmp.getAttribute("numEloNormal");

        Element numEloSemiRapidetmp = (Element) joueur.getElementsByTagName("numEloSemiRapide").item(0);
        numEloSemiRapideJ = numEloSemiRapidetmp.getAttribute("numEloSemiRapide");

        Element numEloRapidetmp = (Element) joueur.getElementsByTagName("numEloRapide").item(0);
        numEloRapideJ = numEloRapidetmp.getAttribute("numEloRapide");

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
