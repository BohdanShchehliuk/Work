package airport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    @Column(name = "flight_id")
    private int flightId;
    private int seat;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "passanger_id")
    private Passenger passenger;
    @Column(name = "ticket_staus")
    private int ticketStaus;
    @OneToOne
    private Routes routes;


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", number=" + number +
                ", flightId=" + flightId +
                ", seat=" + seat +
                ", passenger=" + passenger.getSurname() + " "+passenger.getName() +" "+passenger.getPassport()+
                ", ticketStaus=" + ticketStaus +
                ", route=" + routes.getRoute() +
              '}';
    }
}
