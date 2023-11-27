import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class addText {


    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage firstpage = new PDPage();
        doc.addPage(firstpage);


        PDPageContentStream contentStream = new PDPageContentStream(doc, firstpage);
        contentStream.beginText();

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 40);
        contentStream.setLeading(30.0f); // line space between two line.
        contentStream.newLineAtOffset(25,firstpage.getTrimBox().getHeight()-40); //the exact point where the lone begin.

        String text1 = "This is the 1st line" ;
        String text2 = "This is the 2nd line" ;
        String text3 = "This is the 3rd line" ;

        contentStream.showText(text1);
        contentStream.newLine();
        contentStream.showText(text2);
        contentStream.newLine();
        contentStream.showText(text3);

        contentStream.endText();
        contentStream.close();


        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\myPdf1.pdf");
        //doc.close();
        System.out.println("PDF Created with added text");
    }
}
