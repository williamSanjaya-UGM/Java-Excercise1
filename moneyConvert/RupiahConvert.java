package moneyConvert;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class RupiahConvert {
    public static void main(String[] args) {
        System.out.print("Put your number you want to convert to rupee: ");
        Scanner scanner = new Scanner(System.in);
        String inputRupee = scanner.next();

        Double rupiah;
        rupiah=Double.parseDouble(inputRupee);

        Locale localeID = new Locale("in","ID");
        NumberFormat formatRupee=NumberFormat.getCurrencyInstance(localeID);
        System.out.println(formatRupee.format(rupiah));
    }
}
