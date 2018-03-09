/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Helpers.Audio;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author marti
 */
public final class AreaMovimiento extends JPanel implements Runnable {

    int vidas;
    int cambio = 10;
    int Numbers = 1;
    int coorX, tempX;
    int coorY, tempY;
    int velocidad = 1000;
    boolean inicio = true;
    String direccion = "abajo";
    Point coordenada = new Point();

    Thread proceso = new Thread(this);

    Principal p;
    AreaMovimiento am;

    Image avion;

    public AreaMovimiento(Principal p) {
        this.iniciarProceso();
        this.p = p;

    }

    public AreaMovimiento() {

    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
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
        vidas = 3;
        //this.p.r.Start(60);
        avion = new ImageIcon(getClass().getResource("/img/abajo.png")).getImage()
                .getScaledInstance(80, 70, Image.SCALE_SMOOTH);

        this.proceso.start();

    }

    public void terminarProceso() {
        vidas = 0;
        Numbers = 9;
        p.lives.setText("" + vidas);
        this.coordenada.x = this.getSize().width / 2;
        this.coordenada.y = this.getSize().height / 2;
        inicio = true;
        int des = (int) JOptionPane.showConfirmDialog(null, "¿Volver a jugar?", "Fin del juego", WIDTH);
        if (des == 1) {
            this.proceso.stop();
            iniciarProceso();
        } else {
            this.proceso.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.inicio) {
            Metodo();
            this.inicio = false;
        }

        g.drawImage(this.avion, this.coordenada.x, this.coordenada.y, this);
        //g.fillOval(this.coordenada.x, this.coordenada.y, 10, 10);
        g.setColor(Color.RED);
        g.setFont(new Font("Courier New", 1, 17));
        g.drawString("" + Numbers, coorX, coorY);

        if (coordenada.x <= -14 || coordenada.y <= -14 || coordenada.x >= 492 || coordenada.y >= 448) {
            Metodo();
            vidas = vidas - 1;
            p.lives.setText("" + vidas);
        }

        if (this.coordenada.x == this.coorX || this.coordenada.y == this.coorY
                || this.coordenada.x + 1 == this.coorX || this.coordenada.x + 1 == this.coorX
                || this.coordenada.x - 1 == this.coorX || this.coordenada.x - 1 == this.coorX
                || this.coordenada.x + 2 == this.coorX || this.coordenada.x + 2 == this.coorX
                || this.coordenada.x - 2 == this.coorX || this.coordenada.x - 2 == this.coorX
                || this.coordenada.x + 3 == this.coorX || this.coordenada.x + 3 == this.coorX
                || this.coordenada.x - 3 == this.coorX || this.coordenada.x - 3 == this.coorX
                || this.coordenada.x + 4 == this.coorX || this.coordenada.x + 4 == this.coorX
                || this.coordenada.x - 4 == this.coorX || this.coordenada.x - 4 == this.coorX
                || this.coordenada.x + 5 == this.coorX || this.coordenada.x + 5 == this.coorX
                || this.coordenada.x - 5 == this.coorX || this.coordenada.x - 5 == this.coorX) {
            if (vidas > 0) {
                if (Numbers <= 9) {
                    CoorNums();
                    Numbers++;
                    g.drawString("" + Numbers, coorX, coorY);
                    if (Numbers == 10) {
                        terminarProceso();
                    }
                }
            } else {
                terminarProceso();
            }

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
            if (vidas == 0) {
                terminarProceso();
            }
        } while (this.inicio == false || vidas == 0);

        //Metodo();
    }

    public void Metodo() {
        CoorNums();
        this.coordenada.x = this.getSize().width / 2;
        this.coordenada.y = this.getSize().height / 2;
    }

    public void CoorNums() {
        coorX = Aleatorio();
        coorY = Aleatorio();
    }

    public int Aleatorio() {
        return (-14 + (int) (Math.random() * 491));
    }

}
