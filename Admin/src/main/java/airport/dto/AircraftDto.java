package airport.dto;

import airport.entity.Aircraft;
import airport.entity.AircraftTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AircraftDto {

    private int serialNumber;
    private AircraftTypes aircraftTypes;

    public Aircraft createAircraft() {
        return Aircraft.builder()
                .serialNumber(this.serialNumber)
                .build();
    }
}
