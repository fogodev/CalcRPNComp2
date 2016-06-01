package com.fogodev.calcrpn;

public abstract class Componente {
    public int x, y, larg, alt;

    public Componente(int _x, int _y, int _larg, int _alt) {
        x = _x; y = _y; larg = _larg; alt = _alt;
    }
    
    public int getX1() { return x; }
    public int getY1() { return y; }
    public int getX2() { return x + larg; }
    public int getY2() { return y + alt; }
    
    public abstract void desenhar(Tela t);
    
    public void arrasto(int x, int y) {}
    
    public void clique(int x, int y) {}
    
    public void aperto(int x, int y) {}
    
    public void solta(int x, int y) {}
}