package pl.wizyg.VehicleRental.vehicles.road;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.wizyg.VehicleRental.vehicles.Vehicle;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class RoadVehicle extends Vehicle {


    @Override
    public int getTransportCost() {
        return 0;
    }
}
