package hello;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

/*	Inject controller with customer repo
//	in Order to this, we need to add This with the app resource annotation so that injects 
	our ability to reference this customer repo object we create here and we will do a request mapping */
	
	@Resource
	CustomerRepository customerRepo;
	
	@RequestMapping("/customers")
	public String showAllCustomers(Model model) {
		model.addAttribute("customers", customerRepo.findAll());
		return "customers";
	}
	
	@RequestMapping("/sorted-customers")
	public String showAllCustomersSorted(Model model) {
		model.addAttribute("customers", customerRepo.findAllByOrderByLastNameAsc());
		return "customers";
	}
	
	@RequestMapping("/sorted-three")
	public String showThreeCustomersSorted(Model model) {
		model.addAttribute("customers", customerRepo.findFirst3ByOrderByLastNameAsc());
		return "customers";
	}
}
