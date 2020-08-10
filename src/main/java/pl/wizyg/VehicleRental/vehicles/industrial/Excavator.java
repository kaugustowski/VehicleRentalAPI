package pl.wizyg.VehicleRental.vehicles.industrial;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "excavator")
public class Excavator extends IndustrialVehicle {

    private int maxDiggindDepth;

    private int diggingForce;


}
