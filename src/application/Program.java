package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("Testing find by id");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("Testing find by Department");
        Department dep = new Department(1, "Computers");
        List<Seller> seller1 = sellerDao.findByDepartment(dep);
        System.out.println(seller1);

        System.out.println("Testing Find All");
        List<Seller> seller2 = sellerDao.findAll();
        System.out.println(seller2);

    }
}
