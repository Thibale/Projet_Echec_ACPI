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
}
