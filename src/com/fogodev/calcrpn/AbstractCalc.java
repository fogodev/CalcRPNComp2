package com.fogodev.calcrpn;

import java.math.BigInteger;

/**
 * Criado por ericson em 26/05/16.
 *
 * https://github.com/fogodev
 */
public abstract class AbstractCalc implements Calc
{
    protected BigInteger display = BigInteger.valueOf(0);
    protected BigInteger internalMemory = BigInteger.valueOf(0);
    protected ObservadorBigInteger obs;
    protected boolean troca;
    private BigInteger incrementDisplayByTen = BigInteger.valueOf(10);

    public void digito(int i) {
        if(this.troca) {
            this.display = BigInteger.valueOf(i);
            this.troca = false;
        } else {
            display = display.multiply(this.incrementDisplayByTen).add(BigInteger.valueOf(i));
        }
        obs.mudou(this.display);
    }

    @Override
    public void memPlus()
    {
        this.internalMemory = this.internalMemory.add(this.display);
    }

    @Override
    public void memSub()
    {
        this.internalMemory = this.internalMemory.subtract(this.display);
    }

    @Override
    public void memRecall()
    {
        this.display = this.internalMemory;
        this.obs.mudou(this.display);
    }

    @Override
    public void memClear()
    {
        this.internalMemory = BigInteger.valueOf(0);
    }

    @Override
    public void reset()
    {
        this.troca = false;
        this.display = BigInteger.valueOf(0);
        this.obs.mudou(this.display);
    }

    @Override
    public void setObservador(ObservadorBigInteger obs)
    {
        this.obs = obs;
    }
}
