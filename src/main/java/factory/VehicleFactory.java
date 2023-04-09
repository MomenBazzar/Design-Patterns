package factory;

public class VehicleFactory {
    public Vehicle getVehicleOfType(VehicleType type){

        if (type == VehicleType.CAR) return new Car();
        if (type == VehicleType.TRUCK) return new Truck();
        if (type == VehicleType.BUS) return new Bus();

        throw new IllegalArgumentException("Invalid vehicle type.");
    }
}

