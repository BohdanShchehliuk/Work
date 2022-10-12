package airport.controller;

import airport.dto.PassengerDto;
import airport.entity.Passenger;
import airport.service.impl.PassengerServiceImpl;
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

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PassengerControllerTest {
    @Autowired
    private PassengerServiceImpl passengerService;
    @Autowired
    private ModelMapper mapperToDTO;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getByPassport() throws Exception {
        Passenger passenger = passengerService.getAll().get(0);
        String param = passenger.getPassport();
        PassengerDto passengerDto = mapperToDTO.map(passenger, PassengerDto.class);
        RequestBuilder request = MockMvcRequestBuilders.get("/passenger/getbypassport/")
                .param("passport", param);
        MvcResult result = mockMvc.perform(request).andReturn();
        String actualResponseBody = result.getResponse().getContentAsString();
        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(passengerDto));
    }
}
