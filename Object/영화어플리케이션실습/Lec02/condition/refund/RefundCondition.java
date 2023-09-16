package Lec02.condition.refund;


import Lec02.Refund;
import Lec02.Screening;

public interface RefundCondition {

    boolean isSatisfiedBy(Refund refund);
}
