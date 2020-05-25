package service;

import models.*;
import validation.Validation;

import java.util.Scanner;

public class VillaInput  {
    public  static Services inputNewVilla(){
        Scanner scanner = new Scanner(System.in);
        Services villa = new Villa();
        System.out.println("Enter ID: ");
        villa.setId(scanner.nextLine());
        System.out.println("Enter name Service: ");
        villa.setNameService(Validation.validationNamService());
        System.out.println("Enter area use: ");
        villa.setArea(Validation.validationArea());
        System.out.println("Enter rental Costs: ");
        villa.setRentalCosts(Validation.validationRentalCosts());
        System.out.println("Enter Max Number Of People: ");
        villa.setMaxNumberOfPeople(Validation.validationMaxNumberOfPeople());
        System.out.println("Enter type rent : ");
        villa.setTypeRent(Validation.validationNamService());
        System.out.print("Enter room standard : ");
        ((Villa) villa).setRoomStandard(Validation.validationNamService());
        System.out.print("Enter convenient description: ");
        ((Villa) villa).setConvenientDescription(Validation.validationConvenientDescription());
        System.out.print("Enter area pool: ");
        ((Villa) villa).setAreaPool(Validation.validationArea());
        System.out.println("Enter Number Of Floors");
        ((Villa) villa).setNumberOfFloors(Validation.validationNumberOfFloors());
        System.out.println("------------------------------------------------");
        return villa;
    }

    }

