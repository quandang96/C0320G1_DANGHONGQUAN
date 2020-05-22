package controllers;


import models.*;

import java.util.Scanner;

public class HouseInput {
    public  static Services inputNewHouse() {
        Scanner scanner = new Scanner(System.in);
        Services house = new House();
        System.out.println("Enter ID: ");
        house.setId(scanner.nextLine());
        System.out.println("Enter name Service: ");
        house.setNameService(scanner.nextLine());
        System.out.println("Enter area use: ");
        house.setArea(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter rental Costs: ");
        house.setRentalCosts(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter Max Number Of People: ");
        house.setMaxNumberOfPeople(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter type rent : ");
        house.setTypeRent(scanner.nextLine());
        System.out.print("Enter room standard : ");
        ((House) house).setRoomStandard(scanner.nextLine());
        System.out.print("Enter convenient description: ");
        ((House) house).setConvenientDescription(scanner.nextLine());
        System.out.println("Enter Number Of Floors");
        ((House) house).setNumberOfFloors(Integer.parseInt(scanner.nextLine()));
        System.out.println("------------------------------------------------");
        return house;
    }
}
