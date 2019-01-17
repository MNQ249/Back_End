package com.Lebook.MesferAlQahtani.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ROLES")
public class RolesEntity {

//    @Id
//    @GeneratedValue(strategy =GenerationType.IDENTITY)
//    @Column(name = "R_id")
//    private  long roleID;
    @Id
    @Column(name = "rolename")
    @Size(max = 15)
    private String rolename;


    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
