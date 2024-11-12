package co.edu.uptc.models;

import co.edu.uptc.interfaces.Interfaces;
import co.edu.uptc.views.pages.FinishZone;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.*;

import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public class OvnisManager implements Interfaces.Model {

    private final int ovnisCant;
    private final long ovnisTime;
    private final int ovnisSpeed;
    private final Color ovniColor;
    private CopyOnWriteArrayList<Ovni> ovnisAlive;
    private CopyOnWriteArrayList<Ovni> ovnisCrashed;
    private CopyOnWriteArrayList<Ovni> ovnisOnHome;
    private int count = 0;
    private FinishZone finishZone;
    private boolean showTrajectories = false;

    public OvnisManager(int ovnisCant, int ovnisTime, int ovnisSpeed, Color ovniColor) {
        this.ovnisCant = ovnisCant;
        this.ovnisTime = ovnisTime;
        this.ovnisSpeed = ovnisSpeed;
        this.ovniColor = ovniColor;
        initOvnis();
    }
    public void continueOvnis(Graphics g) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (count < ovnisCant) {
                    Ovni ovni = new Ovni(ovnisSpeed, OvnisManager.this);
                    ovni.setColor(ovniColor);
                    ovnisAlive.add(ovni);
                    try {
                        moves(g);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    count++;
                }
            }
        }, 0, ovnisTime);
    }
    private void initOvnis() {
        ovnisAlive = new CopyOnWriteArrayList<>();
        ovnisCrashed = new CopyOnWriteArrayList<>();
        ovnisOnHome = new CopyOnWriteArrayList<>();
    }
    public void addCrashed(Ovni ovni) {
        ovnisCrashed.add(ovni);
        ovnisAlive.remove(ovni);
    }

    public void moves(Graphics g) throws InterruptedException {
        for (Ovni ovni : ovnisAlive) {
            if (finishZone.contains(ovni) && finishZone!=null) {
                ovnisAlive.remove(ovni);
                ovnisOnHome.add(ovni);
            }
            crashedWithAnother(ovni);
            ovni.move();
            ovni.draw(g);
        }
    }
    private void crashedWithAnother(Ovni ovni) {
        for (Ovni ovniAlive : ovnisAlive) {
            if (ovni != ovniAlive && ovni.crashWith(ovniAlive)) {
                ovnisAlive.remove(ovni);
                ovnisAlive.remove(ovniAlive);
            }
        }
    }
    public int getMovingOvnisCount() {
        return ovnisAlive.size();
    }
    public int getCrashedOvnisCount() {
        return ovnisCrashed.size();
    }
    public Ovni[] getOvnisAlive() {
        return ovnisAlive.toArray(new Ovni[0]);
    }

}