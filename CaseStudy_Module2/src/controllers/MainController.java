package controllers;

import commons.CsvReaderWriter;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public void displayMainMenu() {
        System.out.println(
                "1.\t Add New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7.\tExit\n");
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
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
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
                        "6.\tShow All Name Name Not Duplicate\n" +
                        "7.\tBack to menu\n" +
                        "8.\tExit\n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                showAllVilla();
                break;
            /*case 2:
                showAllHouse();
                break;
            case 3:
                showAllRoom();
                break;
            case 4:
                addNewServices();
                break;
            case 5:
                break;
            case 6:
                addNewVilla();
                break;
            case 7:
                addNewVilla();
                break;*/
            case 8:
                System.exit(0);
                break;
            default: {
                addNewServices();

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
                    break;
                case 2:
                    addNewHouse ();
                    break;
                case 3:
                    addNewRoom ();
                    break;
                case 4:
                    addNewServices();
                    break;
                case 5:
                    System.exit(0);
                default: {
                    addNewServices();
                }

            }
        }
        public void showAllVilla{


    }

        public void addNewVilla () {
            String PATH_FILE_VILLA = "src/data/Villa.csv";
            String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "areaUse", "rentalCost", "maxNumberOfPeople",
                    "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};
            List <String[]> villas = new ArrayList<>();
            Villa villa = (Villa) VillaInput.inputNewVilla();
            String[] arr =new String[]{villa.getId(),villa.getNameService(), String.valueOf(villa.getArea()),
                    String.valueOf(villa.getRentalCosts()), String.valueOf(villa.getMaxNumberOfPeople()),villa.getTypeRent(),
                    villa.getRoomStandard(),villa.getConvenientDescription(), String.valueOf(villa.getAreaPool()), String.valueOf(villa.getNumberOfFloors())};
            villas.add(arr);
            CsvReaderWriter.writerCsv(villas,PATH_FILE_VILLA,FILE_HEADER_OF_VILLA);
        }
    public void addNewRoom () {
        String PATH_FILE_ROOM = "src/data/Room.csv";
        String[] FILE_HEADER_OF_ROOM = {" id", " nameService", "areaUse", "rentalCosts", "maxNumberOfPeople",
                "typeRent", "freeService"};
        List <String[]> rooms = new ArrayList<>();
        Room room = (Room) RoomInput.inputNewRoom();
        String[] arrRoom =new String[]{room.getId(),room.getNameService(), String.valueOf(room.getArea()),
                String.valueOf(room.getRentalCosts()), String.valueOf(room.getMaxNumberOfPeople()),room.getTypeRent(),
                room.getFreeService()};
        rooms.add(arrRoom);
        CsvReaderWriter.writerCsv(rooms,PATH_FILE_ROOM,FILE_HEADER_OF_ROOM);
    }

    public void addNewHouse () {
        String PATH_FILE_HOUSE = "src/data/House.csv";
        String[] FILE_HEADER_OF_HOUSE = {" id", " nameService", "areaUse", "rentalCosts", "maxNumberOfPeople",
                "typeRent", "roomStandard", "convenientDescription", "numberOfFloors"};
        List <String[]> houses = new ArrayList<>();
        House house = (House) HouseInput.inputNewHouse();
        String[] arrHouse =new String[]{house.getId(),house.getNameService(), String.valueOf(house.getArea()),
                String.valueOf(house.getRentalCosts()), String.valueOf(house.getMaxNumberOfPeople()),house.getTypeRent(),
                house.getRoomStandard(),house.getConvenientDescription(),String.valueOf(house.getNumberOfFloors())};
        houses.add(arrHouse);
        CsvReaderWriter.writerCsv(houses,PATH_FILE_HOUSE,FILE_HEADER_OF_HOUSE);
    }

        public static void main (String[]args){
           MainController mainController = new MainController();
           mainController.displayMainMenu();
        }
    }

