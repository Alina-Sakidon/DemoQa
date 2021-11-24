package Conponents;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class FullName {
    private final String firstName;
    private final String lastName;

    public FullName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString(){
        return firstName +" "+lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return firstName.equals(fullName.firstName) && lastName.equals(fullName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
