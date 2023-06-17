package com.javachamp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PdfManager {

    public static void main(String[] args) {
        int option = 0;

        while (option != 3) {
            System.out.println("*******************");
            System.out.println("Choose option from the menu: ");
            System.out.println("1. Merge PDF");
            System.out.println("2. Remove Password");
            System.out.println("3. Exit");
            System.out.println("*******************");

            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter your choice : ");
            option = sc.nextInt();

            String path = "";

            switch (option) {
                case 1:
                    int noOfFilesToMerge = 0;
                    System.out.print("Please enter number of files you want to merge : ");
                    noOfFilesToMerge = sc.nextInt();

                    List<File> fileList = new ArrayList<>();

                    for (int i=0; i<noOfFilesToMerge; i++) {
                        System.out.print("Please enter file path of " + (i+1) + " (including filename eg. c:\\test\\Test.pdf) : ");
                        path = sc.next();
                        fileList.add(new File(path));
                    }

                    PdfMerge pdfMerge = new PdfMerge();
                    boolean isMerged = pdfMerge.merge(fileList);

                    if (isMerged) {
                        System.out.println("File (merged.pdf) merged successfully and saved at " + "C:\\Users\\Nishat\\Desktop\\");
                    } else {
                        System.out.println("Error occurred while merging pdf file");
                    }
                    break;

                case 2:
                    System.out.print("Please enter file path (including filename eg. c:\\test\\Test.pdf) : ");
                    path = sc.next();
                    System.out.print("Please enter the password of file : ");
                    String password = sc.next();

                    PdfPasswordRemover remover = new PdfPasswordRemover();
                    boolean isPasswordRemoved = remover.remove(new File(path), password);

                    if (isPasswordRemoved) {
                        System.out.println("File password removed successfully and saved at " + "C:\\Users\\Nishat\\Desktop\\");
                    } else {
                        System.out.println("Error occurred while removing password from pdf");
                    }
                    break;

                case 3:
                    System.out.println("You exited the application successfully...!!! Thank you.");
                    System.exit(0);
            }
        }
    }
}
