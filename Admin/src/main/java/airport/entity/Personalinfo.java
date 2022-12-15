package airport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Personalinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_personal")
    private Personal id_personal;
    private boolean married;
    private Date birthday;
    private String city;
}
