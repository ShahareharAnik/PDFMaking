import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class AddImage {

        public static void main(String[] args) throws IOException {
            PDDocument Doc = new PDDocument();
            PDPage FirstPage = new PDPage();
            Doc.addPage(FirstPage);

            PDImageXObject image1 = PDImageXObject.createFromFile("C:\\Users\\NITEX\\Downloads\\QA2.png",Doc);
            PDPageContentStream contentStream = new PDPageContentStream(Doc, FirstPage);
            contentStream.drawImage(image1, -25, -25, 320, 212 );
            contentStream.close();
            Doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\image.pdf");
            //doc.close();
            System.out.println("PDF Created adding image");
        }
    }
