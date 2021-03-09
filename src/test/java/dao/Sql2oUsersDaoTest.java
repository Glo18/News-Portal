package dao;
import models.Departments;
import models.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUsersDaoTest {

    private Connection conn;
    private Sql2oUsersDao UsersDao;
    private Sql2oDepartmentsDao DepartmentsDao;

    private static  Sql2o sql2o;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/departments_test";
        Sql2o sql2o = new Sql2o(connectionString, "glory", "myPassword");
        UsersDao = new Sql2oUsersDao(sql2o);
        DepartmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addingUserSetsId() throws Exception {
        Users testUsers = setupNewUser();
        int originalUsersId = testUsers.getId();
        UsersDao.add(testUsers);
        assertNotEquals(originalUsersId,testUsers.getId());
    }

    public Users setupNewUser(){
        return new Users("Cate", "Software Developer", "Programming", 0);
    }

}