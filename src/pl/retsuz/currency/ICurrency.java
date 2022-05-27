package pl.retsuz.currency;

public interface ICurrency {
    public void setName(String name);
    public void setCode(String code);
    public void setRate(double rate);
    public void setFactor(double factor);
    public String getName();
    public String getCode();
    public double getFactor();
    public double getRate();
}
