package pl.wizyg.VehicleRental.vehicles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class DefaultVehicleServiceTest {

    DefaultVehicleService vehicleService;
    VehicleRepository vehicleRepository;


    @BeforeEach
    void initialize() {

        vehicleRepository = mock(VehicleRepository.class);

        vehicleService = new DefaultVehicleService(vehicleRepository, null, null);

        when(vehicleRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

    }

    @Test
    void updateVehicleShouldThrowException() throws VehicleNotFoundException {

        //given there is no Vehicle with specified Id

        int vehicleId = 1;

        // when its being updated with any data

        Vehicle someVehicleData = someVehicleData();

        //then exception is thrown

        assertThatThrownBy(() -> vehicleService.updateVehicle(vehicleId, someVehicleData)).isInstanceOf(VehicleNotFoundException.class);
    }

    private Vehicle someVehicleData() {
        return new Vehicle() {

            @Override
            public int getTransportCost() {
                return 0;
            }
        };

    }


    @ParameterizedTest
    @ValueSource(strings = {"Car", "Motorcycle", "Excavator", "RoadRoller", "ReachStacker", "TipperTruck"})
    void updateVehicleWithModelAndDailyRentalPrice(String type) throws VehicleNotFoundException {

        //given there is a Vehicle with specified Id

        Vehicle originalVehicle = VehicleFactory.createVehicle(type);
        originalVehicle.setMake("Make");
        originalVehicle.setModel("Model");
        originalVehicle.setProductionYear(2015);
        originalVehicle.setDailyRentalPrice(100);

        int vehicleId = 1;
        //TODO
        when(vehicleRepository.findById(vehicleId)).thenReturn(Optional.of(originalVehicle));

        // when its being updated

        Vehicle someVehicleData = vehicleDataWithModelAndDailyRentalPrice();
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicleId, someVehicleData);

        //then fields are modified

        assertThat(updatedVehicle.getMake()).isEqualTo(originalVehicle.getMake());
        assertThat(updatedVehicle.getModel()).isEqualTo("NewModel");
        assertThat(updatedVehicle.getDailyRentalPrice()).isEqualTo(150);
        assertThat(updatedVehicle.getProductionYear()).isEqualTo(originalVehicle.getProductionYear());

    }


    private Vehicle vehicleDataWithModelAndDailyRentalPrice() {
        return new Vehicle() {

            @Override
            public String getModel() {
                return "NewModel";
            }

            @Override
            public Integer getDailyRentalPrice() {
                return 150;
            }

            @Override
            public int getTransportCost() {
                return 0;
            }
        };
    }

    @ParameterizedTest
    @ValueSource(strings = {"Car", "Motorcycle", "Excavator", "RoadRoller", "ReachStacker", "TipperTruck"})
    void updateVehicleWithMakeAndModel(String type) throws VehicleNotFoundException {

        //given there is no Vehicle with specified Id
        //TODO


        Vehicle originalVehicle = VehicleFactory.createVehicle(type);
        originalVehicle.setMake("Make");
        originalVehicle.setModel("Model");
        originalVehicle.setProductionYear(2015);
        originalVehicle.setDailyRentalPrice(100);
        int vehicleId = 1;
        when(vehicleRepository.findById(vehicleId)).thenReturn(Optional.of(originalVehicle));

        // when its being updated

        Vehicle someVehicleData = vehicleDataWithMakeAndModel();
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicleId, someVehicleData);

        //then fields are modified

        assertThat(updatedVehicle.getMake()).isEqualTo("NewMake");
        assertThat(updatedVehicle.getModel()).isEqualTo("NewModel");
        assertThat(updatedVehicle.getDailyRentalPrice()).isEqualTo(originalVehicle.getDailyRentalPrice());
        assertThat(updatedVehicle.getProductionYear()).isEqualTo(originalVehicle.getProductionYear());

    }

    private Vehicle vehicleDataWithMakeAndModel() {
        return new Vehicle() {

            @Override
            public String getMake() {
                return "NewMake";
            }

            @Override
            public String getModel() {
                return "NewModel";
            }


            @Override
            public int getTransportCost() {
                return 0;
            }
        };
    }
}