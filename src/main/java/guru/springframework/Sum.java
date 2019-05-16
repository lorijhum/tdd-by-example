package guru.springframework;

public class Sum implements Expression{

    Expression augmend;
    Expression addmend;

    Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }
     @Override
    public Money reduce(Bank bank, String toCurrency) {
        int amount = augmend.reduce(bank, toCurrency).amount + addmend.reduce(bank, toCurrency).amount;
        return new Money(amount, toCurrency);
    }

    @Override
    public Sum plus(Expression addend) {
        return new Sum(this.augmend, addmend );
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }


    public String oString() {
        return "Sum{" +
                "augmend=" + augmend +
                ", addmend=" + addmend +
                '}';
    }
}
