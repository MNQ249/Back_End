package com.Lebook.MesferAlQahtani.Entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Users")
@Validated
public class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nin")
    @NotNull(message = " ID is required ")
//    @Min(1000000000)
//    @Max(1999999999)
    private long nin;

    @NotNull(message = " user name is required ")
    @Column(name = "username")
    private String userName;

    @NotNull(message = "password is required")
//    @Size(min = 6, max = 16, message = " password must be between 8 to 16 character ")
    @Column(name = "Password")
    private String password;

    @NotNull(message = "first name is required")
    @Column(name = "f_name")
    private String firstName;

    @NotNull(message = "last name is required")
    @Column(name = "l_name")
    private String lastName;

    @NotNull(message = " Age is required")
    @Column(name = "Age")
    private int age;

    @NotNull(message = "city is required")
    @Column(name = "City")
    private String city;

    @NotNull(message = " email is required")
    @Column(name = "Email")
    @Email
    private String email;

    @NotNull(message = "gender is required ")
    @Column(name = "Gender")
    private String gender;

    @Column(name = "Enable")
    private boolean enable;

    @Column(name = "Phone")
    @NotNull(message = "phone is required")
    private String phone;

    @ManyToOne()
    @JoinColumn(name = "rolename",referencedColumnName = "rolename")
    private RolesEntity userroles;

    public UserEntity() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RolesEntity getUserroles() {
        return userroles;
    }

    public void setUserroles(RolesEntity userroles) {
        this.userroles = userroles;
    }
}