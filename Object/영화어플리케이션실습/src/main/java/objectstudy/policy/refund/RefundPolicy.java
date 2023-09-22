package objectstudy.policy.refund;

import objectstudy.domain.Money;
import objectstudy.domain.Refund;

public interface RefundPolicy {

    Money calculateRefundAmount(Refund refund);
}
