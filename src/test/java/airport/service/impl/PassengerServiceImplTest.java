package airport.service.impl;

import airport.exception.UserNotFoundException;
import airport.repository.PassengerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(PassengerServiceImpl.class)
class PassengerServiceImplTest {


    @MockBean
    PassengerServiceImpl passengerService;

    @Test
    void delete() throws UserNotFoundException {

        String respond = passengerService.delete("SO1234");
        assertEquals("Passenger successfully deleted", respond);
    }
}