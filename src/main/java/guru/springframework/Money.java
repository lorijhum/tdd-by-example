package guru.springframework;

public class Money implements Expression{

    int amount;
    private String currency;


    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public  Expression times(int multiplier) {
        return new Money(amount*multiplier, this.currency);
    }

    String currency() {
        return currency;
    }


     static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Money reduce(Bank bank, String toCurrency) {
        return new Money(amount / bank.rate(this.currency, toCurrency), toCurrency);
    }


    public Expression plus(Expression addend){
        return new Sum(this,addend);
    }

    public boolean equals(Object object) {
        Money money = (Money)object;
        return amount == money.amount &&
                this.currency == money.currency;

    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

}
