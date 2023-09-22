package objectstudy.condition.discount;

import objectstudy.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
