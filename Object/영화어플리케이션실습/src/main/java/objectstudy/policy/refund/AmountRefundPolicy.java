package objectstudy.policy.refund;

import objectstudy.Money;
import objectstudy.Refund;
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
