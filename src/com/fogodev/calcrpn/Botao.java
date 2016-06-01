package com.fogodev.calcrpn;

public class Botao extends Componente {
    Cor frente, fundo;
    String texto;
    Acao acao;
    
    public Botao(int _x, int _y, int _larg, int _alt, String _texto, 
                 Cor _frente, Cor _fundo, Acao _acao) {
        super(_x, _y, _larg, _alt);             
        larg = _larg; alt = _alt;
        texto = _texto; frente = _frente; fundo = _fundo; acao = _acao;
    }
    
    public void clique(int x, int y) {
        acao.executa();
    }
    
    public void aperto(int x, int y) {
        Cor temp = fundo;
        fundo = frente;
        frente = temp;
    }

    public void solta(int x, int y) {
        Cor temp = fundo;
        fundo = frente;
        frente = temp;
    }

    public void desenhar(Tela t) {
        t.retangulo(x, y, larg, alt, frente);
        t.retangulo(x + 5, y + 5, larg - 10, alt - 10, fundo);
        t.texto(texto, x, y, larg, alt, Tela.CENTRO, 36, frente);
    }
}