package co.edu.uptc.models;

import co.edu.uptc.interfaces.Interfaces;

import java.awt.*;
import java.util.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class OvnisManager implements Interfaces.Model {
    private int ovnisCant;
    private long ovnisTime;
    private int ovnisSpeed;
    private Color ovniColor;
    private CopyOnWriteArrayList<Ovni> ovnisAlive;
    private CopyOnWriteArrayList<Ovni> ovnisCrashed;
    private int count =0;
    public OvnisManager(int ovnisCant, int ovnisTime, int ovnisSpeed, Color ovniColor) {
        this.ovnisCant = ovnisCant;
        this.ovnisTime = (long) ovnisTime;
        this.ovnisSpeed = ovnisSpeed;
        this.ovniColor = ovniColor;
        initOvnis();
    }

    public void continueOvnis(Graphics g){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (count < ovnisCant) {
                    Ovni ovni =new Ovni(ovnisSpeed, OvnisManager.this);
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
    }

    public void addCrashed(Ovni ovni) {
        ovnisCrashed.add(ovni);
        ovnisAlive.remove(ovni);
    }

    public void moves(Graphics g) throws InterruptedException {
        for (Ovni ovni : ovnisAlive) {
            ovni.move();
            ovni.draw(g);
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