package airport.controller;

import airport.dto.FlightDto;
import airport.entity.Flight;
import airport.service.impl.FlightServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FlightControllerTest {
    @Autowired
    private FlightServiceImpl flightService;
    @Autowired
    private ModelMapper mapperToDTO;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getByNumber() throws Exception {

        List<Flight> flightList = flightService.getAll();
        Flight flight = flightList.get(0);
        int flightNumb = flight.getFlightNumb();
        String param = Integer.toString(flightNumb);
        FlightDto flightDto = mapperToDTO.map(flight, FlightDto.class);
        RequestBuilder request = MockMvcRequestBuilders.get("/flight/getInfoAboutFlightByFlightNumb/")
                .param("flightNumb", param);
        MvcResult result = mockMvc.perform(request).andReturn();
        String actualResponseBody = result.getResponse().getContentAsString();
        assertThat
                (actualResponseBody).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(flightDto));
    }

    @Test
    void getAllFlights() throws Exception {
        List<Flight> flightList = flightService.getAll();
        RequestBuilder request = MockMvcRequestBuilders.get("/flight/getAllFlights/");
        MvcResult result = mockMvc.perform(request).andReturn();
        String actualResponseBody = result.getResponse().getContentAsString();
        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(flightList));
    }
}
