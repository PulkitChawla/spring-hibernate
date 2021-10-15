package update;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Object o=session.get(Product.class, new Integer(101));
		Product p=(Product)o;
		p.setPrice(10000);
		session.close();
		
		Session session1=factory.openSession();
		Object o1=session1.get(Product.class, new Integer(101));
		Transaction tx=session.beginTransaction();
		session1.merge(p);
		tx.commit();
		
		System.out.println("Object updated successfully");
		
		session.close();
		factory.close();
	}

}
