package pl.wizyg.VehicleRental.vehicles.industrial;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class TipperTruck extends IndustrialVehicle {

    private int loadWeight;

    private int loadVolume;


}
