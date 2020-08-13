package pl.wizyg.VehicleRental.vehicles.industrial;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "tipper_truck")
public class TipperTruck extends IndustrialVehicle {

    private int loadWeight;

    private int loadVolume;


}
