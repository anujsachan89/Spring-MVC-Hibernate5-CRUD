package com.anuj.springhibernate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anuj.springhibernate.entity.Customer;
import com.anuj.springhibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// need to inject customerService
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		// get customer form customerService
		List<Customer> theCustomer = customerService.getCustomers();
		// add the customers to model
		theModel.addAttribute("customers", theCustomer);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		//savecustomer using customerservice
		customerService.save(theCustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormUpdate")
	public String updateCustomer(@RequestParam("customerId") int id, Model theModel) {
		//get the customer from service
		Customer theCustomer = customerService.getCustomer(id);
		// set customer a model attribute or prepoulate a form
		theModel.addAttribute("customer", theCustomer);
		//send it over to form
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		//delete the customer from service
		customerService.deleteCustomer(id);
		//send it over to form
		return "redirect:/customer/list";
	}
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }
}
