package pl.wizyg.VehicleRental.vehicles.industrial;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.wizyg.VehicleRental.vehicles.Vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class IndustrialVehicle extends Vehicle {

    @Column(name = "transport_cost")
    private int transportCost;

    @Column(name = "mass_kg")
    private int massKg;
}
