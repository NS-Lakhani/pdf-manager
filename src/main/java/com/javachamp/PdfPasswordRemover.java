package com.javachamp;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class PdfPasswordRemover {

    public boolean remove(File filePath, String password) {
        PDDocument document = null;
        try {
            document = Loader.loadPDF(filePath, password);
            document.setAllSecurityToBeRemoved(true);
            document.save("C:\\Users\\Nishat\\Desktop\\unencrypted.pdf");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
