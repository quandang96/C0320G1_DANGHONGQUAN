package models;



import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import commons.CsvReaderWriter;
import controllers.EmployeeInput;
import sort.SortNameCustomer;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Test {
    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final char DEFAULT_SEPARATOR = ',';

    // the character to use for quoted elements
    private static final char DEFAULT_QUOTE = '"';

    // the line number to skip for start reading
    private static final int NUM_OF_LINE_SKIP = 1;
    private static final char NEW_LINE_SEPARATOR = ',';

    public Test() throws FileNotFoundException {
    }

    public static String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "area", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};


    public static void main(String[] args) throws IOException {
//        MainController mainController = new MainController();
//        mainController.displayMainMenu();
        String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "area", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};


//
//    } ColumnPositionMappingStrategy<Objects> strategy = new ColumnPositionMappingStrategy<>();
//        strategy.setType(Objects.class);
//        strategy.setColumnMapping(FILE_HEADER_OF_VILLA);
//
//        CsvToBean<Objects> csvToBean = null;
//        try {
//            csvToBean = new CsvToBeanBuilder<Objects>(new FileReader(PATH_FILE_VILLA))
//                    .withMappingStrategy(strategy)
//                    .withSeparator(DEFAULT_SEPARATOR)
//                    .withQuoteChar(DEFAULT_QUOTE)
//                    .withSkipLines(NUM_OF_LINE_SKIP)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        List<Objects> countries = csvToBean.parse();
//        for (Object country : countries) {
//            System.out.println(country);
////            System.out.println(((Villa)country).showInfo());
//        }
        EmployeeInput input = new EmployeeInput();
        input.employee();

    }
    }










