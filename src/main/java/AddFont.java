import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class AddFont {


    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage FirstPage = new PDPage();
        doc.addPage(FirstPage);

        File AsusRog = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\7032-fontps.ttf");
        File CreditCardFont = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\6856-fontps.ttf");
        File AutumnFont = new  File("E:\\BackUp\\PDFCODE\\pdfmaking\\Falling For Autumn 400.ttf");

        PDFont RogFont = PDType0Font.load(doc, AsusRog);
        PDFont Cerdit = PDType0Font.load(doc, CreditCardFont);
        PDFont Autumn = PDType0Font.load(doc, AutumnFont);


        PDPageContentStream contentStream = new PDPageContentStream(doc, FirstPage);
        contentStream.beginText();

       // contentStream.setFont(PDType1Font.TIMES_ROMAN, 40);
        contentStream.setLeading(50.0f); // line space between two line.
        contentStream.newLineAtOffset(25, FirstPage.getTrimBox().getHeight() - 40); //the exact point where the lone begin.

        String text1 = "This is Asus Rog font";
        String text2 = "This is Credit Font";
        String text3 = "This is the Autumn font";
        String text4 = "This is the Time Roman font";


        contentStream.setFont(RogFont, 40);
        contentStream.showText(text1);
        contentStream.newLine();

        contentStream.setFont(Cerdit, 40);
        contentStream.showText(text2);
        contentStream.newLine();

        contentStream.setFont(Autumn, 40);
        contentStream.showText(text3);
        contentStream.newLine();

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 40);
        contentStream.showText(text4);


        contentStream.endText();
        contentStream.close();


        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\myPdf2.pdf");
        //doc.close();
        System.out.println("PDF Created with added text");
    }

}
