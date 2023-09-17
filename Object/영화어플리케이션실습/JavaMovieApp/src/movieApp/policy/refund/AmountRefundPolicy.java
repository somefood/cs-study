package movieApp.policy.refund;


import movieApp.Money;
import movieApp.Refund;
import movieApp.condition.refund.RefundCondition;

public class AmountRefundPolicy extends DefaultRefundPolicy{

    public AmountRefundPolicy(RefundCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Refund refund) {

        return refund.getMovieFee();
    }
}
