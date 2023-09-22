package objectstudy;

import objectstudy.condition.discount.PeriodCondition;
import objectstudy.condition.discount.SequenceCondition;
import objectstudy.condition.refund.TimeCondition;
import objectstudy.policy.discount.AmountDiscountPolicy;
import objectstudy.policy.refund.AmountRefundPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;


class MovieTest {


    @Test
    @DisplayName("테스트 : 할인 조건(순번,기간 조건)에 부합하면 양적 할인 가격 적용된다.")
    void amountTest1() {
        Movie amountMovie = new Movie(
                "오펜하이머",
                Duration.ofMillis(180),
                Money.wons(12000),
                new AmountDiscountPolicy(
                        Money.wons(2000),
                        new SequenceCondition(1), new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))
                ),
                new AmountRefundPolicy(new TimeCondition(LocalDateTime.now()))
        );

        //when
        Screening testScreening1 = new Screening(amountMovie, 1, LocalDateTime.of(2023, 9, 13, 10, 10));

        Money fee1 = testScreening1.calculateFee(1);

        // then
        Assertions.assertThat(amountMovie.getFee().minus(Money.wons(2000))).isEqualTo(fee1);
    }
}