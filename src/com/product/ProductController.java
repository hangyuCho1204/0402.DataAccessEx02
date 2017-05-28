package com.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String inputproduct(@ModelAttribute Product product){
		return "input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertproduct(@ModelAttribute Product product){
		
		int cnt = productService.saveProduct(product);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateproduct(@RequestParam("id") String pk, Model model){
		Product product = productService.getProductsPk(pk);
		model.addAttribute("product", product);
		System.out.println("pk:"+pk);
		return "update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String modifiyproduct(@ModelAttribute Product product){
		
		String[] ids = product.getId().split(",");
		String id = ids[ids.length-1];
		product.setId(id);
		
		int cnt = productService.modifiyProduct(product);
		System.out.println(cnt);
		return "redirect:list";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Product> List(@ModelAttribute Product product, Model model){
		List<Product> lists = productService.getProducts();
	
		
		model.addAttribute("lists", lists);
		return lists;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@ModelAttribute Product product, Model model){
		List<Product> lists = null;
		
		
		if(product.getName()!=null){
		String[] names = product.getName().split(",");
		String name = names[names.length-1];
		product.setName(name);
		}
		
		if(product.getName()!=null){
			System.out.println("like 작동");
			lists = productService.productLike(product.getName());
		}else{
			System.out.println("All 작동");
		lists = productService.getProducts();
		}
		
		model.addAttribute("lists", lists);
		return "search";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchGetName(@ModelAttribute Product product, Model model){
		
		
		model.addAttribute("name", product.getName());
		return "redirect:search";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("id") String pk){
		
		System.out.println("pk"+pk);
		
		int cnt = productService.removeProduct(pk);
		
		
		return "redirect:list";
	}
	
	
}
