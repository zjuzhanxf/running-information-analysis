package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xiaofeng on 10/9/17.
 */
public interface RunningInformationService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList);

    void deleteAll();

    RunningInformation findByRunningId(String runningId);

    void delete(Long runningInfoId);

    void delete(String runningId);

    Page<RunningInformation> findAllByOrderByHeartrateDesc(Pageable pageable);
}
