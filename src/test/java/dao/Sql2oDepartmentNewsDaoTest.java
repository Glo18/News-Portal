package dao;

import models.DepartmentsNews;
import models.GeneralNews;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentNewsDaoTest {

    private Connection conn;
    private Sql2oGeneralNewsDao GeneralNewsDao;
    private Sql2oDepartmentNewsDao DepartmentsNewsDao;

    private static  Sql2o sql2o;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/departments_test";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Nya2rango@");
        GeneralNewsDao = new Sql2oGeneralNewsDao(sql2o);
        DepartmentsNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        conn = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addingGeneralNewsSetsId() throws Exception {
        DepartmentsNews testDepartmentNews = setupNewDepartmentNews();
        int originalDepartNewsId = testDepartmentNews.getId();
        DepartmentNewsDao.add(testDepartmentNews);

        assertNotEquals(originalDepartNewsId ,testDepartmentNews.getId());
    }

    //  helper
    public DepartmentsNews setupNewDepartmentNews(){
        return new DepartmentsNews (0,"Budgeting", "Expenditure", "Baraka");
    }
}