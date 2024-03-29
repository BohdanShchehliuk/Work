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
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberofgate;
    @ManyToOne
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;
    private int capacity;


    @Override
    public String toString() {
        return "Gate{" +
                "id=" + id +
                ", numberOfgate=" + numberofgate +
                ", terminal=" + terminal.getName() +
                ", capacity=" + capacity +
                '}';
    }
}
