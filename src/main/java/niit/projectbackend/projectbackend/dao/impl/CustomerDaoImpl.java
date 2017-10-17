package niit.projectbackend.projectbackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import niit.projectbackend.projectbackend.Customer;
import niit.projectbackend.projectbackend.dao.CustomerDao;

@Repository("customerDao")//for doing all database related operation we have to use @Repository annotation
@Transactional
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

	@Override
	public boolean getCustomer(Customer customer) {
			 if(sessionFactory.getCurrentSession().getEntityName(customer) != null)
				 return true;
			return false;
		}


}
