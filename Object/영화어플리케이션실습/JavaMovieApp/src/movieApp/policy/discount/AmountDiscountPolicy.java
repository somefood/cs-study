package movieApp.policy.discount;


import movieApp.Money;
import movieApp.Screening;
import movieApp.condition.discount.DiscountCondition;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {


    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
