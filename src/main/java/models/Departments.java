package models;

import java.util.List;
import java.util.Objects;

public class Departments {
    private int id;
    private String departmentName;
    private String departmentDescription;
    private int noOfEmployees;
    private List<Users> departmentUsers;
    private List<DepartmentNews> departmentNews;

    public Departments(String departmentName, String departmentDescription, int noOfEmployees) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.noOfEmployees = noOfEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {

        this.noOfEmployees = noOfEmployees;
    }

    public List<Users> getDepartmentUsers() {

        return departmentUsers;
    }

    public void setDepartmentUsers(List<Users> departmentUsers) {
        this.departmentUsers = departmentUsers;
    }

    public List<DepartmentNews> getDepartmentNews() {
        return departmentNews;
    }

    public void setDepartmentNews(List<DepartmentNews> departmentNews) {
        this.departmentNews = departmentNews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departments)) return false;
        Departments that = (Departments) o;
        return getId() == that.getId() &&
                getNoOfEmployees() == that.getNoOfEmployees() &&
                Objects.equals(getDepartmentName(), that.getDepartmentName()) &&
                Objects.equals(getDepartmentDescription(), that.getDepartmentDescription()) &&
                Objects.equals(getDepartmentUsers(), that.getDepartmentUsers()) &&
                Objects.equals(getDepartmentNews(), that.getDepartmentNews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartmentName(), getDepartmentDescription(), getNoOfEmployees(), getDepartmentUsers(), getDepartmentNews());
    }

}
