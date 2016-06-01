package com.fogodev.calcrpn;

import java.math.BigInteger;

/**
 * Criado por ericson em 26/05/16.
 *
 * https://github.com/fogodev
 */
public class CalcRPN extends AbstractCalc
{
    private BigInteger p1 = BigInteger.valueOf(0);
    private BigInteger p2 = BigInteger.valueOf(0);
    private BigInteger p3 = BigInteger.valueOf(0);

    @Override
    public void soma()
    {
        this.troca = true;
        this.display = this.display.add(this.p1);
        this.p1 = this.p2;
        this.p2 = this.p3;
        this.p3 = BigInteger.valueOf(0);
        this.obs.mudou(this.display);
    }

    @Override
    public void sub()
    {
        this.troca = true;
        this.display = this.display.subtract(this.p1);
        this.p1 = this.p2;
        this.p2 = this.p3;
        this.p3 = BigInteger.valueOf(0);
        this.obs.mudou(this.display);
    }



    @Override
    public void mult()
    {
        this.troca = true;
        this.display = this.display.multiply(this.p1);
        this.p1 = this.p2;
        this.p2 = this.p3;
        this.p3 = BigInteger.valueOf(0);
        this.obs.mudou(this.display);
    }

    @Override
    public void div()
    {
        this.troca = true;
        this.display = this.display.divide(this.p1);
        this.p1 = this.p2;
        this.p2 = this.p3;
        this.p3 = BigInteger.valueOf(0);
        this.obs.mudou(this.display);
    }

    @Override
    public void igual()
    {
        this.p3 = this.p2;
        this.p2 = this.p1;
        this.p1 = this.display;
        this.display = BigInteger.valueOf(0);
        this.obs.mudou(this.display);
    }

    @Override
    public void reset()
    {
        super.reset();
        this.p1 = BigInteger.valueOf(0);
        this.p2 = BigInteger.valueOf(0);
        this.p3 = BigInteger.valueOf(0);
    }
}
