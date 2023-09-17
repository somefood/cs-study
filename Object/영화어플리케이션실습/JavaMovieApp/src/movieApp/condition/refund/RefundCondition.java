package movieApp.condition.refund;


import movieApp.Refund;

public interface RefundCondition {

    boolean isSatisfiedBy(Refund refund);
}
