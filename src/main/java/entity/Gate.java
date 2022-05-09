package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberOfgate;
    @ManyToOne
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;
    private int capacity;


    @Override
    public String toString() {
        return "Gate{" +
                "id=" + id +
                ", numberOfgate=" + numberOfgate +
                ", terminal=" + terminal.getName() +
                ", capacity=" + capacity +
                '}';
    }
}