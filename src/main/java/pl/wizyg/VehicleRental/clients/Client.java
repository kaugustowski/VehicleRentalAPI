package pl.wizyg.VehicleRental.clients;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id()
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    @Email
    private String email;

}
