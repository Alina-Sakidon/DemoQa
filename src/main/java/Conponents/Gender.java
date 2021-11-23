package Conponents;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Gender {
    private GenderType genderType;
    public Gender(GenderType genderType){
        this.genderType = genderType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return genderType == gender.genderType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderType);
    }
}
