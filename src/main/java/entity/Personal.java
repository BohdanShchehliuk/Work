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
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "numb_phone")
    private int numbPhone;
    @ManyToOne
    @JoinColumn(name = "gate_id")
    private Gate gate;
    @OneToOne
    private PersonalInfo personalInfo;

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
