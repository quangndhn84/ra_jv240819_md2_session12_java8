package ra.default_static_method;

import java.util.regex.Pattern;

public interface Vehicle {
    String getVehicleName();

    //Default method: phương thức thực thi có trong Interface
    default double renVehicle(int hours) {
        return hours * 10;
    }

    static boolean isValidCode(String code) {
        String codeRegex = "DR\\d{3}";
        if (Pattern.matches(codeRegex, code)) {
            return true;
        }
        return false;
    }
}
