/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import icontroller.IEmployeeController;
import idaos.IGeneralDAO;
import daos.GeneralDAO;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class EmployeeController implements IEmployeeController{
    
    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private IGeneralDAO<Employee> gdao;

    public EmployeeController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Employee.class);
    }
    
    
    @Override
    public List<Employee> getAll() {
        return gdao.getData(gdao);
    }

    @Override
    public Employee getById(String id) {
        return gdao.getById(new Integer(id));
    }

    @Override
    public List<Employee> search(Object keyword) {
        return gdao.getData(keyword);
    }

   
    @Override
    public String delete(String id) {
        if (gdao.saveOrDelete(new Employee(), true)) {
            return "Data berhasil dihapus";
        }else{
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String id, String firstName, String lastName, String email, String phoneNumber, String hireDate, String salary, String commissionPct, String department, String manager, String job) {
        
        if (gdao.saveOrDelete(new Employee(), false)) {
            return "Data berhasil ditambahkan";
        }else{
            return "Data gagal ditambahkan";
        }
    }
    
}
