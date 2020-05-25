package models;

public class House extends Services {
    private String roomStandard;
    private String convenientDescription;
    private int numberOfFloors;

    public House() {
    }

    public House(String id, String nameService, double area, double rentalCosts, int maxNumberOfPeople, String typeRent,
                 String roomStandard, String convenientDescription, int numberOfFloors) {
        super(id, nameService, area, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenientDescription() {
        return convenientDescription;
    }

    public void setConvenientDescription(String convenientDescription) {
        this.convenientDescription = convenientDescription;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String[] getAllHouse(){
        String[] house = {getId(),getNameService(), String.valueOf(getArea()),String.valueOf(getRentalCosts()),
                String.valueOf(getMaxNumberOfPeople()),getTypeRent(),this.roomStandard,this.convenientDescription,
                String.valueOf(this.numberOfFloors)};
        return house;
    }

    @Override
    public String showInfo() {
        return "House: " + '\n' +
                "Id: " + super.getId() + '\n' +
                "Name ServiceInterface: " + super.getNameService() + '\n' +
                "Area​​ Use: " + super.getArea() + '\n' +
                "Rental Costs: " + super.getRentalCosts() + '\n' +
                "Max Number Of People: " + super.getMaxNumberOfPeople() + '\n' +
                "Type Rent: " + super.getTypeRent()+ '\n' +
                "Room Standard: " + roomStandard + '\n' +
                "Convenient Description:  " + convenientDescription + '\n' +
                "Number Of Floors: " + numberOfFloors;
    }
}
