package Lec02;

import Lec02.condition.discount.PeriodCondition;
import Lec02.condition.discount.SequenceCondition;
import Lec02.condition.refund.TimeCondition;
import Lec02.policy.discount.AmountDiscountPolicy;
import Lec02.policy.discount.PercentDiscountPolicy;
import Lec02.policy.refund.AmountRefundPolicy;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppTest {
    public static void main(String[] args) {

        System.out.println("============================ ");

        System.out.println("AmountDiscountPolicy 예매 테스트");

        System.out.println("============================ ");

        //given

        Movie amountMovie = new Movie("오펜하이머",
                Duration.ofMillis(180),
                Money.wons(12000),
                new AmountDiscountPolicy(Money.wons(2000),
                        new SequenceCondition(1), new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)
                        )

                ),new AmountRefundPolicy(new TimeCondition(LocalDateTime.now()))
        );

        //when
        Screening testScreening1 = new Screening(amountMovie, 1, LocalDateTime.of(2023, 9, 13, 10, 10));

        Money fee1 = testScreening1.calculateFee(1);

        System.out.println("테스트 : 할인 조건(순번,기간 조건)에 부합하면 양적 할인 가격 적용된다.");

        // then
        if (fee1.equals(amountMovie.getFee().minus(Money.wons(2000)))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        //when
        Screening testScreening2 = new Screening(amountMovie, 1, LocalDateTime.of(2023, 9, 13, 14, 10));


        Money fee2 = testScreening1.calculateFee(1);

        System.out.println("테스트 : 할인 조건(순번 조건)에 부합하면 양적 할인 가격 적용된다.");
        //then
        if (fee1.equals(amountMovie.getFee().minus(Money.wons(2000)))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        //when
        Screening testScreening3 = new Screening(amountMovie, 4, LocalDateTime.of(2023, 9, 13, 10, 10));

        Money fee3 = testScreening1.calculateFee(1);

        System.out.println("테스트 : 할인 조건(기간 조건)에 부합하면 양적 할인 가격 적용된다.");
        //then
        if (fee3.equals(Money.wons(10000))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        System.out.println("테스트 : 할인 조건에 부합하지 않으면 양적 할인이 적용되지 않는다.");

        Screening testScreening4 = new Screening(amountMovie, 4, LocalDateTime.of(2023, 9, 14, 15, 10));

        Money fee4 = testScreening4.calculateFee(1);

        if (fee4.equals(amountMovie.getFee())) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        System.out.println("테스트 : 여러명이 티켓을 구매할 경우 값을 계산할 수 있다.");


        Money fee4_1 = testScreening4.calculateFee(2);

        if (fee4_1.equals(Money.wons(12000).times(2))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        System.out.println("============================ ");

        System.out.println("PolicyDiscountPolicy 예매 테스트");

        System.out.println("============================ ");

        Movie percentMovie = new Movie("엘리멘탈",
                Duration.ofMillis(180),
                Money.wons(13000),
                new PercentDiscountPolicy(0.1,
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))
                ),new AmountRefundPolicy(new TimeCondition(LocalDateTime.now())));

        Screening testScreening5 = new Screening(percentMovie, 2, LocalDateTime.of(2023, 9, 14, 10, 10));

        Money fee5 = testScreening5.calculateFee(1);

        System.out.println("테스트 : 할인 조건(순번,기간 조건)에 부합하면 비율 할인 가격 적용된다.");

        // then
        if (fee5.equals(percentMovie.getFee().times(0.9))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        //given
        Screening testScreening6 = new Screening(percentMovie, 2, LocalDateTime.of(2023, 9, 13, 14, 10));

        //when
        Money fee6 = testScreening6.calculateFee(1);

        System.out.println("테스트 : 할인 조건(순번 조건)에 부합하면 비율 할인 가격 적용된다.");

        //then
        if (fee6.equals(Money.wons(13000).times(0.9))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        //given
        Screening testScreening7 = new Screening(percentMovie, 4, LocalDateTime.of(2023, 9, 12, 10, 10));

        //when
        Money fee7 = testScreening7.calculateFee(1);

        System.out.println("테스트 : 할인 조건(기간 조건)에 부합하면 비율 할인 가격 적용된다.");

        //then
        if (fee7.equals(Money.wons(13000).times(0.9))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        System.out.println("테스트 : 할인 조건에 부합하지 않으면 비율 할인이 적용되지 않는다.");

        //given
        Screening testScreening8 = new Screening(percentMovie, 4, LocalDateTime.of(2023, 9, 14, 15, 10));

        //when
        Money fee8 = testScreening8.calculateFee(1);

        //then
        if (fee8.equals(Money.wons(13000))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");



        System.out.println("============================ ");

        System.out.println("AmountRefundPolicy 예매 취소 테스트");

        System.out.println("============================ ");

        /*
        Movie AmountMovie = new Movie("오펜하이머",
                Duration.ofMillis(180),
                Money.wons(12000),
                new AmountDiscountPolicy(Money.wons(2000),
                        new SequenceCondition(1), new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)
                        )

                ),new AmountRefundPolicy(new TimeCondition(LocalDateTime.now()))
        );
        */


        //given

        Screening testScreening9 = new Screening(amountMovie, 2, LocalDateTime.of(2023, 9, 12, 10, 10));
        Money reserveFee1 = testScreening9.calculateFee(1);

        //when

        Refund testRefund = new Refund(testScreening9, new AmountRefundPolicy(new TimeCondition(LocalDateTime.now())),1);


        Money refundFee1 = testRefund.calculateRefundFee(1);

        System.out.println("테스트 : 환불 조건에 부합하지 않으면 환불되지 않는다.");
        //then
        if (refundFee1.equals(Money.wons(0))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");



        Screening testScreening10 = new Screening(amountMovie, 2, LocalDateTime.of(2023, 9, 30, 10, 10));
        Money reserveFee10 = testScreening9.calculateFee(1);

        //when

        Refund testRefund2 = new Refund(testScreening10, new AmountRefundPolicy(new TimeCondition(LocalDateTime.now())),1);

        Money refundFee2 = testRefund2.calculateRefundFee(1);
        System.out.println("테스트 : 환불 조건에 부합하면, 전액 환불 된다.");


        //then
        if (refundFee2.equals(Money.wons(12000))) {
            System.out.println("테스트 성공");
        } else
            System.out.println("테스트 실패");

        System.out.println("============================ ");
    }
}
