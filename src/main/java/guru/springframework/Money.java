package guru.springframework;

public class Money implements Expression{

    protected int amount;
    protected String currency;


    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public  Money times(int multiplier) {
        return new Money(amount*multiplier, this.currency);
    };

    protected String currency() {
        return currency;
    }


    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Money reduce(String toCurrency) {
        return this;
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

    public Expression plus(Money augmend) {
        return new Sum(this,augmend );
    }
}
