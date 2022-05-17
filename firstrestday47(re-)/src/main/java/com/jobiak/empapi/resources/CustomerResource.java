package com.jobiak.empapi.resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobiak.empapi.model.Customer;
import com.jobiak.empapi.service.CustomerService;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(allowedHeaders = "*", origins="*")
@RestController
@RequestMapping("/customers")
public class CustomerResource 
{
	@Autowired
	CustomerService service;


	
	@GetMapping(value="/customer",produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer showCatalog()
	{
		Customer customer = new Customer();
		customer.setId(415L);
		customer.setName("Ganesh Enamala");
		customer.setBalance(109000);
		return customer;
	}
	@GetMapping("/intro")
	public String introduction()
	{
		return new String("Manufactured in India And Assembled in California");
	}
	
	@GetMapping("/search/{custId}")
	public String searchModel(@PathVariable(value="modelId")String modelId)
	{
		return new String(modelId+" is available in Product Red and Green only and delevery with in 24 hours with no charges");
	}
	@GetMapping("/search/name/{name}/{custId}")
	public String searchModel(@PathVariable(value="custId")String custId,@PathVariable(value="name")String brand)
	{
		return new String(custId+" is currently not available in your loation");
	}
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer addProduct(@RequestBody Customer customer)
	{
		//System.out.println(mobile);
		Customer ref = service.addCustomer(customer);
		return ref;
	}
	
	@PutMapping(value="/modify",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer modifyProduct(@RequestBody Customer mobile)
	{
		Customer ref = service.modeifyCustomer(mobile);
		return ref;
	}
	
	@CrossOrigin(origins="Localhost:4200")
	@DeleteMapping(value="/remove/{id}")
	public void removeProduct(@PathVariable long id)
	{
		service.deleteCustomer(id);
	}
	
	@CrossOrigin(origins="Localhost:4200")
	@GetMapping(value="/display",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer>showAll(){
		System.out.println("Request recieved..");
		return service.getAll();
	}
}
