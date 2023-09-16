package movieapp;

public enum ScreenType {


    IMAX(Money.wons(23000)),
    DOLBYATMOS(Money.wons(19000)),
    BASIC(Money.wons(13000));


    private Money fee;

    private ScreenType(Money fee) {
        this.fee = fee;
    }

    public Money getFee() {
        return fee;
    }
}
