import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class margePDF {
    public static void main(String[] args) throws IOException {
        File oldFile1 = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\zolando.pdf");
        File oldFile2 = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\file.pdf");
        File newFile = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\marge");
        newFile.mkdirs();

     //=====================================================

//        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
//        pdfMergerUtility.setDestinationFileName(newFile+"\\newfile.pdf");
//
//        pdfMergerUtility.addSource(oldFile1);
//        pdfMergerUtility.addSource(oldFile2);
//
//        pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        //========================================================

        PDDocument document1 =  PDDocument.load(oldFile1);
        PDDocument document2 = PDDocument.load(oldFile2);

        for(int i=0; i<document2.getNumberOfPages(); i++){
            document1.addPage(document2.getPage(i));
        }

        document1.save(newFile+"\\newFile2.pdf");
        //==================================================================
        System.out.println("PDF Created with marge");
    }
}
