package demo.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by xiaofeng on 10/8/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "running_analysis")
public class RunningInformation {

    enum HealthWarningLevel {
        HIGH, NORMAL, LOW;
    }

    @Id
    @GeneratedValue
    private long runningInfoId;

    private String runningId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double latitude;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double longitude;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double runningDistance;

    private double totalRunningTime;

    private int heartRate;

    private HealthWarningLevel healthWarningLevel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date timestamp = new Date();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userinfo_username")),
            @AttributeOverride(name = "address", column = @Column(name = "userinfo_address"))
    })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    UserInfo userInfo;

    public RunningInformation(){}

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId) {
        this.runningId = runningId;
    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @JsonProperty(value = "userName")
    public String getUsername () {
        return this.userInfo == null ? null : this.userInfo.getUsername();
    }

    @JsonProperty(value = "userAddress")
    public String getAddress() {return this.userInfo.getAddress();}

    public void setHeartRate(int heartRate) {
        int min = 60;
        int max = 200;
        Random rand = new Random();
        this.heartRate = rand.nextInt(max - min + 1) + min;
        if(this.heartRate >= 60 && this.heartRate <= 75) {
            this.healthWarningLevel = HealthWarningLevel.LOW;
        } else if (this.heartRate <= 120) {
            this.healthWarningLevel = HealthWarningLevel.NORMAL;
        } else {
            this.healthWarningLevel = HealthWarningLevel.HIGH;
        }
    }
}
