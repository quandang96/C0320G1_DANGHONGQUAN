package case_study.module2_wbe.entity;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private long id;

    @Column(name = "contract_start_date")
    private LocalDateTime startDate;

    @Column(name = "contract_end_date")
    private LocalDateTime endDate;

    @Column(name = "contract_deposit")
    private double deposit;

    @Column(name = "contract_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToMany
    @JoinTable(name = "contract_detail")
    private List<AttachService> attachServices;

    public Contract() {
    }

    public Contract(long id, LocalDateTime startDate, LocalDateTime endDate, double deposit, boolean status, Customer customer, Service service, List<AttachService> attachServices) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.status = status;
        this.customer = customer;
        this.service = service;
        this.attachServices = attachServices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<AttachService> getAttachServices() {
        return attachServices;
    }

    public void setAttachServices(List<AttachService> attachServices) {
        this.attachServices = attachServices;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        if(contract.endDate == null || contract.startDate == null){
            errors.rejectValue("endDate","message.birthday");
            errors.rejectValue("startDate","message.birthday");
        }
    }
}
