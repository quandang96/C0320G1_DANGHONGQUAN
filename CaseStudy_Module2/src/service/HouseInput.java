package service;


import models.*;
import validation.Validation;

import java.util.Scanner;

public class HouseInput {
    public  static Services inputNewHouse() {
        Scanner scanner = new Scanner(System.in);
        Services house = new House();
        System.out.println("Enter ID: ");
        house.setId(scanner.nextLine());
        System.out.println("Enter name Service: ");
        house.setNameService(Validation.validationNamService());
        System.out.println("Enter area use: ");
        house.setArea(Validation.validationArea());
        System.out.println("Enter rental Costs: ");
        house.setRentalCosts(Validation.validationRentalCosts());
        System.out.println("Enter Max Number Of People: ");
        house.setMaxNumberOfPeople(Validation.validationMaxNumberOfPeople());
        System.out.println("Enter type rent : ");
        house.setTypeRent(Validation.validationNamService());
        System.out.print("Enter room standard : ");
        ((House) house).setRoomStandard(Validation.validationNamService());
        System.out.print("Enter convenient description: ");
        ((House) house).setConvenientDescription(Validation.validationConvenientDescription());
        System.out.println("Enter Number Of Floors");
        ((House) house).setNumberOfFloors(Validation.validationNumberOfFloors());
        System.out.println("------------------------------------------------");
        return house;
    }
}
