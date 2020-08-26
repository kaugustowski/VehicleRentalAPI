package pl.wizyg.VehicleRental.rentals;

public class RentalsOverlapException extends Exception {

    public RentalsOverlapException() {
    }

    public RentalsOverlapException(String message) {
        super(message);
    }
}
