package movieApp.policy.refund;


import movieApp.Money;
import movieApp.Refund;

public interface RefundPolicy {

    Money calculateRefundAmount(Refund refund);
}
