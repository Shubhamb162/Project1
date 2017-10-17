package niit.projectbackend.projectbackend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import niit.projectbackend.projectbackend.dao.CustomerDao;

public class Testing {
	
	//we have to declare reference variables here to access it in any method
	AnnotationConfigApplicationContext context;
	CustomerDao customerDao;
	Customer customer;
 
    @Before
    public void init()
    {
    	//making object of AnnotationConfigApplicationContext
    	context=new AnnotationConfigApplicationContext();
    	//scanning the whole project for making bean objects
    	context.scan("niit.projectbackend.projectbackend");
    	//refresh the Spring Container 
    	context.refresh();
    	//getting the beans of customerDao type
    	customerDao=(CustomerDao) context.getBean("customerDao");
    	//Creating the object of POJO class or Transaction manager
    	customer=new Customer();
    	
    }
     @Test  
     public void customerTest()  
     {  
    	 //customer.setCustomerId(102);
    	 customer.setFirstName("Aman");
 		 customer.setLastName("Pathak");
 		 customer.setPassword("123");
 		 customer.setConfirmPassword("123");
         Assert.assertEquals("Data Entered Ureka",true,customerDao.addCustomer(customer));  
     } 
}
