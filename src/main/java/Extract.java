import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Extract {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\file.pdf");
        PDDocument doc = PDDocument.load(oldFile);

        // Put destination
        File newFile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\Explit");
        newFile.mkdir();  // If the path doesn't exist, create a new directory

        Splitter splitter = new Splitter();
        splitter.setStartPage(3);
        splitter.setEndPage(9);

        List<PDDocument> splitPages = splitter.split(doc);

        PDDocument newDoc = new PDDocument();
        for (PDDocument myDoc : splitPages) {
            newDoc.addPage(myDoc.getPage(0));
        }

        newDoc.save(newFile + "\\split3to9.pdf");
        newDoc.close();
        doc.close();

        System.out.println("Pdf Created with Extracted");
    }
}
