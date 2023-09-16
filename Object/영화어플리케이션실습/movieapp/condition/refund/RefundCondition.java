package movieapp.condition.refund;


import movieapp.Refund;

public interface RefundCondition {

    boolean isSatisfiedBy(Refund refund);
}
