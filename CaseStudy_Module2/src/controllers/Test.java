package controllers;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "areaUse", "rentalCost", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};
        public static void main(String[] args) throws IOException {
            String[] header = null;
            String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "areaUse", "rentalCost", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};
          header=FILE_HEADER_OF_VILLA;
            for(String element:header){
                System.out.println(element);
            }
        }

        }



