package com.quercusdata.itxdemo.repository;

import com.quercusdata.itxdemo.entity.Fare;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends JpaRepository<Fare, Long> {

    Optional<Fare> findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime before,
                                                                                                      LocalDateTime after,
                                                                                                      Integer productId,
                                                                                                      Integer brandId);

}
