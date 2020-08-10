package pl.wizyg.VehicleRental.vehicles.industrial;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class RoadRoller extends IndustrialVehicle {

    private int rollerWidth;

    private int vibrationFrequency;

    private int weight;

}
