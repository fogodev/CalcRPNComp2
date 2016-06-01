package com.fogodev.calcrpn;

import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

public class Calculadora extends AbstractApp {
    String texto = "0";
    Calc calc;
            
    public Calculadora() {
        // existe um "super();" implícito aqui
        // Modelo
        calc = new CalcRPN();
        calc.setObservador(new ObservadorBigInteger() {
            public void mudou(BigInteger valor) { mudouDisplay(valor); }
        });
        // Visão

        componentes.add(new Botao(0, 100, 100, 100, "M+", Cor.BRANCO, Cor.PRETO,
            new Acao(){
                public void executa(){ memoryPlusButton();}
            }));
        componentes.add(new Botao(100, 100, 100, 100, "M-", Cor.BRANCO, Cor.PRETO,
            new Acao(){
                public void executa(){ memorySubButton();}
            }));
        componentes.add(new Botao(200, 100, 100, 100, "MR", Cor.BRANCO, Cor.PRETO,
            new Acao(){
                public void executa(){ memoryRecallButton();}
            }));
        componentes.add(new Botao(300, 100, 100, 100, "MC", Cor.BRANCO, Cor.PRETO,
            new Acao(){
                public void executa(){ memoryClearButton();}
            }));


        componentes.add(new Botao(0, 200, 100, 100, "7", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 7)));
        componentes.add(new Botao(100, 200, 100, 100, "8", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 8)));
        componentes.add(new Botao(200, 200, 100, 100, "9", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 9)));
        componentes.add(new Botao(300, 200, 100, 100, "+", Cor.BRANCO, Cor.PRETO,
            new Acao() {
                public void executa() { botaoMais(); }
            }));
        componentes.add(new Botao(0, 300, 100, 100, "4", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 4)));
        componentes.add(new Botao(100, 300, 100, 100, "5", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 5)));
        componentes.add(new Botao(200, 300, 100, 100, "6", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 6)));
        componentes.add(new Botao(300, 300, 100, 100, "-", Cor.BRANCO, Cor.PRETO,
            new Acao() {
                public void executa() { botaoMenos(); }
            }));
        componentes.add(new Botao(0, 400, 100, 100, "1", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 1)));
        componentes.add(new Botao(100, 400, 100, 100, "2", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 2)));
        componentes.add(new Botao(200, 400, 100, 100, "3", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 3)));
        componentes.add(new Botao(300, 400, 100, 100, "*", Cor.BRANCO, Cor.PRETO,
            new Acao() {
                public void executa() { botaoVezes(); }
            }));
        componentes.add(new Botao(0, 500, 100, 100, "C", Cor.BRANCO, Cor.PRETO,
            new Acao() {
                public void executa() { botaoReset(); }
            }));
        componentes.add(new Botao(100, 500, 100, 100, "0", Cor.BRANCO, Cor.PRETO,
            new AcaoDigito(this, 0)));
        componentes.add(new Botao(200, 500, 100, 100, "=", Cor.BRANCO, Cor.PRETO,
            new Acao() {
                public void executa() { botaoIgual(); }
            }));
        componentes.add(new Botao(300, 500, 100, 100, "/", Cor.BRANCO, Cor.PRETO,
            new Acao() {
                public void executa() { botaoDiv(); }
            }));
        componentes.add(new CaixaTexto(0, 0, 400, 100, Tela.CENTROY | Tela.DIREITA,
           Cor.BRANCO, Cor.BRANCO, Cor.PRETO, new Texto() {
               public String getTexto() { return getTextoDisplay(); } 
            }));
    }
    
    public String getTitulo() {
        return "Calculadora";
    }
    
    public int getLargura() {
        return 400;
    }
    
    public int getAltura() {
        return 600;
    }

    //
    // Controlador
    //
    
    public void mudouDisplay(java.math.BigInteger display) {
        texto = display.toString();
    }
    
    public String getTextoDisplay() {
        return texto;
    }

    public void botaoDigito(int digito) {
        calc.digito(digito);
    }
    
    public void botaoMais() {
        calc.soma();
    }

    public void botaoMenos() {
        calc.sub();
    }

    public void botaoVezes() {
        calc.mult();
    }

    public void botaoDiv() {
        calc.div();
    }

    public void botaoIgual() {
        calc.igual();
    }

    public void botaoReset() {
        calc.reset();
    }

    public void memoryPlusButton()
    {
        calc.memPlus();
    }
    
    public void memorySubButton()
    {
        calc.memSub();
    }

    public void memoryRecallButton()
    {
        calc.memRecall();
    }

    public void memoryClearButton()
    {
        calc.memClear();
    }

    public static void main(String[] args) {
        new Motor(new Calculadora());
    }
}