package models;



public class Villa extends Services {

    private String roomStandard;
    private String convenientDescription;
    private double areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String id, String nameService, double area, double rentalCosts, int maxNumberOfPeople, String typeRent,
                 String roomStandard, String convenientDescription, double areaPool, int numberOfFloors) {
        super(id, nameService, area, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.areaPool = areaPool;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String[] getAllVilla(){
        String[] villa = {getId(),getNameService(), String.valueOf(getArea()),String.valueOf(getRentalCosts()),
                String.valueOf(getMaxNumberOfPeople()),getTypeRent(),this.roomStandard,this.convenientDescription,
                String.valueOf(this.areaPool) , String.valueOf(this.numberOfFloors)};
        return villa;
    }


    @Override
    public String showInfo() {
        return "Villa: " + '\n' +
                "Id: " + super.getId() + '\n' +
                "Name ServiceInterface: " + super.getNameService() + '\n' +
                "Area: " + super.getArea() + '\n' +
                "Rental Costs: " + super.getRentalCosts() + '\n' +
                "Max Number Of People: " + super.getMaxNumberOfPeople() + '\n' +
                "Type Rent: " + super.getTypeRent()+ '\n' +
                "Room Standard: " + roomStandard + '\n' +
                "Convenient Description: " + convenientDescription + '\n' +
                "Area Pool: " + areaPool + '\n' +
                "Number Of Floors: " + numberOfFloors;
    }


}
