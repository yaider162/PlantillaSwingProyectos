package co.edu.uptc.views.pages;

import co.edu.uptc.models.Ovni;
import co.edu.uptc.models.OvnisManager;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@Getter
public class OvnisMovementPanel extends JPanel {

    private OvnisManager ovnisManager;
    private boolean firstTime = true;
    private Ovni ovniToucheded;
    private FinishZone finishZone;
    private boolean givingTarget = false;

    public OvnisMovementPanel(OvnisManager ovnisManager) {
        this.ovnisManager = ovnisManager;
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(new Color(4, 13, 18));
        addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ovniToucheded = getOvniTouched(evt.getX(), evt.getY());
                if(evt.getButton()==MouseEvent.BUTTON3 && ovniToucheded!=null){
                    ovniToucheded.setFollowingMouse(true);
                    ovniToucheded.setInitialSpeed(60);
                }
                if(evt.getButton()==MouseEvent.BUTTON1 && ovniToucheded!=null) {
                    ovniToucheded.setFollowingMouse(false);
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                if (ovniToucheded != null && ovniToucheded.isFollowingMouse()) {
                    ovniToucheded.setTargetPosition(evt.getX(), evt.getY());
                }
            }
        });
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        finishZone = new FinishZone();
        this.add(finishZone);
    }

    public Ovni getOvniTouched(int x, int y) {
        for (Ovni ovni : ovnisManager.getOvnisAlive()) {
            if (ovni.contains(x, y)) {
                return ovni;
            }
        }
        return null;
    }

    @SneakyThrows
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (firstTime) ovnisManager.continueOvnis(g);
        firstTime = false;
        ovnisManager.setFinishZone(finishZone);
        ovnisManager.moves(g);
        if(ovnisManager.isShowTrajectories()) drawTrajectories(g);
    }
    private void drawTrajectories(Graphics g) {
        g.setColor(Color.WHITE);
        for (Ovni ovni : ovnisManager.getOvnisAlive()) {
            int centerX = ovni.getX() + ovni.getSize() / 2;
            int centerY = ovni.getY() + ovni.getSize() / 2;
            int futureX = centerX + (int) ovni.getSpeed()*100;
            int futureY = centerY + (int) ovni.getSpeedY()*100;
            if(ovniToucheded!=null){
                centerX = ovniToucheded.getX() + ovniToucheded.getSize() / 2;
                centerY = ovniToucheded.getY() + ovniToucheded.getSize() / 2;
                g.drawLine(centerX, centerY, ovniToucheded.getTargetX(), ovniToucheded.getTargetY());
            }else{
                g.drawLine(centerX, centerY, futureX, futureY);
            }
        }
    }
}