package Lec02.policy.refund;

import Lec02.Money;
import Lec02.Refund;
import Lec02.Screening;
import Lec02.condition.discount.DiscountCondition;
import Lec02.condition.refund.RefundCondition;

import java.util.List;

public class AmountRefundPolicy extends DefaultRefundPolicy{

    public AmountRefundPolicy(RefundCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Refund refund) {

        return refund.getMovieFee();
    }
}
