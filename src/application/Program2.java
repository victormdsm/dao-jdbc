package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.impl.DepartmentDaoJDBC;

import java.sql.Connection;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao dep = DaoFactory.createDeapartmentDao();

        System.out.println("Teste insert");
        Department obj = new Department();
        obj.setName("Mamonha");
        dep.insert(obj);
        System.out.println(obj.toString());

        System.out.println("Teste Update");
        Department obj2 = new Department(2, "Mamonhoite");
        dep.update(obj2);
        System.out.println(obj2);

        System.out.println("Teste delete");
        dep.deletById(5);

        System.out.println("Teste find id");
        Department depFind = dep.findById(3);
        System.out.println(depFind);

        System.out.println("Teste find all");
        List<Department> departments = dep.findAll();
        for (Department deps: departments)   {
            System.out.println(deps);
        }



    }
}
