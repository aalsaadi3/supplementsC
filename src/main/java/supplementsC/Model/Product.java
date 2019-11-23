package supplementsC.Model;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public int product_id;
    @Column(name = "product_name")
    public String product_name;
    @Column(name = "price")
    public Double price;


//    fetch = FetchType.EAGER, cascade = CascadeType.ALL
//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Transaction> transactions = new ArrayList<>();
    public Product() {
    }

    public Product(String product_name, String category, Double price, int quantity) {
        this.product_name = product_name;
        this.price = price;
//        transactions = new ArrayList<>();
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
