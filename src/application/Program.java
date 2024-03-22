package application;

import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;

        Department obj = new Department(1, "books");
        System.out.println(obj);

        Seller seller = new Seller(1, "joao", "joao@hotmail.com", new Date(), 3000.0, obj);

        System.out.println(seller);
    }
}
