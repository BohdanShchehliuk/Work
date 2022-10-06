package airport;

import airport.exception.UserNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
       public static void main(String[] args) throws UserNotFoundException {
         SpringApplication.run(Main.class, args);
//           FlightRepository flightRepository =  context.getBean(FlightRepository.class);
//            System.out.println(flightRepository.findAll());

    }
}





//    @Bean
//    public CommandLineRunner run(ApplicationContext appContext) {
//        return args -> {
//            String[] beans = appContext.getBeanDefinitionNames();
//            Arrays.stream(beans).sorted().forEach(System.out::println);
//        };
//    }