package projetechec;

import java.io.File;
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

public class XML {
    protected DocumentBuilderFactory factory;
    protected DocumentBuilder builder;
    protected Document document;
    protected Element racine;
    boolean isInit = false;
    
    
    public void InitXMLFile(){
        factory = DocumentBuilderFactory.newInstance();
        
        try {
	    //Etape 2 : création d'un parseur
	    builder = factory.newDocumentBuilder();
	    		
	    //Etape 3 : création d'un Document
	    document = builder.newDocument();
            
            //Etape 4 : création de l'Element racine
	    racine = document.createElement("joueurs");
	    document.appendChild(racine);
        }catch (final ParserConfigurationException e) {
	    e.printStackTrace();
	}
        
        isInit = true;
    }
    
    public void WriteXML(Joueurs j){
        if(!isInit){
            this.InitXMLFile();
        }
        
	try {			
			
	    //Etape 5 : création d'une personne
	    final Comment commentaire = document.createComment("personne n°"+j.getIdJ());
	    racine.appendChild(commentaire);
			
	    final Element personne = document.createElement("joueur");
	    racine.appendChild(personne);
			
	    //Etape 6 : création du nom et du prénom
	    final Element idJoueur = document.createElement("idJoueur");
            idJoueur.setAttribute("idJ", String.valueOf(j.getIdJ()));
			
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
            sex.setAttribute("sexe", String.valueOf(j.getSexeJ()));
			
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
    }
}
