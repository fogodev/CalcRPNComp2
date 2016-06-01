package com.fogodev.calcrpn;

public interface App extends Jogo {
    void movimento(int x, int y);
    void arrasto(int x, int y);
    void clique(int x, int y);
    void aperto(int x, int y);
    void solta(int x, int y);
}