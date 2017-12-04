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

public class XMLTournoi_1 {
    protected DocumentBuilderFactory factory;
    protected DocumentBuilder builder;
    protected Document document;
    protected Element racine;
    private boolean isInit = false;
    //private int id = 0;
    
    protected NodeList racineNoeuds;
    
    public void InitXMLFile(){
        factory = DocumentBuilderFactory.newInstance();
        
        try {
	    //Etape 2 : création d'un parseur
	    builder = factory.newDocumentBuilder();
	    File f=new File(System.getProperty("user.dir")+"\\Tournois.xml");
            if(!f.exists()){
                //Etape 3 : création d'un Document
                document = builder.newDocument();
                //Etape 4 : création de l'Element racine
                racine = document.createElement("tournois");
                document.appendChild(racine);
            }else{
                try {
                    document= builder.parse(f);
                } catch (SAXException ex) {
                    Logger.getLogger(XMLTournoi.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(XMLTournoi.class.getName()).log(Level.SEVERE, null, ex);
                }
                racine = document.getDocumentElement();
            }
            
        }catch (final ParserConfigurationException e) {
	    e.printStackTrace();
	}
        
        isInit = true;
    }
    
    public void WriteXML(Tournoi t){
        if(!isInit){
            this.InitXMLFile();
        }
        
	try {			
			
	    //Etape 5 : création d'une personne	
	    final Element personne = document.createElement("tournoi");
	    racine.appendChild(personne);
			
	    //Etape 6 : création du nom et du prénom	
	    final Element nomTournoi = document.createElement("nomTournoi");
	    nomTournoi.setAttribute("nomTournoi", t.getNomTournoi());
            
            final Element dateDebut = document.createElement("dateDebut");
            dateDebut.setAttribute("dateDebut", t.getDateDebut());
			
	    final Element dateFin = document.createElement("dateFin");
	    dateFin.setAttribute("dateFin", t.getDateFin());
            
            final Element nbRondes = document.createElement("nbRondes");
            nbRondes.setAttribute("nbRondes", String.valueOf(t.getNbRondes()));
			
            final Element lieu = document.createElement("lieu");
	    lieu.setAttribute("lieu", t.getLieu());
			
	    personne.appendChild(nomTournoi);
	    personne.appendChild(dateDebut);
            personne.appendChild(dateFin);
	    personne.appendChild(nbRondes);
            personne.appendChild(lieu);
	    
            //Etape 8 : affichage
	    final TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    final Transformer transformer = transformerFactory.newTransformer();
	    final DOMSource source = new DOMSource(document);
	    final StreamResult sortie = new StreamResult(new File(System.getProperty("user.dir")+"\\Tournois.xml"));
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
    
    public ArrayList<Tournoi> ReadXML(){
        //if(!isInit){
            this.InitXMLFile();
        //}
        String nomTournoi;
        String dateDebut;
        String dateFin;
        int nbRondes;
        String lieu;
        
        ArrayList<Tournoi> listTournoi=new ArrayList<Tournoi>();
        
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
    
    public void addJoueur(Joueurs j){
        
    }
}
