package airport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "flight_numb")
    private int flightNumb;
    private LocalDateTime time;
    @Column(name = "flight_status")
    private int flightStatus;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "avialine_id")
    private Airline airline;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "craft_id")
    private Aircraft aircraft;
    @Column(name = "gate_id")
    private int gateId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "routes_id")
    private Routes routes;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumb=" + flightNumb +
                ", time=" + time +
                ", flightStatus=" + flightStatus + '}';
    }
}
