package niit.projectbackend.projectbackend.dao;

import org.springframework.stereotype.Component;
import niit.projectbackend.projectbackend.Customer;

@Component
public interface CustomerDao {
	
	public boolean addCustomer(Customer customer);
	public boolean getCustomer(Customer customer);
	//public Customer updateCustomer(Customer customer);
	//public boolean deleteCustomer(Customer customer);
	//public List<Customer> getALLCustomer(Customer customer);

}
