package pl.wizyg.VehicleRental.rentals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wizyg.VehicleRental.customers.CustomerNotFoundException;
import pl.wizyg.VehicleRental.customers.CustomerService;
import pl.wizyg.VehicleRental.vehicles.Vehicle;
import pl.wizyg.VehicleRental.vehicles.VehicleNotFoundException;
import pl.wizyg.VehicleRental.vehicles.VehicleService;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class DefaultRentalServiceTest {

    DefaultRentalService rentalService;
    VehicleService vehicleService;
    RentalRepository rentalRepository;


    @BeforeEach
    void initialize() {

        vehicleService = mock(VehicleService.class);
        rentalRepository = mock(RentalRepository.class);

        rentalService = new DefaultRentalService(rentalRepository,
                vehicleService,
                mock(CustomerService.class));
    }

    @Test
    public void addingRental() throws VehicleNotFoundException, RentalsOverlapException, CustomerNotFoundException {
        //given there are some rental(s)

        int anyCustomerId = 1;
        int vehicleId = 1;
        Vehicle vehicle = someVehicleWithId(vehicleId);
        when(vehicleService.getVehicle(vehicleId)).thenReturn(vehicle);
        when(rentalRepository.findAllByVehicle_IdAndStartDateBeforeAndEndDateAfter(eq(vehicleId), any(), any()))
                .thenReturn(List.of(rentalForVehicle(vehicle)));
        //when overlapping rental is added
        var overlappingRental = RentalDTO.builder()
                .customerId(anyCustomerId)
                .vehicleId(vehicleId)
                .startDate(LocalDate.of(2020, 5, 1))
                .endDate(LocalDate.of(2020, 5, 3))
                .build();

        //then exception is thrown
        assertThatThrownBy(() -> rentalService.addRental(overlappingRental)).isInstanceOf(RentalsOverlapException.class);
    }

    private Rental rentalForVehicle(Vehicle vehicle) {
        return new Rental(null, null, null, null, vehicle);
    }

    private Vehicle someVehicleWithId(int vehicleId) {
        return new Vehicle() {

            @Override
            public int getTransportCost() {
                return 0;
            }

            @Override
            public Integer getId() {
                return vehicleId;
            }
        };
    }


}