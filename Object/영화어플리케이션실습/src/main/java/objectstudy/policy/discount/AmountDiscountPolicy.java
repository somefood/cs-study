package objectstudy.policy.discount;

import objectstudy.condition.discount.DiscountCondition;
import objectstudy.Money;
import objectstudy.Screening;

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
