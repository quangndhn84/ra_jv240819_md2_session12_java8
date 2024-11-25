package ra.default_static_method;

public class Motobike implements Vehicle {
    @Override
    public String getVehicleName() {
        return "Motobike";
    }

    @Override
    public double renVehicle(int hours) {
        return hours * 8;
    }
}
