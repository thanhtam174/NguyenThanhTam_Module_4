package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 5, max = 45, message = "So ky tu năm trong khoang tu 5 den 45 ky tu")
    private String firstName;

    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 5, max = 45, message = "So ky tu năm trong khoang tu 5 den 45 ky tu")
    private String lastName;

    @Min(value = 18, message = "Phai lon hon hoac bang 18")
    private String age;

    @Email(message = "phai dung dinh dang abc@abc.abc")
    private String email;

    public User() {
    }

    public User
            (
                    Long id, @NotBlank(message = "Khong duoc de trong") @Size(min = 5, max = 45,
                    message = "So ky tu năm trong khoang tu 5 den 45 ky tu") String firstName,
                    @NotBlank(message = "Khong duoc de trong")
                    @Size(min = 5, max = 45, message = "So ky tu năm trong khoang tu 5 den 45 ky tu") String lastName,
                    @Min(value = 18, message = "Phai lon hon hoac bang 18") String age,
                    @Email(message = "phai dung dinh dang abc@abc.abc") String email
            ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
