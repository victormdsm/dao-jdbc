package application;

import model.entities.Department;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;

        Department obj = new Department(1, "books");
        System.out.println(obj);

    }
}
