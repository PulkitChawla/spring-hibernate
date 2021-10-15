package excel;

import java.io.*;
import java.util.*;
import org.hibernate.Session;    
import org.hibernate.SessionFactory; 
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Transaction;  
/*import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
*/

import com.fasterxml.classmate.AnnotationConfiguration;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row;
/*
import org.apache.poi.ss.usermodel.CellStyle; 
import org.apache.poi.ss.usermodel.DataFormat;  
import org.apache.poi.hssf.usermodel.HSSFCell; 
import org.apache.poi.hssf.usermodel.HSSFRow; 
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
*/


public class Main {
	static List<Employee>empList = new ArrayList<Employee>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Employee>employees=readExcel("D:\\test.xls");
	        persistToDB(employees);
	}



	private static List<Employee> readExcel(String filepath) {
	    try {
	        FileInputStream file = new FileInputStream(new File("D:\\test.xls"));

	        // Getting the instance for XLS file
	        HSSFWorkbook workbook = new HSSFWorkbook(file);

	        // Get First sheet from the workbook
	        HSSFSheet sheet = workbook.getSheetAt(0);

	        ArrayList myList = new ArrayList();
	        // Iterate start from the first sheet of the uploaded excel file
	        Iterator<Row> rowIterator = sheet.iterator();
	        Employee employee = new Employee();


	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();

	            if (row.getRowNum() == 0) {
	                continue;// skip to read the first row of file
	            }

	            // For each row, iterate through each columns
	            Iterator<Cell> cellIterator = row.cellIterator();
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                if (cell.getColumnIndex() == 0 ) {
	                    employee.setId((int)cell.getNumericCellValue());
	                    empList.add(employee);
	                    System.out.print(cell.getNumericCellValue() + "\t\t");
	                }
	                else if (cell.getColumnIndex() == 1 ) {
	                    employee.setName(cell.getStringCellValue());
	                    empList.add(employee);
	                    System.out.print(cell.getStringCellValue() + "\t\t");
	                }
	                else if (cell.getColumnIndex() == 2 ) {
	                    employee.setLocation(cell.getStringCellValue());
	                    empList.add(employee);
	                    System.out.print(cell.getStringCellValue() + "\t\t");
	                }
	                }
	            System.out.println(""); 


	            }


	        file.close();       

	}catch (FileNotFoundException fnfe) {
	    fnfe.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	    return empList;
	}

	private static void persistToDB(List<Employee> employees) {
	    /*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    */
//
//	        AnnotationConfiguration c = new AnnotationConfiguration();
//	        c.configure("hibernate.cfg.xml");
//	        // SessionFactory holds cfg file properties like // driver props and
//	        // hibernate props and mapping file
//	        SessionFactory sf = c.buildSessionFactory();
//	        // create one session means Connection
//	        Session s = sf.openSession();
//	        // before starting save(),update(), delete() operation we need to
//	        // start TX // starting tx mean con.setAutoCommit(false);
//	        Transaction tx = s.beginTransaction();
//	        try {
//	        for (int i = 0; i < employees.size(); i++) {
//	            Employee emp = employees.get(i);
//	            s.save(emp);
//	        }
//	        tx.commit();
//	        s.close();
//
//	    } catch (Exception e) {
//	        tx.rollback();
//	    }

	    }
}
