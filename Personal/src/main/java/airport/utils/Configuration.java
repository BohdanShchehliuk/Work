package airport.utils;


import airport.service.PersonalService;
import airport.service.impl.PersonalServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public PersonalService personalServiceService() {

        return new PersonalServiceImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
