/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author marti
 */
import interfaces.AreaMovimiento;
import interfaces.Principal;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Tiempo implements Runnable {

    Thread tiempo = new Thread(this);
    AreaMovimiento am = new AreaMovimiento();
    public int segundos = 62;
    int velocidad = 1000;
    Principal p;

    public Tiempo(AreaMovimiento am, Principal p) {
        this.am = am;
        this.p = p;
    }

    public void iniciarProceso() {
        this.tiempo.start();
    }
    
    @Override
    public void run() {
        do {
            segundos--;
            p.time.setText("" + segundos);
            if (segundos == 0) {
                am.setVidas(0);
                p.lives.setText(""+0);
                break;
            }
            try {
                this.tiempo.sleep(this.velocidad);
            } catch (InterruptedException e) {
                break;
            }
        } while (segundos != 0);
    }

}
