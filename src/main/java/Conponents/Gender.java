package Conponents;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gender {
    private GenderType genderType;
    public Gender(GenderType genderType){
        this.genderType = genderType;
    }
}
