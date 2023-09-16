package Lec02.condition.discount;

import Lec02.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
