package dao;

import models.DepartmentNews;
import models.Departments;
import models.Users;

import java.util.List;

public interface DepartmentsDao {

    void add(Departments department);

    List<Departments> getAllDepartments();
    List<DepartmentNews>getDepartmentNewsById( int id);
    List<Users> getDepartmentUserById (int id);
    Departments getDepartmentsById(int id);

}
