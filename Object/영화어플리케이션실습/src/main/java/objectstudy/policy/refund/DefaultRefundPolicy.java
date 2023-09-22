package objectstudy.policy.refund;

import objectstudy.Money;
import objectstudy.Refund;
import objectstudy.condition.refund.RefundCondition;

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
