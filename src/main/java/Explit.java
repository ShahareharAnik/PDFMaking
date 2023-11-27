//import org.apache.pdfbox.multipdf.Splitter;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//public class Explit {
//    public static void main(String[] args) throws IOException {
//        File oldfile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\file.pdf");
//        PDDocument doc = PDDocument.load(oldfile);
//
//        //put destination
//        File newFile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\Explit");
//        newFile.mkdir();  // the path not exsist then it will create a new file
//
//        Splitter split = new Splitter();
//        split.setSplitAtPage(3);
//        split.setEndPage(9);
//
//        List<PDDocument> Splitpage = split.split(doc);
//        PDDocument newdoc = new PDDocument();
//        for (PDDocument mydoc : Splitpage){
//            newdoc.addPage(mydoc.getPage(11));
//        }
//        newdoc.save(newFile+"//split8.pdf");
//        newdoc.close();
//        System.out.println("Pdf Created");
//    }
//}

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Explit {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\file.pdf");
        PDDocument doc = PDDocument.load(oldFile);

        // Put destination
        File newDir = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\Explit");
        newDir.mkdir();  // if the path does not exist, it will create a new directory

        Splitter splitter = new Splitter();
        splitter.setStartPage(3);  // Start extracting from page 3
        splitter.setEndPage(9);    // End extracting at page 9

        List<PDDocument> splitPages = splitter.split(doc);
        int pageNumber = 1;

        for (PDDocument myDoc : splitPages) {
            File newFile = new File(newDir, "split" + pageNumber + ".pdf");
            myDoc.save(newFile);
            myDoc.close();
            pageNumber++;
        }

        doc.close();
        System.out.println("PDFs Created with Explits");
    }
}
