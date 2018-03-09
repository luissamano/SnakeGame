/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

import java.awt.Point;

/**
 *
 * @author marti
 */
public class VarCoordenadas {
        
    private int coorX; 
    private int tempX;
    private int coorY;
    private int tempY;
    private int cambio = 10;
    private int velocidad = 1000;
    private boolean inicio = true;
    private String direccion = "abajo";
    
    Point coordenada = new Point();

    
    public int getCoorX() {
        return coorX;
    }

    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public int getTempX() {
        return tempX;
    }

    public void setTempX(int tempX) {
        this.tempX = tempX;
    }

    public int getCoorY() {
        return coorY;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }

    public int getTempY() {
        return tempY;
    }

    public void setTempY(int tempY) {
        this.tempY = tempY;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Point getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
    }

}
