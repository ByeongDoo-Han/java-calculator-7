package calculator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        CalculatorController controller = new CalculatorController(service);
        controller.app();
    }
}
