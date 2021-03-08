package models;

public class Users {
    private int id;
    private String username;
    private String userPosition;
    private String userRole;
    private int departmentId;

    public Users(String username, String userPosition, String userRole, int departmentId) {
        this.username = username;
        this.userPosition = userPosition;
        this.userRole = userRole;
        this.departmentId = departmentId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {

        this.userPosition = userPosition;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
