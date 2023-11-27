
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class pdfDocInfo {
    public static void main(String[] args) throws IOException {
        File oldFile1 = new File("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\zolando.pdf");
        PDDocument document1 =  PDDocument.load(oldFile1);

        PDDocumentInformation docinfo = document1.getDocumentInformation();

        docinfo.setAuthor("Anik");
        docinfo.setCreator("Zalando");
        docinfo.setTitle("Marging PDF");
        docinfo.setCreationDate(Calendar.getInstance());
        docinfo.setModificationDate(Calendar.getInstance());
        docinfo.setKeywords("Zolando, pdf,  Apache, Java");
        docinfo.setSubject("Checking Marging");
        docinfo.setProducer("anik");
        docinfo.setTrapped("True");

        //password Protections................
            final int keyLength = 128;
        AccessPermission accessPermission = new AccessPermission();

        accessPermission.setCanPrint(false);  // cannot print the doc
        accessPermission.setCanModify(false); //can not change the pdf

        StandardProtectionPolicy sp = new StandardProtectionPolicy("1111","hello", accessPermission);
        sp.setEncryptionKeyLength(keyLength);
        sp.setPermissions(accessPermission);
        document1.protect(sp);


        document1.save("E:\\BackUp\\PDFCODE\\pdfmaking\\newpdfs\\zalando1.pdf");
        System.out.println("PDF Created with gathering info");

    }
}