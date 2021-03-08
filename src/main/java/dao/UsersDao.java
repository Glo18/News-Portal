package dao;

import models.Users;

import java.util.List;

public interface UsersDao {
    void add(Users users);

    List<Users> getAllUser();
    Users getUserById(int id);
}
