package demo.rest;

import com.fasterxml.jackson.annotation.JsonView;
import demo.domain.RunningInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import demo.service.RunningInformationService;

import java.util.List;

/**
 * Created by xiaofeng on 10/9/17.
 */

@RestController
public class RunningInformationRestController {

    private RunningInformationService runningInformationService;

    @Autowired
    public RunningInformationRestController (RunningInformationService runningInformationService) {
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Welcome to Running Information Analysis Service!";
    }

    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.GET)
    public RunningInformation findByRunningId(@PathVariable String runningId) {
        return this.runningInformationService.findByRunningId(runningId);
    }


    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public Page<RunningInformation> findAllByOrderByHeartrateDesc(@RequestParam(name="page") int page, @RequestParam(value="size", required = false, defaultValue = "2") int size) {
        return this.runningInformationService.findAllByOrderByHeartrateDesc(new PageRequest(page, size));
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformationList) {
        this.runningInformationService.saveRunningInformation(runningInformationList);
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.DELETE)
    public void purge() {
        this.runningInformationService.deleteAll();
    }

    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String runningId) {
        this.runningInformationService.delete(runningId);
    }

}
