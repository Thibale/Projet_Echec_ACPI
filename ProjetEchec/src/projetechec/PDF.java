/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetechec;


import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

public class PDF {
     private static final String FILE = "N:/Documents/ListeDeJoueurs.pdf";
   private static final com.itextpdf.text.Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
   
    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addContent(document);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
        }
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

    private static void addContent(Document document) throws DocumentException {
        
        Paragraph listeJ = new Paragraph("Mettre la liste des joueurs");
        
        document.add(listeJ);

    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
