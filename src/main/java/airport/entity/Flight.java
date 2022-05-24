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
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "flight_numb")
    private int flightNumb;
    private Date time;
    @Column(name = "flight_status")
    private int flightStatus;
    @ManyToOne
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;
    @ManyToOne
    @JoinColumn(name = "avialine_id")
    private Airline airline;
    @ManyToOne
    @JoinColumn(name = "craft_id")
    private Aircraft aircraft;
    @Column(name = "gate_id")
    private int gateId;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumb=" + flightNumb +
                ", time=" + time +
                ", flightStatus=" + flightStatus +
                ", terminal=" + terminal.getName() +
                ", avialineId=" + airline.getName() +
                ", craft=" + "model: " + aircraft.getAircraftTypes().getType() + " numb: " + aircraft.getSerialNumber() +
                ", gateId=" + gateId +
                '}';
    }
}
