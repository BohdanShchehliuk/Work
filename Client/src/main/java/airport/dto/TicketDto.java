package airport.dto;

import airport.entity.Routes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDto {

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
