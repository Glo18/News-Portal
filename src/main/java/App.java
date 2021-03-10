import com.google.gson.Gson;
import dao.Sql2oDepartmentNewsDao;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oGeneralNewsDao;
import dao.Sql2oUsersDao;
import exceptions.ApiException;
import models.DepartmentNews;
import models.Departments;
import models.GeneralNews;
import models.Users;
import org.sql2o.Sql2o;
import static spark.Spark.*;

import org.sql2o.Connection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main (String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        Sql2oDepartmentsDao DepartmentsDao;
        Sql2oDepartmentNewsDao DepartmentNewsDao;
        Sql2oGeneralNewsDao GeneralNewsDao;
        Sql2oUsersDao UsersDao;
        Connection conn;
        Gson gson = new Gson();

//        String connectionString =  ("jdbc:postgresql://localhost:5432/departments");
//
//        Sql2o sql2o = new Sql2o(connectionString, "glory", "myPassword");
//
        String connectionString = "jdbc:postgresql:ec2-52-7-115-250.compute-1.amazonaws.com:5432/d5ifsuri8km1nf";
        Sql2o sql2o = new Sql2o(connectionString, "xduyuntkawctuw", "b94bd3a40367f8c1352d95f137b0fe9c8de03c73e700cd2f29643bd99df59d16"); //!

        DepartmentsDao = new Sql2oDepartmentsDao(sql2o);
        DepartmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        GeneralNewsDao = new Sql2oGeneralNewsDao(sql2o);
        UsersDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();

        get("/", "application/json", (req, res) ->
                "{\"message\":\"Welcome to the organisation news application.\"}");

        post("/departments/new", "application/json", (req, res) -> {
            Departments departments = gson.fromJson(req.body(), Departments.class);
            DepartmentsDao.add(departments);
            res.status(201);
            return gson.toJson(departments);
        });

        post("/departmentNews/new", "application/json", (req, res) -> {
            DepartmentNews departmentNews = gson.fromJson(req.body(), DepartmentNews.class);
            DepartmentNewsDao.add(departmentNews);
            res.status(201);
            res.type("application/json");
            return gson.toJson(departmentNews);

        });

        post("/generalNews/new", "application/json", (req, res) -> {
            GeneralNews generalNews = gson.fromJson(req.body(), GeneralNews.class);
            GeneralNewsDao.add(generalNews);
            res.status(201);
            return gson.toJson(generalNews);
        });


        post("/users/new", "application/json", (req, res) -> {
            Users users = gson.fromJson(req.body(), Users.class);
            UsersDao.add(users);
            res.status(201);
            res.type("application/json");
            return gson.toJson(users);
        });

//        Read
        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(UsersDao.getAllUser());//send it back to be displayed
        });

        get("/departments", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DepartmentsDao.getAllDepartments());//send it back to be displayed
        });

        get("/departmentNews", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DepartmentNewsDao.getAllDepartmentNews());//send it back to be displayed
        });

        get("/generalNews", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(GeneralNewsDao.getAllGeneralNews());//send it back to be displayed
        });

        get("/users/:id", "application/json", (req, res) -> {
            int usersId = Integer.parseInt(req.params("id"));
            Users usersToFind = UsersDao.getUserById(usersId);

            if(usersToFind == null) {
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(usersToFind);
        });

        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int deparmentsId = Integer.parseInt(req.params("id"));
            Departments departmentsToFind = DepartmentsDao.getDepartmentsById(deparmentsId );
            if (departmentsToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentsToFind );
        });

//        get("/departmentNews/:departmentId", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            int deparmentNewsId = Integer.parseInt(req.params("id"));
//            DepartmentNews departmentsNewsToFind = DepartmentNewsDao.getDepartmentNewsById(deparmentNewsId );
//            if (departmentsNewsToFind== null){
//                throw new ApiException(404, String.format("No department news with the id: \"%s\" exists", req.params("id")));
//            }
//            return gson.toJson(departmentsNewsToFind );
//        });

        get("/departmentNews/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int deparmentNewsId = Integer.parseInt(req.params("id"));
            DepartmentNews departmentsNewsToFind = DepartmentNewsDao.getDepartmentNewsById(deparmentNewsId );
            if (departmentsNewsToFind== null){
                throw new ApiException(404, String.format("No department news with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentsNewsToFind );
        });

        get("/generalNews/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int generalNewsId = Integer.parseInt(req.params("id"));
            GeneralNews generalNewsToFind = GeneralNewsDao.getGeneralNewsById(generalNewsId );
            if (generalNewsToFind== null){
                throw new ApiException(404, String.format("No general news with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(generalNewsToFind );
        });

        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) -> {
            res.type("application/json");
        });
    }
}