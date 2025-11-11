package project.HackHustle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_details")
public class UserDetails
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "uid", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Column(name = "password", nullable = false)
    private String password;
}
