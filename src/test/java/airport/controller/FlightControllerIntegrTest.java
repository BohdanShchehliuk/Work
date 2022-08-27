package airport.controller;

import airport.Main;
import airport.entity.Flight;
import airport.repository.FlightRepository;
import airport.service.impl.FlightServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


//@SpringBootTest(classes = FlightController.class,
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FlightControllerIntegrTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    FlightRepository flightRepository;
 //   Optional<Flight> flight =flightRepository.findById(1);

    @Test
    void saveFlight() throws Exception {
//      RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/flight/create/");
//       MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//     assertEquals(flight.get().getFlightNumb(),result.getResponse().getContentAsString());
    }


}