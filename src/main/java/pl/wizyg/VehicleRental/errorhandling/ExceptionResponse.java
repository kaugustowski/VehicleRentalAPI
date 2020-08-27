package pl.wizyg.VehicleRental.errorhandling;


public class ExceptionResponse {


    private final String message;
    private final long timestamp;

    public ExceptionResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
