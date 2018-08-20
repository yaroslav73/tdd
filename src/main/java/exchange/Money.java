package exchange;

import java.util.Objects;

class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Money reduce(String to) {
        return this;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount && Objects.equals(this.currency, money.currency);
    }
}
