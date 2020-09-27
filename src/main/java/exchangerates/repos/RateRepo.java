package exchangerates.repos;

import exchangerates.domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RateRepo extends CrudRepository<Rate, Long> {
    List<Rate> findTop3ByOrderByIdDesc();
}
