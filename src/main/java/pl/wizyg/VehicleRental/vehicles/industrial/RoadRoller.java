package pl.wizyg.VehicleRental.vehicles.industrial;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "road_roller")
@JsonTypeName("car")
public class RoadRoller extends IndustrialVehicle {

    private int rollingForce;
}
