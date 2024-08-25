package dev.vimukthi.sentura_interview.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
@Entity
public class UserEntity{
    @Id
    private String uId;
    @Column(unique = true)
    private String email;
    private String givenName;
    private String middleName;
    private String familyName;
    private String name;
    private String nickName;
    @Column(unique = true)
    private String phoneNumber;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
}
