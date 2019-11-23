package supplementsC.Model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public int customer_id;
    @Column(name = "customer_name")
    public String customer_name;
    @Column(name = "credit_card")
    public String credit_card;
    @Column(name = "address")
    public String address;
    @Column(name = "zip")
    public String zip;
//    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //eager does extra accessing, read customer, load transactions into array lis. lazy is loaded only when invoked.
//    private List<Transaction> transactions = new ArrayList<>();

    public Customer() {
    }

    public Customer(String customer_name, String credit_card, String address, String zip) {
        this.customer_name = customer_name;
        this.credit_card = credit_card;
        this.address = address;
        this.zip = zip;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}