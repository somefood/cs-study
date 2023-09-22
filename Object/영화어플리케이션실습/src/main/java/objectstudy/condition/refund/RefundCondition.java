package objectstudy.condition.refund;


import objectstudy.domain.Refund;

public interface RefundCondition {

    boolean isSatisfiedBy(Refund refund);
}
