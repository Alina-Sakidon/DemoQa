package Conponents;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private final FullName fullName;
    private final PhoneNumber phoneNumber;
    private final Gender gender;

    public User(FullName fullName, PhoneNumber phoneNumber, Gender gender){
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}
