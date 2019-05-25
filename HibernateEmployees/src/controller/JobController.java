package controller;

import icontroller.IJobController;
import idaos.IGeneralDAO;
import daos.GeneralDAO;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Job;
import org.hibernate.SessionFactory;


public class JobController implements IJobController {
    
    private IGeneralDAO<Job> gdao;

    public JobController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Job.class);
    }

    @Override
    public List<Job> getAll() {
        return gdao.getData(gdao);
    }

    @Override
    public Job getById(String id) {
        return gdao.getById(new Integer(id));
    }

//    @Override
    public List<Job> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (gdao.saveOrDelete(new Job(id), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }
    
    
    @Override
    public String save(String id, String title) {
//        if (gdao.saveOrDelete(new Job(id, title, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)), true)) {
        if(gdao.saveOrDelete(new Job(id, title), false)){  
        return "Data berhasil disimpan";
        }else{
            return "Data gagal disimpan";
        }
    }
    
}

