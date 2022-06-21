package airport;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.modelmapper.ModelMapper;

@Builder
@SpringBootApplication
@Data
public class Main {
    private ModelMapper modelMapper;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}




