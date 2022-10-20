package airport.controller;

import airport.entity.Personal;
import airport.service.impl.PersonalServiceImpl;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PersonalControllerTest {
    @Autowired
    private PersonalServiceImpl personalService;

    @Autowired
    private ModelMapper mapperToDTO;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getPersonalByNumbPhone() throws Exception {
        Personal personal = personalService.getAll().get(0);
        int param = personal.getNumbPhone();
        RequestBuilder request = MockMvcRequestBuilders.get("/personal/getByPhoneNumber/")
                .param("numbPhone", String.valueOf(param));
        MvcResult result = mockMvc.perform(request).andReturn();
        String actualResponseBody = result.getResponse().getContentAsString();
        assertEquals(actualResponseBody, personal.toString());

    }
}