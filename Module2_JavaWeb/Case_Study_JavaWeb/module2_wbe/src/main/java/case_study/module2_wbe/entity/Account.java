package case_study.module2_wbe.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private long id;

    @Column(name = "account_username", unique = true)
    private String userName;

    @Column(name = "account_password")
    private String password;

    @Column(name = "account_status")
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority  authority;

    public Account() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority  authority) {
        this.authority = authority;
    }
}
