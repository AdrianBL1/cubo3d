
package cubo3d;

import java.awt.*;
import java.awt.event.ActionEvent;
import static java.lang.Math.*;
import javax.swing.*;

public class areaTrabajo extends javax.swing.JPanel {
    
    double[][] nodes = {{-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
    {1, -1, -1}, {1, -1, 1}, {1, 1, -1}, {1, 1, 1}};
 
    int[][] edges = {{0, 1}, {1, 3}, {3, 2}, {2, 0}, {4, 5}, {5, 7}, {7, 6},
    {6, 4}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
    
    private static final int SHIFT_INC = 10;
    
    public areaTrabajo() {
        initComponents();
        setPreferredSize(new Dimension(640, 640));
        setBackground(Color.white);
 
        scale(100);
        rotateCube(PI / 4, atan(sqrt(2)));
 
        //rotateCube(PI / 180, 0);
        //repaint();
    }
    
    public void scaling(double sc){
        scale(sc);
        repaint();
    }
    
    public void rotation(double angleX, double angleY){
        rotateCube(angleX, angleY);
        repaint();
    }
    
    public void transt(double t1, double t2, double t3){
        translation(t1, t2, t3);
        repaint();
    }
    
    final void scale(double s) {
        for (double[] node : nodes) {
            node[0] *= s;
            node[1] *= s;
            node[2] *= s;
        }
    }
    
    final void rotateCube(double angleX, double angleY) {
        double sinX = sin(angleX);
        double cosX = cos(angleX);
 
        double sinY = sin(angleY);
        double cosY = cos(angleY);
 
        for (double[] node : nodes) {
            double x = node[0];
            double y = node[1];
            double z = node[2];
 
            node[0] = x * cosX - z * sinX;
            node[2] = z * cosX + x * sinX;
 
            z = node[2];
 
            node[1] = y * cosY - z * sinY;
            node[2] = z * cosY + y * sinY;
        }
    }
    
    final void translation(double t1, double t2, double t3){
        for (double[] node : nodes) {
            node[0] += t1;
            node[1] += t2;
            node[2] += t3;
        }
    }
    
    void drawCube(Graphics2D g) {
        g.translate(getWidth() / 2, getHeight() / 2);
 
        for (int[] edge : edges) {
            double[] xy1 = nodes[edge[0]];
            double[] xy2 = nodes[edge[1]];
            g.drawLine((int) round(xy1[0]), (int) round(xy1[1]),
                    (int) round(xy2[0]), (int) round(xy2[1]));
        }
 
        for (double[] node : nodes) 
            g.fillOval((int) round(node[0]) - 4, (int) round(node[1]) - 4, 8, 8);        
    }
    
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
 
        drawCube(g);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
