package commons;


import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CsvReaderWriter {
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final int NUM_OF_LINE_SKIP = 1;
    private static final String PATH_FILE_EMPLOYEE = "src/data/Employee.csv";
    private static final String[] FILE_HEADER_OF_EMPLOYEE ={"idEmployee","nameEmployee","age","address"};
    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/data/Room.csv";
    private static final String PATH_FILE_BOOKING = "src/data/Booking.csv";
    private static final String PATH_FILE_CUSTOMER = "src/data/Customer.csv";
    private static final String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "area", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};
    private static final String[] FILE_HEADER_OF_HOUSE = {" id", " nameService", "area", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "numberOfFloors"};
    private static final String[] FILE_HEADER_OF_ROOM = {" id", " nameService", "area", "rentalCosts", "maxNumberOfPeople", "typeRent", "freeService"};
    private static final String[] FILE_HEADER_OF_CUSTOMER = {" id", " nameCustomer", "idCard", " birthday", " gender", " phoneNumber", " email", " typeCustomer", " address"};
    private static final String[] FILE_HEADER_OF_BOOKING = {" id", " nameCustomer", "idCard", " birthday", " gender", " phoneNumber", " email", " typeCustomer", " address", "idService", "nameService", "area", "rentalCosts", "maxNumberOfPeople", "typeRent"};

    public static void writerCsv(List<String[]> fileName, String service) {
        String path = null;
        String[] header=null;
        switch (service){
            case "Villa":
                path = PATH_FILE_VILLA;
                header =FILE_HEADER_OF_VILLA;
                break;
            case "House":
                path =PATH_FILE_HOUSE;
                header =FILE_HEADER_OF_HOUSE;
                break;
            case "Room":
                path =PATH_FILE_ROOM;
                header =FILE_HEADER_OF_ROOM;
                break;
            case "Customer":
                path =PATH_FILE_CUSTOMER;
                header =FILE_HEADER_OF_CUSTOMER;
                break;
            default:
                System.out.println("Error");

        }
        try (
                Writer writer = new FileWriter(path, true);
                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);) {
            if (readHead(path) == null) {
                csvWriter.writeNext(header);
            }
            csvWriter.writeAll(fileName);
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public static String readHead(String path) throws IOException {
        Reader reader = new FileReader(path);
        BufferedReader csvReader = new BufferedReader(reader);
        return csvReader.readLine();
    }

    public static List<Villa> readCsvFileVilla() {
        ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(FILE_HEADER_OF_VILLA);
        CsvToBean<Villa> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(PATH_FILE_VILLA))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return csvToBean.parse();
    }

    public static List<House> readCsvFileHouse() {
        ColumnPositionMappingStrategy<House> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(House.class);
        strategy.setColumnMapping(FILE_HEADER_OF_HOUSE);
        CsvToBean<House> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<House>(new FileReader(PATH_FILE_HOUSE))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return csvToBean.parse();
    }

    public static List<Room> readCsvFileRoom() {
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(FILE_HEADER_OF_ROOM);
        CsvToBean<Room> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(PATH_FILE_ROOM))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return csvToBean.parse();
    }

    public static List<Customer> readCsvFileCustomer() {
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(FILE_HEADER_OF_CUSTOMER);
        CsvToBean<Customer> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(PATH_FILE_CUSTOMER))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return csvToBean.parse();
    }

    public static void WriteCsvFileBooking(List<Customer> listBooking)  {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(PATH_FILE_BOOKING);

            fileWriter.append(Arrays.toString(FILE_HEADER_OF_BOOKING));


            fileWriter.append(DEFAULT_SEPARATOR);

            for (Customer customerCSV : listBooking) {
                fileWriter.append(customerCSV.getId());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getNameCustomer());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getIdCard());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getBirthday());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getGender());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getPhoneNumber());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getEmail());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getTypeCustomer());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getService().getId());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getService().getNameService());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(String.valueOf(customerCSV.getService().getArea()));
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(String.valueOf(customerCSV.getService().getRentalCosts()));
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(String.valueOf(customerCSV.getService().getMaxNumberOfPeople()));
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(customerCSV.getService().getTypeRent());
                fileWriter.append(DEFAULT_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
    public static List<Employee> readCsvFileEmployee() {
        ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Employee.class);
        strategy.setColumnMapping(FILE_HEADER_OF_EMPLOYEE);
        CsvToBean<Employee> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Employee>(new FileReader(PATH_FILE_EMPLOYEE))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return csvToBean.parse();
    }
}




