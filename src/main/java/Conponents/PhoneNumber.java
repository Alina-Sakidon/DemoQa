package Conponents;

import lombok.Getter;
import lombok.Setter;

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
}
