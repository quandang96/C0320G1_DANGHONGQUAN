package controllers;

import commons.CsvReaderWriter;
import models.*;
import service.*;
import sort.SortNameCustomer;

import java.util.*;

public class MainController {
    public void displayMainMenu() {
        System.out.println(
                "1.\t Add New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7. Add booking cinema 4D\n" +
                "8. Show booking cinema 4D\n" +
                "9. Search Filing Cabinets of Employee\n" +
                "10.\tExit\n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                ShowInformationOfCustomer();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                showInformationOfEmployee();
                break;
            case 7:
                addBookingCinema();
                break;
            case 8:
                showBookingCinema();
                break;
            case 9:
                searchFilingCabinetsOfEmployee();
                break;
            case 10:
                System.exit(0);
                break;
            default: {
                displayMainMenu();
                break;
            }

        }
    }

    public void  showServices() {
        System.out.println(
                        "1.\tShow all Villa\n" +
                        "2.\tShow all House\n" +
                        "3.\tShow all Room\n" +
                        "4.\tShow All Name Villa Not Duplicate\n" +
                        "5.\tShow All Name House Not Duplicate\n" +
                        "6.\tShow All Name Room Not Duplicate\n" +
                        "7.\tBack to menu\n" +
                        "8.\tExit\n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                showAllVilla();
                displayMainMenu();
                break;
            case 2:
                showAllHouse();
                displayMainMenu();
                break;
            case 3:
                showAllRoom();
                displayMainMenu();
                break;
            case 4:
                ShowAllNameVillaNotDuplicate();
                displayMainMenu();
                break;
            case 5:
                ShowAllNameHouseNotDuplicate();
                displayMainMenu();
                break;
            case 6:
                ShowAllNameRoomNotDuplicate();
                displayMainMenu();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
                break;
            default: {
                showServices();

            }
        }
    }

    public void addNewServices() {
        System.out.println(
                "1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
            switch (input) {
                case 1:
                    addNewVilla();
                    displayMainMenu();
                    break;
                case 2:
                    addNewHouse ();
                    displayMainMenu();
                    break;
                case 3:
                    addNewRoom ();
                    displayMainMenu();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.exit(0);
                default: {
                    addNewServices();
                }

            }
        }

    public void addNewCustomer() {
        List <String[]> customers = new ArrayList<>();
        Customer customer =  CustomerInput.inputNewCustomer();
        String[] arr =new String[]{customer.getId(),customer.getNameCustomer(),customer.getIdCard(),customer.getBirthday(),
                customer.getGender(),customer.getPhoneNumber(),customer.getEmail(),customer.getTypeCustomer(),customer.getAddress()};
        customers.add(arr);
        CsvReaderWriter.writerCsv(customers,"Customer");
        displayMainMenu();
    }

    public void ShowInformationOfCustomer(){
        List<Customer> customers;
        customers = CsvReaderWriter.readCsvFileCustomer();
        Collections.sort(customers, new SortNameCustomer());
        for (Customer customer : customers) {
            System.out.println("--------------------------------------------------");
            System.out.println(customer.showInfo());
        }
        displayMainMenu();
    }

    public void showAllVilla()  {
       List<Villa> villas =CsvReaderWriter.readCsvFileVilla();
        for (Villa villa: villas){
            System.out.println("--------------------------------------------------");
            System.out.println(villa.showInfo());
        }

    }

    public void showAllRoom()  {
        List<Room> rooms =CsvReaderWriter.readCsvFileRoom();
        for (Room room: rooms){
            System.out.println("--------------------------------------------------");
            System.out.println(room.showInfo());
        }
    }

    public void showAllHouse()  {
        List<House> houses =CsvReaderWriter.readCsvFileHouse();
        for (House house: houses){
            System.out.println("--------------------------------------------------");
            System.out.println(house.showInfo());
        }
    }

   public void  ShowAllNameVillaNotDuplicate(){
       TreeSet<String> treeSet = new TreeSet<>();
       List<Villa> villas =CsvReaderWriter.readCsvFileVilla();
       for (Villa villa: villas){
          treeSet.add(villa.getNameService());
       }
       System.out.println(treeSet);
   }

    public void  ShowAllNameHouseNotDuplicate(){
        TreeSet<String> treeSet = new TreeSet<>();
        List<House> houses =CsvReaderWriter.readCsvFileHouse();
        for (House house: houses){
            treeSet.add(house.getNameService());
        }
        System.out.println(treeSet);
    }

    public void  ShowAllNameRoomNotDuplicate(){
        TreeSet<String> treeSet = new TreeSet<>();
        List<Room> rooms =CsvReaderWriter.readCsvFileRoom();
        for (Room room: rooms){
            treeSet.add(room.getNameService());
        }
        System.out.println(treeSet);
    }

   public void  showInformationOfEmployee(){
       Map<Integer, Employee> map = new HashMap<Integer, Employee>();
       List <Employee> listEmployee = CsvReaderWriter.readCsvFileEmployee();
       for(int i=0;i<listEmployee.size();i++){
           map.put(i, listEmployee.get(i));
       }
       System.out.println(map);
   }

    public void addNewVilla () {
            List <String[]> villas = new ArrayList<>();
            Villa villa = (Villa) VillaInput.inputNewVilla();
            String[] arr =new String[]{villa.getId(),villa.getNameService(), String.valueOf(villa.getArea()),
                    String.valueOf(villa.getRentalCosts()), String.valueOf(villa.getMaxNumberOfPeople()),villa.getTypeRent(),
                    villa.getRoomStandard(),villa.getConvenientDescription(), String.valueOf(villa.getAreaPool()), String.valueOf(villa.getNumberOfFloors())};
            villas.add(arr);
            CsvReaderWriter.writerCsv(villas,"Villa");
        }

    public void addNewRoom () {
        List <String[]> rooms = new ArrayList<>();
        Room room = (Room) RoomInput.inputNewRoom();
        String[] arrRoom =new String[]{room.getId(),room.getNameService(), String.valueOf(room.getArea()),
                String.valueOf(room.getRentalCosts()), String.valueOf(room.getMaxNumberOfPeople()),room.getTypeRent(),
                room.getFreeService()};
        rooms.add(arrRoom);
        CsvReaderWriter.writerCsv(rooms,"Room");
    }

    public void addNewHouse () {
        List <String[]> houses = new ArrayList<>();
        House house = (House) HouseInput.inputNewHouse();
        String[] arrHouse =new String[]{house.getId(),house.getNameService(), String.valueOf(house.getArea()),
                String.valueOf(house.getRentalCosts()), String.valueOf(house.getMaxNumberOfPeople()),house.getTypeRent(),
                house.getRoomStandard(),house.getConvenientDescription(),String.valueOf(house.getNumberOfFloors())};
        houses.add(arrHouse);
        CsvReaderWriter.writerCsv(houses,"House");
    }

    private void addNewBooking() {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers;
        customers = CsvReaderWriter.readCsvFileCustomer();
        Collections.sort(customers, new SortNameCustomer());
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("--------------------------------------------------");
            System.out.println((i + 1) + ". " + customers.get(i).showInfo());
        }
        System.out.print("Enter your choice: ");
        int choiceCustomer = scanner.nextInt();
        while (choiceCustomer < 1 || choiceCustomer > customers.size()) {
            System.out.println("Size of list Customer: " + customers.size() + ", choice: " + choiceCustomer);
            System.out.print("Enter your choice: ");
            choiceCustomer = scanner.nextInt();
        }
        Customer customer = customers.get(choiceCustomer - 1);
        System.out.println("1. Booking Villa\n2. Booking House \n3. Booking Room");
        int choiceBooking = scanner.nextInt();
        while (choiceBooking < 1 || choiceBooking > 3) {
            System.out.println("Error!");
            System.out.println();
            System.out.println("1. Booking Villa\n2. Booking House \n3. Booking Room");
            choiceBooking = scanner.nextInt();
        }
        switch (choiceBooking) {
            case 1: {
                List<Villa> villas;
                villas = CsvReaderWriter.readCsvFileVilla();
                for (int i = 0; i < villas.size(); i++) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("No" + (i + 1));
                    System.out.println(villas.get(i).showInfo());
                }
                System.out.print("Enter choice booking Villa:");
                Villa villa = villas.get(scanner.nextInt() - 1);
                customer.setService(villa);
                break;
            }
            case 2: {
                List<House> houses;
                houses = CsvReaderWriter.readCsvFileHouse();
                for (int i = 0; i < houses.size(); i++) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("No" + i + 1);
                    System.out.println(houses.get(i).showInfo());
                }
                System.out.print("Enter choice booking House:");
                House house = houses.get(scanner.nextInt() - 1);
                customer.setService(house);
                break;
            }
            case 3: {
                List<Room> rooms;
                rooms = CsvReaderWriter.readCsvFileRoom();
                for (int i = 0; i < rooms.size(); i++) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("No" + i + 1);
                    System.out.println(rooms.get(i).showInfo());
                }
                System.out.print("Enter choice booking Room: ");
                Room room = rooms.get(scanner.nextInt() - 1);
                customer.setService(room);
                break;
            }
            default: {
                displayMainMenu();
            }
        }
        List<Customer> listBooking = CsvReaderWriter.readCsvFileCustomer();
        listBooking.add(customer);
        CsvReaderWriter.WriteCsvFileBooking(listBooking);
        displayMainMenu();
    }

    private void showBookingCinema() {
        Queue<Customer> customers = BookingCinema4DServiceImpl.getAllBookingCinema();
        while (true) {
            Customer customer = customers.poll();
            if (customer == null) {
                break;
            }
            System.out.println(customer);
        }
    }

    private void addBookingCinema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number ticket: ");
        int numberTicket = scanner.nextInt();
        while (numberTicket < 1) {
            System.out.println("Số lượng vé phải là số dương");
        }
        for (int i = 0; i < numberTicket; i++) {
            Customer customer = CustomerInput.inputNewCustomer();
            BookingCinema4DServiceImpl.addBookingCinema(customer);
        }
    }

    private void searchFilingCabinetsOfEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id of Employee: ");
        String idEmployee = scanner.nextLine();
        Employee employee = FilingCabinetsServiceImpl.findEmployeeById(idEmployee);
        if (employee == null) {
            System.out.println("Not found Filing Cabinets!");
        } else {
            System.out.println("----------------------------------------------------------------");
            System.out.println(employee);
            System.out.println("----------------------------------------------------------------");
        }
        displayMainMenu();
    }

}
