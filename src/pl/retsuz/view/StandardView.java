package pl.retsuz.view;

import pl.retsuz.collections.CurrencyDataCollection;
import pl.retsuz.collections.IDataCollection;
import pl.retsuz.currency.Currency;
import pl.retsuz.currency.ICurrency;
import pl.retsuz.exchange.Exchange;
import pl.retsuz.exchange.IExchange;
import pl.retsuz.Main;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.exit;

public class StandardView implements ICurrencyView {
    @Override
    public ICurrency ChooseCurrency(String label) {
        String code;
        Scanner scan = new Scanner(System.in);
        System.out.print("Currency code: ");
        code = scan.next();
        return StringToCurrency(code);
    }

    @Override
    public ICurrency StringToCurrency(String code) {
        Currency obj = new Currency(code);
        CurrencyDataCollection obj1 = new CurrencyDataCollection();
        for (int counter = 0; counter < obj1.getCurrencyList().size(); ++counter){
            if (obj1.getCurrencyList().get(counter).getCode().equals(obj.getCode())){
                System.out.println("currency with the same code found!");
                return obj1.getCurrencyList().get(counter);
            }
        }
        System.out.println("currency with the same code NOT found!");
        return null;
    }

    @Override
    public void exchange() {
        double amnt;
        Scanner scan = new Scanner(System.in);
        ICurrency src, tgt;
        Exchange trade = new Exchange();
        src = ChooseCurrency("x");
        System.out.print("Amount of currency to convert: ");
        amnt = scan.nextDouble();
        tgt = ChooseCurrency("y");
        System.out.println("amount of new currency: " + trade.exchange(src, tgt, amnt));
    }

    @Override
    public void menu() {
        IDataCollection x = new CurrencyDataCollection();
        Scanner scan = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("1 - print all currency codes\n2 - to check whether the currency with user specified code exist\n3 - to exchange currencies\n4 - to exit");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    ViewAll(x);
                    break;
                case 2:
                    ChooseCurrency("x");
                    break;
                case 3:
                    exchange();
                    break;
                case 4:
                    exit(1);
                default:
                    exit(-1);
            }
        }
    }

    @Override
    public void setDataCollection(IDataCollection collection) {
        collection = new CurrencyDataCollection();
    }

    @Override
    public void setExchange(IExchange exchange) {
        exchange = new Exchange();
    }

    @Override
    public void ViewAll(IDataCollection coll) {
        System.out.println(coll.ToString());
    }
}
