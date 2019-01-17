package com.Lebook.MesferAlQahtani.DTO.EntityDTO;


import com.Lebook.MesferAlQahtani.Entity.RolesEntity;
import org.hibernate.validator.constraints.UniqueElements;


import javax.validation.constraints.*;

public class UserDTO {

    @NotNull(message = "ID is required")
//    @Min(1000000000)
//    @Max(1999999999)
    private long nin;


    @NotNull(message = "user name is required")
    private String userName;

    @NotNull(message = "password is required")
//    @Size(min = 6, max = 16, message = "your password must be between 6 to 16")
    private String password;

    @NotNull(message = "first name is required")
    private String firstName;

    @NotNull(message = "last name is required")
    private String lastName;

    @NotNull(message = "Age is required ")
    private int age;

    @NotNull(message = "city is required")
    private String city;

    @NotNull(message = "write your email")
    @Email
    private String email;

    @NotNull(message = "gender is required")

    private String gender;
    @NotNull(message = "phone is required")
    private String phone;

    private RolesEntity userroles;

    private String role;

    public RolesEntity getUserroles() {
        return userroles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getNin() {
        return nin;
    }

    public void setNin(long nin) {
        this.nin = nin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserroles(RolesEntity userroles) {
        this.userroles = userroles;
    }
}
