package objectstudy.policy.discount;

import objectstudy.domain.Money;
import objectstudy.domain.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);


}
