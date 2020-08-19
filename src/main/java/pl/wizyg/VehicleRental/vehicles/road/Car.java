package pl.wizyg.VehicleRental.vehicles.road;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@JsonTypeName("car")
public class Car extends RoadVehicle {

    private int numberOfSeats;

    private boolean isAirConditioned;


}
