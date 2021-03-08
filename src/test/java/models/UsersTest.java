package models;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsersTest  {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesUsersDetails() throws Exception{
        Users testUsers = setUpUsers();
        assertEquals("Steve", testUsers.getUsername());
        assertEquals("Accountant", testUsers.getUserPosition());
        assertEquals("Accounting", testUsers.getUserRole());
        assertEquals(0, testUsers.getDepartmentId());

    }
}