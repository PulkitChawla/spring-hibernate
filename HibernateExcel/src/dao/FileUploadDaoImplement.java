package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import model.UploadFile;

public class FileUploadDaoImplement implements FileUploadDao
{
	 @Autowired
	    private SessionFactory sessionFactory;
	     
	    public FileUploadDaoImplement() {
	    }
	 
	    public FileUploadDaoImplement(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	    @Override
	    @Transactional
	    public void save(UploadFile uploadFile) {
	        sessionFactory.getCurrentSession().save(uploadFile);
	    }
}
