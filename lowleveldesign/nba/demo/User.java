package code.lowleveldesign.nba.demo;

import java.util.HashMap;

public class User {
    String userName;
    String address;
    Integer salary;
    String id;
    String company;

    public User(String userName, String address, Integer salary, String id, String company) {
        this.userName = userName;
        this.address = address;
        this.salary = salary;
        this.id = id;
        this.company = company;
    }

    public HashMap<String, String> getKeyValue(){
        HashMap<String, String > hm = new HashMap<>();
        hm.put("userName", getUserName());
        hm.put("address", getAddress());
        hm.put("salary", getSalary().toString());
        hm.put("id", getId());
        hm.put("company", getCompany());
        hm.put("class", "User");
        return hm;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
