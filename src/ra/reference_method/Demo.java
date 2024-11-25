package ra.reference_method;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> listString = Arrays.asList("Car", "Motobike", "Bicycle");
//        for (String str : listString) {
//            ReferenceMethod.upperCaseName(str);
//        }
        listString.forEach(ReferenceMethod::upperCaseName);
    }
}
