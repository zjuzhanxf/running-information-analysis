package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by xiaofeng on 10/9/17.
 */
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {
    RunningInformation findByRunningId(@Param("runningId") String runningId);

    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);

}
