package Tendry.e_upgrade.models;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String adress;
}
