package com.fogodev.calcrpn;

public class CaixaTexto extends Componente {
    int pos;
    Cor borda, frente, fundo;
    Texto texto;
    
    public CaixaTexto(int _x, int _y, int _larg, int _alt, int _pos,
                      Cor _borda, Cor _frente, Cor _fundo, Texto _texto) {
        super(_x, _y, _larg, _alt);
        pos = _pos; texto = _texto; borda = _borda;
        frente = _frente; fundo = _fundo;
    }
    
    public void desenhar(Tela t) {
        t.retangulo(x, y, larg, alt, borda);
        t.retangulo(x + 5, y + 5, larg - 10, alt - 10, fundo);
        t.texto(texto.getTexto(), x + 20, y + 20, larg - 40, alt - 40, pos, 36, frente);
    }
}