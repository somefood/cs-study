package objectstudy.policy.discount;

import objectstudy.Money;
import objectstudy.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);


}
