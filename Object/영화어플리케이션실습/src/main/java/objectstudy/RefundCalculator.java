package objectstudy;

import objectstudy.policy.refund.RefundPolicy;

/**
 * refundCalculate 역할 :
 *                 책임 : 환불 금액 계산
 */
public class RefundCalculator {

    private RefundPolicy refundPolicy;
    private Money fee;

    public Money getFee() {
        return fee;
    }

    public RefundCalculator(RefundPolicy refundPolicy) {
        this.refundPolicy = refundPolicy;
    }


    public Money calculateRefundFee(Refund refund) {
        return refundPolicy.calculateRefundAmount(refund);
    }


}

