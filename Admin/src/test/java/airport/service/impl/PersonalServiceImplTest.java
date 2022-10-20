package airport.service.impl;

import airport.Main;
import airport.entity.Personal;
import airport.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = Main.class)
class PersonalServiceImplTest {
    @Autowired
   PersonalServiceImpl personalService;



    @Test
    void getPersonalByGate() throws UserNotFoundException {

        Personal personal = personalService.getAll().stream().findAny().get();
        int personalNumbGate = personal.getGate().getNumberofgate();
       List <Personal> respond = personalService.getPersonalByGate(personalNumbGate);
        List <Personal> personalList = personalService.getAll().stream().filter(personal1 -> personal1.getGate().getNumberofgate()==
                personalNumbGate).collect(Collectors.toList());
                assertEquals(personalList, respond);
    }
 }