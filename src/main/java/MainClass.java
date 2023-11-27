import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument(); // object create
        PDPage FirstPage = new PDPage(); //firstpage create
        doc.addPage(FirstPage);
        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\pdf2.pdf"); //path for saving.
        System.out.println("Pdf created"); //checking massage
        doc.close(); //pdf close
    }
}
