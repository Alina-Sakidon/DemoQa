package Conponents;

import lombok.Getter;
import lombok.Setter;

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
}
