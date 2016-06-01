package com.fogodev.calcrpn;

import java.math.BigInteger;

public interface OpCalc {
    void setEsq(BigInteger val);
    void setDir(BigInteger val);
    BigInteger getValor();
}