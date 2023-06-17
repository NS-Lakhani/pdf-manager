package com.javachamp;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PdfMerge {

    public boolean merge(List<File> fileList) {
        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
        pdfMergerUtility.setDestinationFileName("C:\\Users\\Nishat\\Desktop\\merged.pdf");

        for (File f : fileList) {
            try {
                pdfMergerUtility.addSource(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }

        try {
            pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
