package service;


import models.*;
import validation.Validation;

import java.util.Scanner;

public class RoomInput {
    public  static Services inputNewRoom(){
        Scanner scanner = new Scanner(System.in);
        Services room = new Room();
        System.out.println("Enter ID: ");
        room.setId(scanner.nextLine());
        System.out.println("Enter name Service: ");
        room.setNameService(Validation.validationNamService());
        System.out.println("Enter area use: ");
        room.setArea(Validation.validationArea());
        System.out.println("Enter rental Costs: ");
        room.setRentalCosts(Validation.validationRentalCosts());
        System.out.println("Enter Max Number Of People: ");
        room.setMaxNumberOfPeople(Validation.validationMaxNumberOfPeople());
        System.out.println("Enter type rent : ");
        room.setTypeRent(Validation.validationNamService());
        System.out.print("Enter room standard : ");
        ((Room) room).setFreeService(Validation.validationNamService());
        System.out.println("------------------------------------------------");
        return room;
    }
}
