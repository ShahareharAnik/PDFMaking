import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class Delete1Page {
    public static void main(String[] args) throws IOException {
        File oldefile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\file.pdf");
        PDDocument doc = PDDocument.load(oldefile);

        doc.removePage(2);
        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\DeletePage\\1pageDelete.pdf");
        System.out.println("1 Page deleted");
    }
}
