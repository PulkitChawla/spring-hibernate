package basic;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
         
		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		            
		    Emp e1=new Emp();    
		    e1.setId(001);    
		    e1.setFirstName("Pulkit");    
		    e1.setLastName("Chawla");    
		        
		    session.save(e1);  
		    t.commit();  
		    System.out.println("successfully saved");    
		    factory.close();  
		    session.close();    
		        
	}

}
