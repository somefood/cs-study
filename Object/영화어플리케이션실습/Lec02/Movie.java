package Lec02;

import Lec02.policy.discount.DiscountPolicy;
import Lec02.policy.refund.RefundPolicy;

import java.time.Duration;

/**
 * Movie : 예매하는 대상의 정보를 갖고 있다.
 *       책임 : 예매 대상 금액 계산
 *
 */
public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;
    private RefundPolicy refundPolicy;


    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy,RefundPolicy refundPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
        this.refundPolicy = refundPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public Money calculateRefundFee(Refund refund){
        return refundPolicy.calculateRefundAmount(refund);
    }

    public void changDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
