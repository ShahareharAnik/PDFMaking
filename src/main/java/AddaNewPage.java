import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class AddaNewPage {
    public static void main(String[] args) throws IOException {
        // a file object which will hold the pdf
        File oldfile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\zolando.pdf");
        PDDocument doc = PDDocument.load(oldfile);
        doc.addPage(new PDPage());
        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\zolandoExtraPage.pdf");
        System.out.println("Pdf Created with new page");
        doc.close();

    }
}