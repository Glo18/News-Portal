package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void instantiatesDepartmentsDetails() throws Exception{
//        Departments testDepartments = SetUpDepartments();
//        assertEquals("production", testDepartments.getDepartmentName());
//        assertEquals("valuation", testDepartments.getDepartmentDescription());
//        assertEquals(0, testDepartments.getNoOfEmployees());
//    }
//
//    @Test
//    public void  getDepartmentDescription() {
//        Departments testDepartments = SetUpDepartments();
//        assertEquals("valuation", testDepartments.getDepartmentDescription());
//    }
//
//    @Test
//    public void setId(){
//        Departments testDepartments = SetUpDepartments();
//        testDepartments.setId(4);
//        assertEquals(4,testDepartments.getId());
//    }

    public Departments SetUpDepartments() {
        return new Departments("production", "valuation", 0);

    }
}