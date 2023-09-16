package movieapp.policy.refund;

import movieapp.Money;
import movieapp.Refund;
import movieapp.condition.refund.RefundCondition;

public class AmountRefundPolicy extends DefaultRefundPolicy{

    public AmountRefundPolicy(RefundCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Refund refund) {

        return refund.getMovieFee();
    }
}
