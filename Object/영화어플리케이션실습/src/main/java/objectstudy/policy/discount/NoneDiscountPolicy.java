package objectstudy.policy.discount;

import objectstudy.domain.Money;
import objectstudy.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
