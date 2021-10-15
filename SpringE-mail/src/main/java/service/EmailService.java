package service;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("mailService")
public class EmailService 
{

@Autowired
private MailSender mailSender;
@Autowired
private SimpleMailMessage preConfiguredMessage;	

/**
 * This method will send compose and send the message 
 * */

public void sendEmail(String to,String from,String sub,String msgBody)
{
   	SimpleMailMessage message=new SimpleMailMessage();
	message.setFrom(from);
	message.setTo(to);
    message.setSubject(sub);
    message.setText(msgBody);
    mailSender.send(message);
}

/*  To attach a file with email, use MimeMessageHelper to attach the file with a MimeMessage.  */

/*public void sendMailWithAttachment(String to, String subject, String body, String fileToAttach) 
{
    MimeMessagePreparator preparator = new MimeMessagePreparator();
    {
        public void prepare(MimeMessage mimeMessage) throws Exception 
        {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setFrom(new InternetAddress("admin@gmail.com"));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(body);
             
            FileSystemResource file = new FileSystemResource(new File(fileToAttach));
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.addAttachment("logo.jpg", file);
        }
    };
     
    try {
        mailSender.send(preparator);
    }
    catch (MailException ex) {
        // simply log it and go on...
        System.err.println(ex.getMessage());
    }
}*/

/*
 Inline resources
Sometimes, we may want to attach inline resources such as inline images in email body.

Inline resources are added to the MimeMessage by using the specified Content-ID. Be sure to first add the text and then the resources. 
If you are doing it the other way around, it does not work.

Inline image
public void sendMailWithInlineResources(String to, String subject, String fileToAttach) 
{
    MimeMessagePreparator preparator = new MimeMessagePreparator() 
    {
        public void prepare(MimeMessage mimeMessage) throws Exception 
        {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setFrom(new InternetAddress("admin@gmail.com"));
            mimeMessage.setSubject(subject);
             
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
             
            helper.setText("<html><body><img src='cid:identifier1234'></body></html>", true);
             
            FileSystemResource res = new FileSystemResource(new File(fileToAttach));
            helper.addInline("identifier1234", res);
        }
    };
     
    try {
        mailSender.send(preparator);
    }
    catch (MailException ex) {
        // simply log it and go on...
        System.err.println(ex.getMessage());
    }
}
 */

public void sendPreConfiguredMail(String message) 
{
    SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
    mailMessage.setText(message);
    mailSender.send(mailMessage);
}
}
