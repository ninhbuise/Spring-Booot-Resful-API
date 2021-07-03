package com.example.RestAPI.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    private int id;
    @NotBlank
    @Size(min=3, max = 30)
    private String last_name;
    @NotBlank
    @Size(min=3, max = 30)
    private String first_name;
    @NotBlank
    @Size(min=2, max = 30)
    private String department;
    @NotBlank
    @Size(min=2, max = 30)
    private String job_title;
    private Date birthday;
    @Email
    private String email;
    //this matches either empty string or 9-11 digits number.
    @Pattern(regexp="(^$|[0-9]{9,11})")
    private String phone;
}
