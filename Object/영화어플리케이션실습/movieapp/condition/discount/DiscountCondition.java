package movieapp.condition.discount;

import movieapp.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
