package getandload;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Product product=new Product();
		product.setProductId(1);
		product.setProductName("Apple");
		product.setPrice(50000);
		
		session.save(product);
		tx.commit();
		System.out.println("Object saved successfully");
		
		session.close();
		factory.close();

	}

}
