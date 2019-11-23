package supplementsC.Model;

import org.springframework.stereotype.Component;

@Component
public class Order {
    private int product_id;
    private String customerName;
    private String creditCard;
    private String address;
    private String zip;

    public Order() {
    }

    public Order(int product_id, String customerName, String creditCard, String address, String zip) {
        this.product_id = product_id;
        this.customerName = customerName;
        this.creditCard = creditCard;
        this.address = address;
        this.zip = zip;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product_id=" + product_id +
                ", customerName='" + customerName + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
