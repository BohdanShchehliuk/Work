package airport.dto;
import airport.entity.Routes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int flightId;
    private int seat;
    private PassengerDto passengerDto;
    private int ticketStaus;
    private Routes routes;

    private TicketDto creteTicket(PassengerDto passengerDto, int flightIdFromClient, int seatFromClient) {

        return TicketDto.builder()
                .flightId(flightIdFromClient)
                .seat(seatFromClient)
                .ticketStaus(1)
                .passengerDto(passengerDto)
                .build();

    }
}
