package airport.dto;


import airport.entity.Aircraft;
import airport.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {
    private int flightNumb;
    private int flightStatus;
    private LocalDateTime time;
    private Aircraft aircraft;

    public Flight creteFlight() {
        return Flight.builder()
                .flightNumb(this.flightNumb)
                .flightStatus(this.flightStatus)
                .aircraft(this.aircraft)
                .time(this.time)
                .build();
    }
//    {
//        "flightNumb": 12121,
//            "flightStatus": 1,
//            "aircraft": {
//        "id": 0,
//                "serialNumber": 0,
//                "airline": null,
//                "aircraftTypes": {
//            "id": 0,
//                    "produser": "Nokia",
//                    "type": null,
//                    "capacity": 300
//        }
//    }
//    }
}
