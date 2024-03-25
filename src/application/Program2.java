package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.impl.DepartmentDaoJDBC;

import java.sql.Connection;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao dep = DaoFactory.createDeapartmentDao();
    }
}
