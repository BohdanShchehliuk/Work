package airport.repository;

import airport.entity.Salary;
import airport.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

public interface TerminalRepository extends JpaRepository <Terminal, Integer> {
   }
