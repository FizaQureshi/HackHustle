package project.HackHustle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_details")
public class UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uid", nullable = false)
    private String uid;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email_id;

    @Column(name = "password", nullable = false)
    private String password;
}
