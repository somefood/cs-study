package objectstudy.policy.refund;

import objectstudy.domain.Money;
import objectstudy.domain.Refund;
import objectstudy.condition.refund.RefundCondition;

public class AmountRefundPolicy extends DefaultRefundPolicy{

    public AmountRefundPolicy(RefundCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Refund refund) {

        return refund.getMovieFee();
    }
}
