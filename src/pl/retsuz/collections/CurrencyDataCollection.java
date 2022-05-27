package pl.retsuz.collections;

import pl.retsuz.Main;
import pl.retsuz.currency.ICurrency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDataCollection implements IDataCollection {
    @Override
    public String ToString() {
        String allObj = "All objects: ";
        for (int counter = 0; counter < getCurrencyList().size(); ++counter){
            allObj = allObj.concat(getCurrencyList().get(counter).getCode());
            allObj = allObj.concat("\n");
        }
        return allObj;
    }

    @Override
    public ICurrency getCurrencyByCode(ICurrency currency) {
        for (int counter = 0; counter < getCurrencyList().size(); ++counter){
            if (currency.getCode().equals(getCurrencyList().get(counter).getCode())) {
                System.out.println("Found a currency with the same code" + currency.getCode() +  "in the list at place number " + counter);
                return getCurrencyList().get(counter);
            }
        }
        System.out.println("Currency with the same code not found!");
        return null;
    }

    @Override
    public List<ICurrency> getCurrencyList() {
        return Main.list;
    }

}