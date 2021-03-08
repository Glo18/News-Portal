package dao;

import models.DepartmentNews;
import models.Departments;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentsDao implements DepartmentsDao{
    private final Sql2o sql2o;

    public Sql2oDepartmentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Departments departments) {
        String sql ="INSERT INTO departments (departmentname, departmentdescription, noofemployees) VALUES (:departmentname, :departmentdescription, :noofemployees )";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .addParameter("departmentname", departments.getDepartmentName())
                    .addParameter("departmentdescription",departments.getDepartmentDescription())
                    .addParameter("noofemployees", departments.getNoOfEmployees())
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        }
    }

    @Override
    public List<Departments> getAllDepartments() {
        String sql = "SELECT * FROM departments";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql, true)
                    .executeAndFetch(Departments.class);
        }catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public List<DepartmentNews> getDepartmentNewsById(int id) {
        String sql = "SELECT * FROM news WHERE departmentId= :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(DepartmentNews.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public List<Users> getDepartmentUserById(int id) {
        String sql = "SELECT * FROM users WHERE departmentId= :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Users.class);
        }catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public Departments getDepartmentsById(int id) {
        String sql = "SELECT * FROM departments WHERE id = :id";
        try (Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }
}