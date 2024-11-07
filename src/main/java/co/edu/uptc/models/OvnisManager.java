package co.edu.uptc.models;

import co.edu.uptc.interfaces.Interfaces;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;

public class OvnisManager implements Interfaces.Model {
    private int ovnisCant;
    private int ovnisTime;
    private int ovnisSpeed;
    private CopyOnWriteArrayList<Ovni> ovnisAlive;
    private CopyOnWriteArrayList<Ovni> ovnisCrashed;

    public OvnisManager(int ovnisCant, int ovnisTime, int ovnisSpeed) {
        this.ovnisCant = ovnisCant;
        this.ovnisTime = ovnisTime;
        this.ovnisSpeed = ovnisSpeed;
        initOvnis();
    }

    private void initOvnis() {
        ovnisAlive = new CopyOnWriteArrayList<>();
        ovnisCrashed = new CopyOnWriteArrayList<>();
        for (int i = 0; i < ovnisCant; i++) {
            ovnisAlive.add(new Ovni(ovnisSpeed, this));
        }
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