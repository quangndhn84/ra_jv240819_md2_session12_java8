package ra.default_static_method;

public class Demo {
    public static void main(String[] args) {
        Car car = new Car();
        Motobike motobike = new Motobike();
        int hours = 10;
        System.out.printf("Giá thuê xe %s trong %d giờ là: %f\n", car.getVehicleName(), hours, car.renVehicle(hours));
        System.out.printf("Giá thuê xe %s trong %d giờ là: %f\n", motobike.getVehicleName(), hours, motobike.renVehicle(hours));

        String carCode = "DR123";
        String motobikeCode = "D1234";
        System.out.println("Validate car code: "+Vehicle.isValidCode(carCode));
        System.out.println("Validate motobikeCode: "+Vehicle.isValidCode(motobikeCode));
    }
}
