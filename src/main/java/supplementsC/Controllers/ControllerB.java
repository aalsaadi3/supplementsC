//package supplementsC.Controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import supplementsC.Model.Customer;
//import supplementsC.Model.CustomerRepo;
//
//import java.util.Optional;
//
//@Controller
//public class ControllerB {
//
//    @Autowired
//    CustomerRepo customerRepo;
//
//    @RequestMapping("/customer")
//    public ModelAndView home(){
//        ModelAndView mv = new ModelAndView("customer");
//        mv.addObject("list", customerRepo.findAll());
//
//        return mv;
//    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView save(@RequestParam("customer_id") String customer_id, @RequestParam("customer_name") String customer_name, @RequestParam("credit_card") String credit_card, @RequestParam("address") String address, @RequestParam("zip") String zip)){
//        ModelAndView mv = new ModelAndView("redirect:/");
//        Customer customerToSave ;
//        if(!customer_id.isEmpty())
//        {
//            //maybe our repository does not have customers by default, which may mean it does not make sense to find a customer
//            Optional<Customer> customer = customerRepo.findById(Integer.parseInt(customer_id));
//            customerToSave = customer.get();
//        }
//        else
//        {
//            customerToSave = new Customer();
//        }
//        customerToSave.setCustomer_name(customer_name);
//
//        customerRepo.save(customerToSave);
//        mv.addObject("list", customerRepo.findAll());
//        return mv;
//    }
//
//    @RequestMapping(value = "/customer/{customer_id}", method = RequestMethod.GET)
//    public ModelAndView view(@PathVariable("customer_id") int customer_id){
//        ModelAndView mv = new ModelAndView("customerInformation");
//        Optional<Customer> customer = customerRepo.findById(customer_id);
//        Customer customerToMap = customer.get();
//        mv.addObject("selectedCustomer",customerToMap);
//        return mv;
//    }
//}
