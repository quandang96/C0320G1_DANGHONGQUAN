package commons;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import models.*;
import java.io.*;
import java.util.List;

public class CsvReaderWriter {
    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/data/Room.csv";
    private static final String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "areaUse", "rentalCost", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};
    private static final String[] FILE_HEADER_OF_HOUSE = {" id", " nameService", "areaUse", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "numberOfFloors"};
    private static final String[] FILE_HEADER_OF_ROOM = {" id", " nameService", "areaUse", "rentalCosts", "maxNumberOfPeople", "typeRent", "freeService"};
    public static  void writerCsv(List<String[]> fileName,String path, String[] header)  {
        try(
            Writer writer = new FileWriter(path,true);
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);){
            csvWriter.writeNext(header);
            csvWriter.writeAll(fileName);
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    }

