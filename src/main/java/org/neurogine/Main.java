package org.neurogine;

import org.neurogine.services.FileService;
import org.neurogine.services.FlatFileServiceImplementation;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {

        FileService fileService= new FlatFileServiceImplementation();

        try {
            fileService.writeFile();
            fileService.generateReport();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}