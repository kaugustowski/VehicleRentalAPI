package pl.wizyg.VehicleRental.vehicles.industrial;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class ReachStacker extends IndustrialVehicle {

    @Column(name = "reach_m")
    private double reach;

    @Column(name = "lift_weight_kg")
    private int liftWeight;


}
