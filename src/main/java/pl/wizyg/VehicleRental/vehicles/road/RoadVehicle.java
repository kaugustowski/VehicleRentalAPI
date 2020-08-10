package pl.wizyg.VehicleRental.vehicles.road;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.wizyg.VehicleRental.vehicles.Vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public abstract class RoadVehicle extends Vehicle {

    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "engine_volume")
    private int engineVolume;
    @Column(name = "engine_power")
    private int enginePower;

    @Override
    public int getTransportCost() {
        return 0;
    }
}
