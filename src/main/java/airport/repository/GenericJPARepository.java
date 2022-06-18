package airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericJPARepository  <T> extends JpaRepository<T, Integer> {
}
