package co.edu.uptc.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OvnisManager {

    private List<Ovni> ovnis;
    private int ovnisCount, ovnisTime, ovnisSpeed;

    public OvnisManager(int ovnisCount, int ovnisTime, int ovnisSpeed) {
        this.ovnisCount = ovnisCount;
        this.ovnisTime = ovnisTime;
        this.ovnisSpeed = ovnisSpeed;
        this.ovnis = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "OvnisManager{" +
                "ovnisCant=" + ovnisCount +
                ", ovnisTime=" + ovnisTime +
                ", ovnisSpeed=" + ovnisSpeed +
                '}';
    }
}
