package service.input;


import models.*;
import service.interfaces.ServiceInterface;
import validation.Validation;

import java.util.Scanner;
import java.util.UUID;

public class HouseInput implements ServiceInterface {
    @Override
    public  Services addNewService() {
        Scanner scanner = new Scanner(System.in);
        Services house = new House();
        house.setId(UUID.randomUUID().toString().replace("-", ""));
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
        System.out.print("Enter convenient description (format:massage|karaoke|food|drink|car|^no need) : ");
        ((House) house).setConvenientDescription(Validation.validationConvenientDescription());
        System.out.println("Enter Number Of Floors");
        ((House) house).setNumberOfFloors(Validation.validationNumberOfFloors());
        System.out.println("------------------------------------------------");
        return house;
    }
}
