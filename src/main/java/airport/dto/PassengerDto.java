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

 public Passenger fromDTOToPassenger(PassengerDto requestPassengerDto) {
        return Passenger.builder()
                .name(requestPassengerDto.getName())
                .passport(requestPassengerDto.passport)
                .surname(requestPassengerDto.getSurname())
                .birthdate(requestPassengerDto.getBirthdate())
                .build();
 }

 public PassengerDto fromPassengerToDTO (Passenger passenger) {
        return PassengerDto.builder()
                .name(passenger.getName())
                .surname(passenger.getSurname())
                .passport(passenger.getPassport())
                .birthdate(passenger.getBirthdate())
                .build();
 }
}
