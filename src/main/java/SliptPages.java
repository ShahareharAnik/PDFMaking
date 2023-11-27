import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;



public class SliptPages {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("E://BackUp//PDFCODE//pdfmaking//newpdfs//zolando.pdf");
        PDDocument doc = PDDocument.load(oldFile);
        Splitter Splt = new Splitter();
       List<PDDocument> SpltPg= Splt.split(doc);
       int num=1;
       for(PDDocument mydoc : SpltPg){
           mydoc.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\Split\\Split_0"+num+".pdf");
           num++;
           mydoc.close();
       }
        System.out.println("Split Done");
    }


}
