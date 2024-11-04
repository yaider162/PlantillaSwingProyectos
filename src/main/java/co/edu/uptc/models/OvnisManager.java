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
        createOvnis();
    }

    private void createOvnis() {
        for (int i = 0; i < ovnisCount; i++) {
            Ovni ovni = new Ovni(ovnisSpeed);
            ovnis.add(ovni);
            new Thread(ovni).start();
            try {
                Thread.sleep(ovnisTime);
            } catch (InterruptedException e) {
                System.out.println("Falló xd");
            }
        }
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
