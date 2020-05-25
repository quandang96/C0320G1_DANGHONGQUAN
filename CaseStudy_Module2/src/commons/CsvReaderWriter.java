package commons;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReaderWriter {
    private static final String PATH_FILE_EMPLOYEE = "src/data/Employee.csv";
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
    private static final String[] FILE_HEADER_OF_EMPLOYEE ={"idEmployee","nameEmployee","age","address"};

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
            case "Employee":
                path =PATH_FILE_EMPLOYEE;
                header =FILE_HEADER_OF_EMPLOYEE;
                break;
            case "Booking":
                path =PATH_FILE_BOOKING;
                header =FILE_HEADER_OF_BOOKING;
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
            System.out.println("CSV file was created successfully !!!");
        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
        }
    }

    public static String readHead(String path) throws IOException {
        Reader reader = new FileReader(path);
        BufferedReader csvReader = new BufferedReader(reader);
        return csvReader.readLine();
    }

    public static List<Villa> readCsvFileVilla() {
        List<Villa> villas = new ArrayList<>();
        try (Reader reader = new FileReader(PATH_FILE_VILLA);
             CSVReader csvReader = new CSVReader(reader);) {
            csvReader.readNext();
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Villa villa = new Villa();
                villa.setId(line[0]);
                villa.setNameService(line[1]);
                villa.setArea(Double.parseDouble(line[2]));
                villa.setRentalCosts(Double.parseDouble(line[3]));
                villa.setMaxNumberOfPeople(Integer.parseInt(line[4]));
                villa.setTypeRent(line[5]);
                villa.setRoomStandard(line[6]);
                villa.setConvenientDescription(line[7]);
                villa.setAreaPool(Double.parseDouble(line[8]));
                villa.setNumberOfFloors(Integer.parseInt(line[9]));
                villas.add(villa);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return villas;
    }

    public static List<House> readCsvFileHouse() {
        List<House> houses = new ArrayList<>();
        try (Reader reader = new FileReader(PATH_FILE_HOUSE);
             CSVReader csvReader = new CSVReader(reader);) {
            csvReader.readNext();
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                House house = new House();
                house.setId(line[0]);
                house.setNameService(line[1]);
                house.setArea(Double.parseDouble(line[2]));
                house.setRentalCosts(Double.parseDouble(line[3]));
                house.setMaxNumberOfPeople(Integer.parseInt(line[4]));
                house.setTypeRent(line[5]);
                house.setRoomStandard(line[6]);
                house.setConvenientDescription(line[7]);
                house.setNumberOfFloors(Integer.parseInt(line[8]));
                houses.add(house);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return houses;
    }

    public static List<Room> readCsvFileRoom() {
            List<Room> rooms = new ArrayList<>();
            try (Reader reader = new FileReader(PATH_FILE_ROOM);
                 CSVReader csvReader = new CSVReader(reader);) {
                csvReader.readNext();
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    Room room = new Room();
                    room.setId(line[0]);
                    room.setNameService(line[1]);
                    room.setArea(Double.parseDouble(line[2]));
                    room.setRentalCosts(Double.parseDouble(line[3]));
                    room.setMaxNumberOfPeople(Integer.parseInt(line[4]));
                    room.setTypeRent(line[5]);
                    room.setFreeService(line[6]);
                    rooms.add(room);
                }
            } catch (IOException e) {
                System.out.println("Error");
            }
            return rooms;
    }

    public static List<Customer> readCsvFileCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Reader reader = new FileReader(PATH_FILE_CUSTOMER);
             CSVReader csvReader = new CSVReader(reader);) {
            csvReader.readNext();
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Customer customer = new Customer();
                customer.setId(line[0]);
                customer.setNameCustomer(line[1]);
                customer.setIdCard(line[2]);
                customer.setBirthday(line[3]);
                customer.setGender(line[4]);
                customer.setPhoneNumber(line[5]);
                customer.setEmail(line[6]);
                customer.setTypeCustomer(line[7]);
                customer.setAddress(line[8]);
                customers.add(customer);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return customers;
    }
    public static List<Employee> readCsvFileEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (Reader reader = new FileReader(PATH_FILE_EMPLOYEE);
             CSVReader csvReader = new CSVReader(reader);) {
            csvReader.readNext();
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Employee employee = new Employee();
                employee.setIdEmployee(line[0]);
                employee.setNameEmployee(line[1]);
                employee.setAge(Integer.parseInt(line[2]));
                employee.setAddress(line[3]);
                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return employees;
    }

}






