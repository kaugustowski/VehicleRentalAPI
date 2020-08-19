package pl.wizyg.VehicleRental.vehicles.road;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "motorcycle")
@JsonTypeName("motorcycle")
public class Motorcycle extends RoadVehicle {


}
