package controller;

import icontroller.IDepartmentController;
import idaos.IGeneralDAO;
import daos.GeneralDAO;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import org.hibernate.SessionFactory;


public class DepartmentController implements IDepartmentController {
    
    private IGeneralDAO<Department> gdao;

    public DepartmentController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Department.class);
    }

    @Override
    public List<Department> getAll() {
        return gdao.getData("");
    }

    @Override
    public Department getById(String id) {
        return gdao.getById(new Integer(id));
    }

//    @Override
    public List<Department> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (gdao.saveOrDelete(new Department(new Short(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }
    
    @Override
    public String save(String id, String title) {
//        if (gdao.saveOrDelete(new Department(id, title, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)), true)) {
        if(gdao.saveOrDelete(new Department(new Short(id), title), false)){  
        return "Data berhasil disimpan";
        }else{
            return "Data gagal disimpan";
        }
    }
    
}

