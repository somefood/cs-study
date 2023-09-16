package Lec02.policy.discount;

import Lec02.Money;
import Lec02.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);


}
