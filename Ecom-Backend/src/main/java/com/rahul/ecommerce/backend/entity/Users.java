package com.rahul.ecommerce.backend.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "get  user details with only values", columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "email", type = String.class),
                @ColumnResult(name = "password", type = String.class)

        }),

        @SqlResultSetMapping(name = "get all user details with column names",
                entities = {
                        @EntityResult(
                                entityClass = Users.class,
                                fields = {
                                        @FieldResult(name = "id", column = "ID"),
                                        @FieldResult(name = "name", column = "NAME"),
                                        @FieldResult(name = "email", column = "EMAIL"),
                                        @FieldResult(name = "password", column = "PASSWORD")
                                })
                })

})
@NamedNativeQueries(
@NamedNativeQuery(name="get all user details",query = "select * from users",resultSetMapping ="get all user details with column names" )
)

@Entity
@Data
@Table(name="USERS")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private  String password;

    public Users() {
    }

    public Users(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
