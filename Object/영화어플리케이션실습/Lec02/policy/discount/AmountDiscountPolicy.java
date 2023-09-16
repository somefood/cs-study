package Lec02.policy.discount;

import Lec02.condition.discount.DiscountCondition;
import Lec02.Money;
import Lec02.Screening;

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
