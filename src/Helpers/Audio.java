/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.File;
import static sun.audio.AudioPlayer.player;
import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;
import static sun.audio.AudioPlayer.player;

/**
 *
 * @author marti
 */
public class Audio {
    
    private BasicPlayer player = new BasicPlayer();

    public BasicPlayer getPlayer() {
        return player;
    }

    public void setPlayer(BasicPlayer player) {
        this.player = player;
    }
    
    public Audio() {
        //
    }
    
    public void Play() throws Exception {
        player.play();
    }

    public void AbrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));
    }

    public void Pausa() throws Exception {
        player.pause();
    }

    public void Continuar() throws Exception {
        player.resume();
    }

    public void Stop() throws Exception {
        player.stop();
    }

}
