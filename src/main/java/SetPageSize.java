import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;

public class SetPageSize {
    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDRectangle myPageSize = new PDRectangle(1500, 900);
        PDPage myPage = new PDPage(myPageSize);
        doc.addPage(myPage);

        String[] visitorDetails = {"Anik Rahaman", "28", "Agar", "20-02-2022", "9:00 am to 4:00"};
        int pageWidth = (int) myPage.getTrimBox().getWidth();
        int pageHight = (int) myPage.getTrimBox().getHeight();

        PDFont font = PDType1Font.HELVETICA_BOLD;

        PDPageContentStream contentStream = new PDPageContentStream(doc, myPage);

        // for background image.........
        PDImageXObject backfroundImage =  PDImageXObject.createFromFile("C:\\Users\\NITEX\\Downloads\\MIST Logo_0.png",doc);
        contentStream.drawImage(backfroundImage, 650, 400);

        //for  blue rect............
        contentStream.setNonStrokingColor(new Color(0, 170, 243, 255));
        contentStream.addRect(0, pageHight-90, pageWidth, 9000);
        contentStream.fill();

        // for java img..............
        PDImageXObject javaImage = PDImageXObject.createFromFile("C:\\Users\\NITEX\\Downloads\\java_logo_icon_168609.png", doc);
        contentStream.drawImage(javaImage, 600, pageHight-268);


        // for matlab image............
        PDImageXObject matlabImage = PDImageXObject.createFromFile("C:\\Users\\NITEX\\Downloads\\download (1).jpeg", doc);
        contentStream.drawImage(matlabImage, 600, 500);

        //create Text in the pdf...............
        contentStream.beginText();
        contentStream.setFont(font,40);
        contentStream.setNonStrokingColor(Color.black);
        String text1 = "Testing PDF";
        float forwidth1 = font.getStringWidth(text1)/1000*40;
        contentStream.newLineAtOffset((pageWidth-forwidth1)/2,pageHight-55);
        contentStream.showText(text1);
        contentStream.endText();



        contentStream.close();
        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\myPdf4.pdf");
        doc.close();
        System.out.println("PDF CREATED");

    }

}
