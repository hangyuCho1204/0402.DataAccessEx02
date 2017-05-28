package com.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String inputcustomer(@ModelAttribute Customer customer){
		
		return "input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertcustomer(@ModelAttribute Customer customer){
		
		int cnt = customerService.saveCustomer(customer);
		
		return "result";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updatecustomer(@RequestParam("id")String pk, @ModelAttribute Customer customer, Model model){
		
		customer = customerService.getCustomersPk(pk);
		
		System.out.println(customer.getName());
		model.addAttribute("customer", customer);
		return "update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String modifiycustomer(@ModelAttribute Customer customer){
		
		int cnt = customerService.modifiyCustomer(customer);
		System.out.println(cnt);
		return "redirect:list";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Customer> List(Model model){
		List<Customer> lists = customerService.getCustomers();
		model.addAttribute("lists", lists);
		return lists;
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("id") String pk){
		
		int cnt = customerService.removeCustomer(pk);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String likeput(@ModelAttribute Customer customer, Model model){
		
		//model에 없는 경우 만들어 주고, 있는 경우 참조한다.
		
		return "search";
	}
	
	//@RequestParam("name") String name
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String likeresult(@ModelAttribute("ddd") Customer customer, Model model){
		
		System.out.println("post name : "+customer.getName());
		
		List<Customer> lists = null;
		System.out.println("get name : " + customer.getName());
		if(customer.getName()!=null){
			lists = customerService.like(customer.getName());
		}else{
			lists = customerService.getCustomers();
		}
		
		model.addAttribute("lists", lists);
		return "search";
	}
}
