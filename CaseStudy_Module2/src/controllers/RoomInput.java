package controllers;


import models.*;

import java.util.Scanner;

public class RoomInput {
    public  static Services inputNewRoom(){
        Scanner scanner = new Scanner(System.in);
        Services room = new Room();
        System.out.println("Enter ID: ");
        room.setId(scanner.nextLine());
        System.out.println("Enter name Service: ");
        room.setNameService(scanner.nextLine());
        System.out.println("Enter area use: ");
        room.setArea(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter rental Costs: ");
        room.setRentalCosts(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter Max Number Of People: ");
        room.setMaxNumberOfPeople(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter type rent : ");
        room.setTypeRent(scanner.nextLine());
        System.out.print("Enter room standard : ");
        ((Room) room).setFreeService(scanner.nextLine());
        System.out.println("------------------------------------------------");
        return room;
    }
}
