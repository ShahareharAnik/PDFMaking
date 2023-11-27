//import org.apache.pdfbox.pdmodel.PDDocument;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ManyPageDelete {
//    public static void main(String[] args) throws IOException {
//        File oldefile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\file.pdf");
//        PDDocument doc = PDDocument.load(oldefile);
//        int pageRangeStart = 1;
//        int pageRangeEnd  = 4;
//        for(int i = pageRangeEnd; i>=pageRangeStart; i--)
//        {
//            doc.removePage(i-1);
//        }
//      //  doc.removePage(2);
//        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\DeletePage\\4pageDelete.pdf");
//        System.out.println("4 Page deleted");
//    }
//}
//
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class ManyPageDelete {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\file.pdf");
        PDDocument doc = PDDocument.load(oldFile);

        int pageRangeStart = 0;  // Start page index (zero-based)
        int pageRangeEnd = 3;    // End page index (zero-based)

        for (int i = pageRangeStart; i <= pageRangeEnd; i++) {
            doc.removePage(pageRangeStart);
        }

        doc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\DeletePage\\4_pageDelete.pdf");
        doc.close();

        System.out.println("4 Pages deleted");
    }
}
