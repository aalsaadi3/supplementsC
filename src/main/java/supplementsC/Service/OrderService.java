package supplementsC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supplementsC.Model.*;

@Service
public class OrderService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    ProductRepo productRepo;


    public Transaction saveOrder(Order ord, Transaction trans, Customer cust){
        cust.setCustomer_name(ord.getCustomerName());
        cust.setCredit_card(ord.getCreditCard());
        cust.setAddress(ord.getAddress());
        cust.setZip(ord.getZip());
        Customer newCust = customerRepo.save(cust);

        trans.setCustomer(newCust);
        Product product = productRepo.findById(ord.getProduct_id()).get();
        trans.setProduct(product);
        trans.setTotal_cost(product.getPrice());

        return transactionRepo.save(trans);
    }

}
