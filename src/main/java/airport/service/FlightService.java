package airport.service;

import airport.dto.FlightDto;
import airport.entity.Flight;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flight addFlight(Flight flight);
   List<Flight> getAll();
   List<FlightDto> getAllFomDataAtoDataB(LocalDate startData, LocalDate finishData);



}
