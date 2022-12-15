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
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "numb_phone")
    private int numbPhone;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "gate_id")
    private Gate gate;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = " personalinfo_id")
    private Personalinfo personalinfo;

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numbPhone=" + numbPhone +
                ", gate=" + gate +
                '}';
    }
}
