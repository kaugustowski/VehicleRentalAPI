package pl.wizyg.VehicleRental.vehicles;

import pl.wizyg.VehicleRental.vehicles.industrial.Excavator;
import pl.wizyg.VehicleRental.vehicles.industrial.ReachStacker;
import pl.wizyg.VehicleRental.vehicles.industrial.RoadRoller;
import pl.wizyg.VehicleRental.vehicles.industrial.TipperTruck;
import pl.wizyg.VehicleRental.vehicles.road.Car;
import pl.wizyg.VehicleRental.vehicles.road.Motorcycle;

public class VehicleFactory {

    public static Vehicle createVehicle(String type) {
        if (type.equals("Car"))
            return new Car();
        if (type.equals("Motorcycle"))
            return new Motorcycle();
        if (type.equals("RoadRoller"))
            return new RoadRoller();
        if (type.equals("Excavator"))
            return new Excavator();
        if (type.equals("ReachStacker"))
            return new ReachStacker();
        if (type.equals("TipperTruck"))
            return new TipperTruck();
        return null;
    }
}
