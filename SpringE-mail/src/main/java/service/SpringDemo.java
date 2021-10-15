package service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("mail.xml");
		EmailService service=(EmailService)context.getBean("mailSender");
		service.sendEmail("somebody@gmail.com", "Test Subject", "Testing body","");
		
		
		//Send a pre-configured mail
       // service.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
	}

}
