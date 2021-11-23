package Conponents;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return fullName.equals(user.fullName) && phoneNumber.equals(user.phoneNumber) && gender.equals(user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber, gender);
    }
}
