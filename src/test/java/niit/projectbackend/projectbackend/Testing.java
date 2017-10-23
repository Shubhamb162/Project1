package niit.projectbackend.projectbackend;

import java.util.List;

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
    public void customerAddTest()  
     {  
    	 //customer.setCustomerId(102);
    	 customer.setFirstName("Ajay");
 		 customer.setLastName("Tomar");
 		 customer.setPassword("123");
 		 customer.setConfirmPassword("123");
         Assert.assertEquals("Data Entered Ureka",true,customerDao.addCustomer(customer));  
     }
    
     @Test
     public void customerDeleteTest()
     {
    	 customer.setCustomerId(40);
    	 Assert.assertEquals("Data Deleted",true,customerDao.deleteCustomer(customer));
     }
     @Test  
     public void customerGetTest() {  
    	 customer = customerDao.getCustomer(1);  
         
         Assert.assertNotNull(customer);
         System.out.println(customer.getFirstName());
         System.out.println(customer.getLastName());       
     }
    @Test 
    public void customerUpdateTest()
    {
    	customer=customerDao.getCustomer(1);
    	customer.setFirstName("Arun");
    	customer.setLastName("Shah");
    	Assert.assertEquals("Updated",true,customerDao.updateCustomer(customer));
    }
    
    @Test
    public void customerListTest()
    {
    	List<Customer> customerList=customerDao.getALLCustomer();
    	boolean bool=((Object) customerList).hasNext();
    	System.out.println(customerList.size());
    	//Assert.assertEquals("",true,customerList.isEmpty());
    	//Assert.assertThat(customerList, not(IsEmptyList.empty()));

    }
     
}     
