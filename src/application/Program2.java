package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.impl.DepartmentDaoJDBC;

import java.sql.Connection;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao dep = DaoFactory.createDeapartmentDao();

        System.out.println("Teste insert");
        Department obj = new Department();
        obj.setName("Mamonha");
        dep.insert(obj);
        System.out.println(obj.toString());

    }
}
