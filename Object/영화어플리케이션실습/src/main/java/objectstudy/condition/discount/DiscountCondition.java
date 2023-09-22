package objectstudy.condition.discount;

import objectstudy.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
