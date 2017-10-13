package demo.service.impl;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import demo.service.RunningInformationService;

import java.util.List;
import java.util.Random;

/**
 * Created by xiaofeng on 10/9/17.
 */

@Service
public class RunningInformationServiceImpl implements RunningInformationService {

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationServiceImpl(RunningInformationRepository runningInformationRepository) {
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList) {
        return runningInformationRepository.save(runningInformationList);
    }

    @Override
    public void deleteAll() {
        runningInformationRepository.deleteAll();
    }

    @Override
    public RunningInformation findByRunningId(String runningId) {
        return runningInformationRepository.findByRunningId(runningId);
    }

    @Override
    public void delete(Long runningInfoId) {
        runningInformationRepository.delete(runningInfoId);
    }

    @Override
    public void delete(String runningId) {
        RunningInformation record = runningInformationRepository.findByRunningId(runningId);
        runningInformationRepository.delete(record);
    }

    @Override
    public Page<RunningInformation> findAllByOrderByHeartrateDesc(Pageable pageable) {
        return runningInformationRepository.findAllByOrderByHeartRateDesc(pageable);
    }

}
