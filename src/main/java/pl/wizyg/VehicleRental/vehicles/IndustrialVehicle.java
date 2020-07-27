package pl.wizyg.VehicleRental.vehicles;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class IndustrialVehicle extends Vehicle {

    @Column(name = "transport_cost")
    private int transportCost;
}
