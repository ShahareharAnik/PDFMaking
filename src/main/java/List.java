import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class List {
    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage FirstPage = new PDPage();
        doc.addPage(FirstPage);


        PDPageContentStream contentStream = new PDPageContentStream(doc, FirstPage);
        contentStream.beginText();

        // contentStream.setFont(PDType1Font.TIMES_ROMAN, 40);
        contentStream.setLeading(50.0f); // line space between two line.
        contentStream.newLineAtOffset(25, FirstPage.getTrimBox().getHeight() - 40); //the exact point where the lone begin.

//        String text1 = "This is Asus Rog font";
//        String text2 = "This is Credit Font";
//        String text3 = "This is the Autumn font";
//        String text4 = "This is the Time Roman font";

        String[] listItem = new String[]{
                "This is the first line",
                "This is the second line",
                "This is the third line",
                "This is the forth line",
                "This is the fifth line",
                "This is the sixth line",
                "This is the seventh line"

        };

      //  int startListNumber = 1;
         char listAlpha = 'p';

        for(String list : listItem){
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
         //   contentStream.showText(String.valueOf(startListNumber)+". ");
            contentStream.showText(listAlpha +". ");

            contentStream.showText(list);
            contentStream.newLine();

           // startListNumber++;
            listAlpha++;

        }

        contentStream.endText();
        contentStream.close();

        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\myPdf3.pdf");
        //doc.close();
        System.out.println("PDF Created with added list number");
    }
}
