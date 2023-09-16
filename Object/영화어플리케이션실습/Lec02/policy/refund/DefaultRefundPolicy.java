package Lec02.policy.refund;

import Lec02.Money;
import Lec02.Refund;
import Lec02.Screening;
import Lec02.condition.refund.RefundCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class DefaultRefundPolicy implements RefundPolicy {

    private List<RefundCondition> conditions = new ArrayList<>();

    public DefaultRefundPolicy(RefundCondition... conditions) {

        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateRefundAmount(Refund refund) {
        for(RefundCondition each : conditions) {
            if (each.isSatisfiedBy(refund)) {
                return getDiscountAmount(refund);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Refund refund);
}
