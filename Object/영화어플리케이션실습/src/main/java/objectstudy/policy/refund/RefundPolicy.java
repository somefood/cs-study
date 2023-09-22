package objectstudy.policy.refund;

import objectstudy.Money;
import objectstudy.Refund;

public interface RefundPolicy {

    Money calculateRefundAmount(Refund refund);
}
