package airport.repository;

import airport.entity.Routes;
import airport.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository <Salary, Integer> {
}
