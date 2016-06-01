package com.fogodev.calcrpn;

import java.math.BigInteger;

public class CalcQF extends AbstractCalc {
    boolean troca;
    OpCalc pendente, ultima;
    
    public void soma() {
        fazPendente();
        pendente = new OpCalc() {
            BigInteger esq, dir;
            public void setEsq(BigInteger val) { esq = val; }
            public void setDir(BigInteger val) { dir = val; }
            public BigInteger getValor() { return esq.add(dir); }
        };
        pendente.setEsq(display);
    }
    
    public void sub() {
        fazPendente();
        pendente = new OpCalc() {
            BigInteger esq, dir;
            public void setEsq(BigInteger val) { esq = val; }
            public void setDir(BigInteger val) { dir = val; }
            public BigInteger getValor() { return esq.subtract(dir); }
        };
        pendente.setEsq(display);
    }
    
    public void div() {
        fazPendente();
        pendente = new OpCalc() {
            BigInteger esq, dir;
            public void setEsq(BigInteger val) { esq = val; }
            public void setDir(BigInteger val) { dir = val; }
            public BigInteger getValor() { return esq.divide(dir); }
        };
        pendente.setEsq(display);
    }
    
    public void mult() {
        fazPendente();
        pendente = new OpCalc() {
            BigInteger esq, dir;
            public void setEsq(BigInteger val) { esq = val; }
            public void setDir(BigInteger val) { dir = val; }
            public BigInteger getValor() { return esq.multiply(dir); }
        };
        pendente.setEsq(display);
    }
    
    public void igual() {
        if(pendente != null) {
            troca = true;
            pendente.setDir(display);
            display = pendente.getValor();
            ultima = pendente;
            pendente = null;
            obs.mudou(display);
        } else if(ultima != null) {
            troca = true;
            ultima.setEsq(display);
            display = ultima.getValor();
            obs.mudou(display);
        }
    }
    
    public void fazPendente() {
        if(pendente != null && !troca) {
            pendente.setDir(display);
            display = pendente.getValor();
            obs.mudou(display);
        }
        troca = true;
    }
    
    public void reset() {
        super.reset();
        pendente = null; ultima = null;
    }
}