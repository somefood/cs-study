package movieapp.policy.refund;

import movieapp.Money;
import movieapp.Refund;

public interface RefundPolicy {

    Money calculateRefundAmount(Refund refund);
}
