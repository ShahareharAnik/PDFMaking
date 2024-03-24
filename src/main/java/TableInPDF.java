import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;

public class TableInPDF {
    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage FirstPage = new PDPage();
        doc.addPage(FirstPage);

        int pageHeight = (int) FirstPage.getTrimBox().getHeight();
        int pageWidth = (int) FirstPage.getTrimBox().getWidth();
        PDPageContentStream contentStream = new PDPageContentStream(doc, FirstPage);

        contentStream.setStrokingColor(Color.DARK_GRAY);
        contentStream.setLineWidth(1);

        int initX = 50;
        int initY = pageHeight-50;
        int cellHeight = 30;
        int cellWidth = 100;


        int colCount = 5;
        int rowCount = 10;


        for(int i = 1; i <=rowCount; i++){
            for(int j=1; j<=colCount; j++)
            {
                contentStream.addRect(initX, initY, cellWidth, -cellHeight);

                contentStream.beginText();
                contentStream.newLineAtOffset(initX+10, initY-cellHeight);
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
                contentStream.showText("Anik");
                contentStream.endText();

                initX+=cellWidth;
            }
            initX = 50;
            initY -= cellHeight;
        }

        contentStream.stroke();
        contentStream.close();

      //  PDPageContentStream contentStream = new PDPageContentStream(doc, FirstPage );


        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\myPdf7.pdf");
        //  doc.close();
        System.out.println("PDF Created with added a table");
    }
}

