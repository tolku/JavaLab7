package pl.retsuz.exchange;

import pl.retsuz.currency.ICurrency;

public class Exchange implements IExchange {
    @Override
    public double exchange(ICurrency src, ICurrency tgt, double amt) {
        double plnQuantity = src.getRate() * amt / src.getFactor();//tyle złociszy będziemy mieli, na 51,34% dobrze
        return plnQuantity / tgt.getRate() * tgt.getFactor();
    }
}

