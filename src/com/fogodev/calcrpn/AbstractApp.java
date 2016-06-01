package com.fogodev.calcrpn;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public abstract class AbstractApp implements App {
    List<Componente> componentes;
    Componente apertado;
    
    public AbstractApp() {
        componentes = new ArrayList<Componente>();
    }
    
    public void tique(Set<String> teclas, double dt) {}
    
    public void tecla(String tecla) {}
    
    public void desenhar(Tela t) {
        for(Componente c: componentes) {
            c.desenhar(t);
        }
    }
    
    public void movimento(int x, int y) {}
    
    public void arrasto(int x, int y) {
        if(apertado != null) {
            apertado.arrasto(x, y);
        }
    }
    
    public void clique(int x, int y) {
        for(Componente c: componentes) {
            if(x >= c.getX1() && x <= c.getX2() &&
               y >= c.getY1() && y <= c.getY2())
               c.clique(x, y);
        }
    }
    
    public void aperto(int x, int y) {
        for(Componente c: componentes) {
            if(x >= c.getX1() && x <= c.getX2() &&
               y >= c.getY1() && y <= c.getY2()) {
               c.aperto(x, y);
               apertado = c;
            }
        }
    }
    
    public void solta(int x, int y) {
        if(apertado != null) {
            apertado.solta(x, y);
            apertado = null;
        }
    }
}