package validation;

import java.util.function.Function;
import validation.CustomerRegisValidator.*;

import static validation.CustomerRegisValidator.ValidationResult.*;

public interface CustomerRegisValidator extends Function<Customer, ValidationResult> {

    static CustomerRegisValidator isEmailValid(){
        String regex="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return customer -> customer.getEmail().matches(regex)?SUCCESS:EMAIL_NOT_VALID;
    }

    static CustomerRegisValidator isPhoneNumberValid(){
        return customer -> {
            String phoneNumber =customer.getPhoneNumber();
            if(phoneNumber.startsWith("+62")&&customer.getPhoneNumber().length()>=11){
                return validationCheck(phoneNumber);
            }else if(phoneNumber.startsWith("0")&&customer.getPhoneNumber().length()>=10) {
                return validationCheck(phoneNumber.replaceFirst("0", "+62"));
            }else
                return PHONE_NUMBER_NOT_VALID;
        };
    }

    private static ValidationResult validationCheck(String phoneNumber){
        if(phoneNumber.substring(3).matches("[0-9]+")){
            return SUCCESS;
        }else{
            System.out.println("failed "+phoneNumber);
            return PHONE_NUMBER_NOT_VALID;
        }
    }

    default CustomerRegisValidator and(CustomerRegisValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS)?other.apply(customer):result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID
    }
}
