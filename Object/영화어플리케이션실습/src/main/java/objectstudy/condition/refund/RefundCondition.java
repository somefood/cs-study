package objectstudy.condition.refund;


import objectstudy.Refund;
import objectstudy.Screening;

public interface RefundCondition {

    boolean isSatisfiedBy(Refund refund);
}
