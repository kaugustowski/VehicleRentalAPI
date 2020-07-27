package pl.wizyg.VehicleRental.rentals;

public class RentalNotFoundException extends Exception {

    public RentalNotFoundException() {
    }

    public RentalNotFoundException(String message) {
        super(message);
    }
}
