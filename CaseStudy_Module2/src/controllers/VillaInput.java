package controllers;

import models.*;

import java.util.Scanner;

public class VillaInput  {
    public  static Services inputNewVilla(){
        Scanner scanner = new Scanner(System.in);
        Services villa = new Villa();
        System.out.println("Enter ID: ");
        villa.setId(scanner.nextLine());
        System.out.println("Enter name Service: ");
        villa.setNameService(scanner.nextLine());
        System.out.println("Enter area use: ");
        villa.setArea(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter rental Costs: ");
        villa.setRentalCosts(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter Max Number Of People: ");
        villa.setMaxNumberOfPeople(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter type rent : ");
        villa.setTypeRent(scanner.nextLine());
        System.out.print("Enter room standard : ");
        ((Villa) villa).setRoomStandard(scanner.nextLine());
        System.out.print("Enter convenient description: ");
        ((Villa) villa).setConvenientDescription(scanner.nextLine());
        System.out.print("Enter area pool: ");
        ((Villa) villa).setAreaPool(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter Number Of Floors");
        ((Villa) villa).setNumberOfFloors(Integer.parseInt(scanner.nextLine()));
        System.out.println("------------------------------------------------");
        return villa;
    }

    }

