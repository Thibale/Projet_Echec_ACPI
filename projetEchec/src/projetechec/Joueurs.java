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

import java.util.Date;

public class Joueurs {
    private int idJ;
    private String numLicenceJ;
    private String nomJ;
    private String prenomJ;
    private int numEloNormalJ;
    private int numEloSemiRapideJ;
    private int numEloRapideJ;
    private String categorieJ;
    private String dateNaisJ;
    private char sexeJ;
    private String federationJ;
    private String ligueJ;
    private String clubJ;
    
    public Joueurs(int id,String numLicence,String nom,String prenom,int numEloNormal,int numEloSemiRapide,int numEloRapide,String categorie,String dateNais,char sexe,String federation,String ligue,String club){
        idJ=id;
        numLicenceJ=numLicence;
        nomJ=nom;
        prenomJ=prenom;
        numEloNormalJ=numEloNormal;
        numEloSemiRapideJ=numEloSemiRapide;
        numEloRapideJ=numEloRapide;
        categorieJ=categorie;
        dateNaisJ=dateNais;
        sexeJ=sexe;
        federationJ=federation;
        ligueJ=ligue;
        clubJ=club;
    }
    
    public void WriteXML(int id,String numLicence,String nom,String prenom,int numEloNormal,int numEloSemiRapide,int numEloRapide,String categorie,String dateNais,char sexe,String federation,String ligue,String club){
	final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
	try {
	    //Etape 2 : création d'un parseur
	    final DocumentBuilder builder = factory.newDocumentBuilder();
	    		
	    //Etape 3 : création d'un Document
	    final Document document= builder.newDocument();
					
            //Etape 4 : création de l'Element racine
	    final Element racine = document.createElement("joueurs");
	    document.appendChild(racine);			
			
	    //Etape 5 : création d'une personne
	    final Comment commentaire = document.createComment("personne n°"+id);
	    racine.appendChild(commentaire);
			
	    final Element personne = document.createElement("joueur");
	    racine.appendChild(personne);
			
	    //Etape 6 : création du nom et du prénom
	    final Element idJoueur = document.createElement("idJoueur");
            idJoueur.setAttribute("idJ", String.valueOf(id));
			
	    final Element numLic = document.createElement("numLicence");
	    numLic.setAttribute("numLicence", numLicence );
            
            final Element nomJoueur = document.createElement("nomJoueur");
            nomJoueur.setAttribute("nomJoueur", nom);
			
	    final Element prenomJoueur = document.createElement("prenomJoueur");
	    prenomJoueur.setAttribute("prenomJoueur", prenom );
            
            final Element numEloNorm = document.createElement("numEloNormal");
            numEloNorm.setAttribute("numEloNormal", String.valueOf(numEloNormal));
			
	    final Element numEloSemiRap = document.createElement("numEloSemiRapide");
	    numEloSemiRap.setAttribute("numEloSemiRapide", String.valueOf(numEloSemiRapide ));
            
            final Element numEloRap = document.createElement("numEloRapide");
	    numEloRap.setAttribute("numEloRapide", String.valueOf(numEloRapide ));
            
            final Element catJ = document.createElement("categorie");
            catJ.setAttribute("categorie", categorie);
			
	    final Element dateNaissance = document.createElement("dateNais");
	    dateNaissance.setAttribute("dateNais", String.valueOf(dateNais));
            
            final Element sex = document.createElement("sexe");
            sex.setAttribute("sexe", String.valueOf(sexe));
			
	    final Element fede = document.createElement("federation");
	    fede.setAttribute("federation",federation);
            
            final Element ligueJoueur = document.createElement("ligue");
	    ligueJoueur.setAttribute("ligue", ligue);
            
            final Element clubJoueur = document.createElement("club");
	    clubJoueur.setAttribute("club", club);
			
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
	    final StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\file.xml"));
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
	catch (final ParserConfigurationException e) {
	    e.printStackTrace();
	}
	catch (TransformerConfigurationException e) {
	    e.printStackTrace();
	}
	catch (TransformerException e) {
	    e.printStackTrace();
	}			
    }
}

    
