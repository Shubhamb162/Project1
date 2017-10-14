package niit.projectbackend.projectbackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import niit.projectbackend.projectbackend.Customer;
import niit.projectbackend.projectbackend.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {

	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		try{
			sessionFactory.getCurrentSession().save(customer);
			return true;			
		}
		catch(Exception ex)
		{		
			return false;
		}
		//return false; we can write here also but logically we have to write in Catch block
}
	

}
