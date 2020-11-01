package pl.wizyg.VehicleRental.vehicles;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import pl.wizyg.VehicleRental.vehicles.industrial.Excavator;
import pl.wizyg.VehicleRental.vehicles.industrial.RoadRoller;
import pl.wizyg.VehicleRental.vehicles.industrial.TipperTruck;
import pl.wizyg.VehicleRental.vehicles.road.Car;
import pl.wizyg.VehicleRental.vehicles.road.Motorcycle;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({

        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = Motorcycle.class, name = "motorcycle"),
        @JsonSubTypes.Type(value = TipperTruck.class, name = "tipperTruck"),
        @JsonSubTypes.Type(value = Excavator.class, name = "excavator"),
        @JsonSubTypes.Type(value = RoadRoller.class, name = "roadRoller")
})
public abstract class Vehicle {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "daily_rental_price")
    private Integer dailyRentalPrice;
    @Column(name = "production_year")
    private Integer productionYear;


    public abstract int getTransportCost();
}
