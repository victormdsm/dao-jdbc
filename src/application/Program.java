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
        List<Seller> sellers = sellerDao.findByDepartment(dep);
        for(Seller obj: sellers) {
            System.out.println(obj);
        }

        System.out.println("Testing Find All");
        List<Seller> sellers2 = sellerDao.findAll();
        for(Seller obj: sellers2) {
            System.out.println(obj);
        }

        System.out.println("Insert Seller");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted: " + newSeller);

        System.out.println("Seller update");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
    }
}
