package case_study.module2_wbe.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private long id;

    @Column(name = "service_name")
    private String name;

    @Column(name = "service_price")
    private double price;

    @Min(value = 30, message = "Area must be greater than 30 meters of square")
    @Column(name = "service_area")
    private double area;

    @Min(value = 1)
    @Column(name = "service_floor")
    private int floor;

    @Min(value = 1)
    @Column(name = "service_max_person")
    private int maxPerson;


    @Column(name = "service_status")
    private boolean status;

    @Column(name = "url")
    private String url;


    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private List<Contract> contracts;

    public Service() {
    }

    public Service(long id, String name, double price, @Min(value = 30, message = "Area must be greater than 30 meters of square") double area, @Min(value = 1) int floor, @Min(value = 1) int maxPerson, boolean status, ServiceType serviceType, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.area = area;
        this.floor = floor;
        this.maxPerson = maxPerson;
        this.status = status;
        this.serviceType = serviceType;
        this.contracts = contracts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
