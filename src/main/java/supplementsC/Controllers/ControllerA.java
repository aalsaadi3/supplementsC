package supplementsC.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import supplementsC.Model.*;
import supplementsC.Service.OrderService;

import java.util.Optional;

@Controller
public class ControllerA {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderService orderService;
    @Autowired
    TransactionRepo transactionRepo;

    private Logger log = LoggerFactory.getLogger(ControllerA.class);

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("list", productRepo.findAll());
        return mv;
    }


    @PostMapping()
    public String gotToCustomer() {
        return "customer";
    }

    @PostMapping("/transaction")
    public void sendToTransaction(@PathVariable int product_id) {

    }

//    @GetMapping(value = "/purchase/{product_id}")
//        public String purchase(@PathVariable("product_id") int product_id)
//    {
//
//        return "customer";
//    }

    @GetMapping( value = "/purchase/{product_id}")
    public ModelAndView purchase(@PathVariable("product_id") int product_id,
                                 ModelAndView mv, Customer customer){
        mv.setViewName("customer");
        Optional<Product> product = productRepo.findById(product_id);
        mv.addObject("product", product.get());
        mv.addObject("customer", customer);
        mv.addObject("order", new Order(2, "aga", "24421", "ttwaf", "66776"));
        System.out.println("product_id of purchased: " + product_id);
        return mv;
    }

//    @ModelAttribute(value = "order")
//    public Entity newOrderEntity()
//    {
//        return new OrderEntity();
//    }
    @PostMapping(value = "/finalize")
    public ModelAndView transaction(@ModelAttribute("order") Order order,
                                    Transaction trans, Customer cust, Product prod, ModelAndView mv){
        //order = new Order(1, "aga", "24421", "ttwaf", "66776");
        log.info(order.toString());
        orderService.saveOrder(order, trans, cust);
        mv.setViewName("transaction");
        mv.addObject("trans", trans);
        mv.addObject("cust", cust);
        prod = productRepo.findById(order.getProduct_id()).get();
        mv.addObject("prod",prod);
        return mv;
    }

    //value = "/purchase/{product_id}
//    @GetMapping(value = "/customer")
//    public View goToCustomer(){
//
//    }
//    @RequestMapping( value = "/purchase/{product_id}", method = RequestMethod.GET)
//    public ModelAndView purchase(@PathVariable("product_id") int product_id,
//                                 ModelAndView mv, Customer customer){
//        mv.setViewName("customer");
//        Optional<Product> product = productRepo.findById(product_id);
//        mv.addObject("selectedProduct", product.get());
//        mv.addObject("customer", customer);
//        return mv;
//    }
//
//

//        @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView save(@RequestParam("product_id") String product_id, @RequestParam("product_name") String product_name, @RequestParam("price") Double price){
//        ModelAndView mv = new ModelAndView("redirect:/");
//        Product productToSave ;
//        if(!product_id.isEmpty())
//        {
//            //maybe our repository does not have Products by default, which may mean it does not make sense to find a Product
//            Optional<Product> product = productRepo.findById(Integer.parseInt(product_id));
//            productToSave = product.get();
//        }
//        else
//        {
//            productToSave = new Product();
//        }
//        productToSave.setProduct_name(product_name);
//
//        productRepo.save(productToSave);
//        mv.addObject("list", productRepo.findAll());
//        return mv;
//    }

}
