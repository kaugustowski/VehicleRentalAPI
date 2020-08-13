package pl.wizyg.VehicleRental.vehicles.road;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Car extends RoadVehicle {

    private int numberOfSeats;

    private boolean isAirConditioned;


}
