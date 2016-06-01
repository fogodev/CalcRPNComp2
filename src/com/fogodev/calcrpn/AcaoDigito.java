package com.fogodev.calcrpn;

public class AcaoDigito implements Acao {
    int digito;
    Calculadora calc;
    
    public AcaoDigito(Calculadora _calc, int _digito) {
        calc = _calc;
        digito = _digito;
    }
    
    public void executa() {
        calc.botaoDigito(digito);
    }
}
