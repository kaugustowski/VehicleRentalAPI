package pl.wizyg.VehicleRental.vehicles.road;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "motorcycle")
public class Motorcycle extends RoadVehicle {


}
