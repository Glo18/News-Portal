package dao;

import models.DepartmentNews;
import models.Departments;
import models.GeneralNews;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oGeneralNewsDaoTest {

    private Connection conn;
    private Sql2oGeneralNewsDao GeneralNewsDao;
    private Sql2oDepartmentNewsDao DepartmentsNewsDao;

    private static  Sql2o sql2o;

    @Before
    public void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/departments_test";
//        Sql2o sql2o = new Sql2o(connectionString, "glory", "myPassword");
        String connectionString = "jdbc:postgresql:ec2-54-161-239-198.compute-1.amazonaws.com:5432/d9j6jroneg559t";
        Sql2o sql2o = new Sql2o(connectionString, "ahuslgcsjuxarg", "5f124b5ec87bb953f6bcca9f220aaa67310c1816523f5984964238ced08b56d3");
        GeneralNewsDao = new Sql2oGeneralNewsDao(sql2o);
//        DepartmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        conn = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void addingGeneralNewsSetsId() throws Exception {
//        GeneralNews testGeneralNews = setupNewGeneralNews();
//        int originalGeneralNewsId = testGeneralNews.getId();
//        GeneralNewsDao.add(testGeneralNews);
//        assertNotEquals(originalGeneralNewsId ,testGeneralNews.getId());
//    }


    //helper
    public GeneralNews setupNewGeneralNews(){
        return new GeneralNews ("Psychology", "Mental wellness", "Glory");
    }
}