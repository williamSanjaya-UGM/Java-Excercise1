package validation;

import validation.CustomerRegisValidator.*;

import java.util.*;

import static validation.CustomerRegisValidator.isEmailValid;
import static validation.CustomerRegisValidator.isPhoneNumberValid;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please input your name: ");
        String name = scanner.next();
        System.out.print("Please input your phone number: ");
        String phoneNumber=scanner.next();
        System.out.print("Please input your email: ");
        String email=scanner.next();

        Customer customer = new Customer(name,phoneNumber,email);

        ValidationResult result= isEmailValid()
                .and(isPhoneNumberValid())
                .apply(customer);

        System.out.println(result+" "+customer);

        if(result!=ValidationResult.SUCCESS){
            throw new IllegalMonitorStateException(result.name());
        }
    }
}
