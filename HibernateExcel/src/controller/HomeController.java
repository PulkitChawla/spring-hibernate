package controller;

import javax.servlet.http.HttpServletRequest;
 
import dao.FileUploadDao;
import model.UploadFile;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Handles requests for the file upload page.
 */
@Controller
public class HomeController 
{
	 @Autowired
	    private FileUploadDao fileUploadDao;
	 
	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String showUploadForm(HttpServletRequest request) {
	        return "Upload";
	    }
	     
	    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	    public String handleFileUpload(HttpServletRequest request,
	            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
	          
	        if (fileUpload != null && fileUpload.length > 0) {
	            for (CommonsMultipartFile aFile : fileUpload){
	                  
	                System.out.println("Saving file: " + aFile.getOriginalFilename());
	                 
	                UploadFile uploadFile = new UploadFile();
	                uploadFile.setFileName(aFile.getOriginalFilename());
	                uploadFile.setData(aFile.getBytes());
	                fileUploadDao.save(uploadFile);               
	            }
	        }
	  
	        return "Success";
	    } 
}
