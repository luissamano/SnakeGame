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
import interfaces.Principal;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Relog {

    Timer timer = new Timer(); // El timer que se encarga de administrar los tiempo de repeticion
    public int segundos = 59; // manejar el valor del contador
    public boolean frozen; // manejar el estado del contador TIMER AUTOMATICO -- True Detenido | False Corriendo
    Principal p;

    public Relog(Principal p) {
        this.p = p;

    }

    class MiTarea extends TimerTask {

        @Override
        public void run() {
            segundos--;
            p.time.setText("" + segundos);
            if (segundos == 0) {
                Stop();
            }
        }
    }

    public void Start(int pSeg) {
        frozen = false;
        timer.schedule(new MiTarea(), 5900, 900);
//        timer.schedule(new MiTarea(), 0, 1 * 1000 * 60);
    }

    public void Stop() {
        System.out.println("Stop");
        frozen = true;        
        p.time.setText("" + segundos);
    }

    public void Reset() {
        frozen = true;
        segundos = 0;
    }

}
