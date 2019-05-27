/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controller.EmployeeController;
import daos.GeneralDAO;
import icontroller.IEmployeeController;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import models.Department;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class ManualTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println(factory);

        GeneralDAO<Employee> edao = new GeneralDAO<>(factory, Employee.class);
        IEmployeeController eco = new EmployeeController(factory);
        
//        System.out.println(eco.search("King"));
//        System.out.println(eco.getById("100").getFirstName());

//manualtest controller get all
        for (Employee employee : eco.getAll()) {
            System.out.println(employee.getFirstName()+", "+employee.getLastName());
            System.out.println(employee.getDepartmentId().getDepartmentName());
        }

//manualtest DAO getdata
//        for (Employee employee : edao.getData("")) {
//            System.out.println(employee.getFirstName()+", "+employee.getLastName());
//            System.out.println(employee.getDepartmentId().getDepartmentName());
//        }
//manualtest DAO getbyid
//        System.out.println(edao.getById(new Integer(100)).getLastName());
//manualtest DAO delete        
//        Employee employee = new Employee(110);
//        System.out.println(edao.saveOrDelete(employee, true));
        
//manualtest DAO insert
//        String date2 = "21/02/2000";
//        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//        Date date1 = formatter1.parse(date2);
//
//        System.out.println(edao.saveOrDelete(new Employee(new Integer(111), "put", "tra", "ppra", "098", date1, new BigDecimal(1000), new BigDecimal(0),
//                new Department(new Short("90")), new Employee(100), new Job("IT_PROG")), false));
//    }

//manualtest DAO update
//            System.out.println(edao.saveOrDelete(new Employee(new Integer(110), "put", "tra", "ppradana92@", "098", date1, new BigDecimal(1000), new BigDecimal(0),
//                new Department(new Short("90")), new Employee(100), new Job("IT_PROG")), false));
//    }
    }
}


