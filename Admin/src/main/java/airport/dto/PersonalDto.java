package airport.dto;


import airport.entity.Personal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalDto {
    private String name;
    private int numbPhone;


    public Personal cretePersonal() {
        return Personal.builder()
                .name(this.name)
                .numbPhone(this.numbPhone)
                .build();
    }
}
