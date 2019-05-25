/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontroller;

import java.util.List;
import models.Department;


public interface IDepartmentController {

    public List<Department> getAll();

    public Department getById(String id);

    public List<Department> search(Object keyword);

    public String save(String id, String name);
       
    public String delete(String id);

}
