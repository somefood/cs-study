package objectstudy;

public enum ScreenType {


    IMAX(Money.wons(20000)),
    SCREENX(Money.wons(17000)),
    BASIC(Money.wons(13000));





    private Money fee;

    private ScreenType(Money fee) {
        this.fee = fee;
    }

    public Money getFee() {
        return fee;
    }
}
