package movieApp.condition.discount;


import movieApp.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
