package airport.controller;

import airport.entity.Ticket;
import airport.service.impl.TicketServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TicketControllerTest {
    @Autowired
    private TicketServiceImpl ticketService;
    @Autowired
    MockMvc mockMvc;


    @Test
    void getAllByFlightNumb() throws Exception {

        List<Ticket> ticketList = ticketService.getAll();
        int flightNumber = ticketList.get(1).getFlightId().getFlightNumb();
        List<Ticket> ticketListWithCheckedFlightNumber = ticketList
                .stream()
                .filter(ticket -> ticket.getFlightId().getFlightNumb() == flightNumber).collect(Collectors.toList());
        String param = Integer.toString(flightNumber);
        RequestBuilder request = MockMvcRequestBuilders.get("/tickets/by/flight/")
                .param("flightNumb", param);
        MvcResult result = mockMvc.perform(request).andReturn();
        String actualResponseBody = result.getResponse().getContentAsString();
        assertEquals(actualResponseBody, ticketListWithCheckedFlightNumber.toString());
    }
}

