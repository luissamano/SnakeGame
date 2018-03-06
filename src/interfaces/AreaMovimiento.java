/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Helpers.Relog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.accessibility.AccessibleContext;
import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author marti
 */
public final class AreaMovimiento extends JPanel implements Runnable {

    int vidas = 3;
    int cambio = 10;
    int coorX, tempX;
    int coorY, tempY;
    int velocidad = 1000;
    boolean inicio = true;
    String direccion = "abajo";
    Point coordenada = new Point();
    int Numbers = 1;
    Principal p;

    Image avion;
    

    public Image getAvion() {
        return avion;
    }

    public void setAvion(Image avion) {
        this.avion = avion;
    }
    

    Thread proceso = new Thread(this);
    JLabel lives;

    public AreaMovimiento(Principal p) {
        this.iniciarProceso();
        this.p = p;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void iniciarProceso() {
        this.proceso.start();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.inicio) {
            Metodo();
            avion = new ImageIcon(getClass().getResource("/img/abajo.png")).getImage()
                    .getScaledInstance(10, -1, Image.SCALE_DEFAULT);
            
            this.inicio = false;
            
        }

        g.fillOval(this.coordenada.x, this.coordenada.y, 10, 10);
        g.drawString(""+Numbers, coorX, coorY);

        if (coordenada.x <= -14 || coordenada.y <= -14 || coordenada.x >= 492 || coordenada.y >= 448) {
            Metodo();
            vidas = vidas - 1;
            p.lives.setText(""+vidas);
        }
        
        if (this.coordenada.x == coorX || this.coordenada.y == coorY) {
            Numbers++;
            CoorNums();
            g.drawString(""+Numbers, coorX, coorY);
        }
    }

    @Override
    public void run() {
        do {
            switch (this.direccion) {
                case "arriba":
                    this.coordenada.y -= this.cambio;
                    break;
                case "abajo":
                    this.coordenada.y += this.cambio;
                    break;
                case "derecha":
                    this.coordenada.x += this.cambio;
                    break;
                case "izqierda":
                    this.coordenada.x -= this.cambio;
                    break;
            }
            try {
                this.proceso.sleep(this.velocidad);
            } catch (InterruptedException e) {
                break;
            }
            repaint();
        } while (vidas > 0);
    }

    public void Metodo() {
        CoorNums();
        this.coordenada.x = this.getSize().width / 2;
        this.coordenada.y = this.getSize().height / 2;
    }
    
    public void CoorNums(){
        coorX = Aleatorio();
        coorY = Aleatorio();
    }

    public int Aleatorio() {
        return (-14 + (int) (Math.random() * 491));
    }
    
    
}
