package com.jobiak.empapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobiak.empapi.model.Customer;
import com.jobiak.empapi.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	CustomerRepository repo;
	
	public Customer addCustomer(Customer customer)
	{
		Customer ref = repo.save(customer);
		return ref;
	}

	public Customer modeifyCustomer(Customer customer) {
		
		return repo.save(customer);
	}

	public void deleteCustomer(long id) {
		 repo.deleteById(id);;
		
	}

	public List<Customer> getAll() {
		
		return repo.findAll();
	}
}
