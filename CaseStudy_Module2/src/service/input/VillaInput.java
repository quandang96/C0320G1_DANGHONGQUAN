package service.input;
import models.*;
import service.interfaces.ServiceInterface;
import validation.Validation;
import java.util.UUID;

public class VillaInput implements ServiceInterface {
    @Override
    public  Services addNewService(){
        Services villa = new Villa();
        villa.setId(UUID.randomUUID().toString().replace("-", ""));
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
        System.out.print("Enter convenient description (format:massage|karaoke|food|drink|car|^no need): ");
        ((Villa) villa).setConvenientDescription(Validation.validationConvenientDescription());
        System.out.print("Enter area pool: ");
        ((Villa) villa).setAreaPool(Validation.validationArea());
        System.out.println("Enter Number Of Floors");
        ((Villa) villa).setNumberOfFloors(Validation.validationNumberOfFloors());
        System.out.println("------------------------------------------------");
        return villa;
    }

    }

