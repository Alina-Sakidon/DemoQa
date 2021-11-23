package Conponents;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class PhoneNumber {
    private String countryCode;
    private String operatorCode;
    private String abonentNumber;

    public PhoneNumber(String countryCode, String operatorCode, String abonentNumber){
        this.countryCode =countryCode;
        this.operatorCode = operatorCode;
        this.abonentNumber = abonentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return countryCode.equals(that.countryCode) && operatorCode.equals(that.operatorCode) && abonentNumber.equals(that.abonentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, operatorCode, abonentNumber);
    }
}
