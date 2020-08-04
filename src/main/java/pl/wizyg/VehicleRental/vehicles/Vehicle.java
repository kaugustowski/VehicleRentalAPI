package pl.wizyg.VehicleRental.vehicles;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "engine_volume")
    private int engineVolume;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "daily_rental_price")
    private int dailyRentalPrice;
    @Column(name = "production_year")
    private int productionYear;

    public abstract int getTransportCost();
}
