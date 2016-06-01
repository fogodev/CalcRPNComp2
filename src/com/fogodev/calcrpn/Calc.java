package com.fogodev.calcrpn;

public interface Calc {
    void digito(int i);
    void soma();
    void sub();
    void mult();
    void div();
    void igual();
    void reset();
    void memPlus();
    void memSub();
    void memRecall();
    void memClear();
    void setObservador(ObservadorBigInteger obs);
}