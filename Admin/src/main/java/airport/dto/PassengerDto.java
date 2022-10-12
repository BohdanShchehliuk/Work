package airport.dto;

import airport.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerDto {

    private String passport;
    private String surname;
    private String name;
    private Date birthdate;

    public Passenger createPassenger() {

        return Passenger.builder()
                .birthdate(this.birthdate)
                .passport(this.passport)
                .name(this.name)
                .surname(this.surname)
                .build();
    }
}
