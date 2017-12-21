package projetechec;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDF {
    private static final String FILE = System.getProperty("user.dir")+"/ListeDeJoueurs.pdf";
    private static final com.itextpdf.text.Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
   
   
    public static Document creerPDF(){
            Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return document;
    }
     public static void close(Document document) {
            document.close();
    }
    private static void addMetaData(Document document) {
        document.addTitle("Liste des joueurs");
        document.addSubject("Liste des joueurs");
        document.addAuthor("LP ACPI");
        document.addCreator("LP ACPI");
    }

    private static void addTitlePage(Document document)throws DocumentException {
        Paragraph preface = new Paragraph();
        // ajout d'une ligne vide
        addEmptyLine(preface, 1);
        // gros titre
        preface.add(new Paragraph("Liste des joueurs", catFont));

        addEmptyLine(preface, 1);
       document.add(preface);
    }

    public static void addContent(Document document, ArrayList<Joueurs> joueursDuTournoi) throws DocumentException {
        int i;
        for(i=0;i<joueursDuTournoi.size();i++){
            Paragraph infoJoueur = new Paragraph(joueursDuTournoi.get(i).affichageListe());
            document.add(infoJoueur);
        }
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
