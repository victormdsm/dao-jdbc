package model.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO department (name) values (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getName());
            int rows = ps.executeUpdate();
            if(rows>0) {
                System.out.println("Rows affected: " + rows);
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) {
                    obj.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE department SET name=? WHERE id=?");
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(ps);
        }

    }

    @Override
    public void deletById(Integer id) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM department WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM department WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                return instantiateDepartment(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
        return null;
    }

    public Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department(rs.getInt("id"), rs.getString("Name"));
        return dep;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM department");
            rs = ps.executeQuery();
            List<Department> departments = new ArrayList<>();
            while (rs.next()) {
                Department dep = instantiateDepartment(rs);
                departments.add(dep);
            }
            return departments;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
        return null;
    }
}
