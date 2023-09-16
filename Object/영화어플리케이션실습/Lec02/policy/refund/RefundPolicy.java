package Lec02.policy.refund;

import Lec02.Money;
import Lec02.Refund;

public interface RefundPolicy {

    Money calculateRefundAmount(Refund refund);
}
