package objectstudy;

import objectstudy.condition.discount.PeriodCondition;
import objectstudy.condition.discount.SequenceCondition;
import objectstudy.condition.refund.TimeCondition;
import objectstudy.policy.discount.AmountDiscountPolicy;
import objectstudy.policy.discount.PercentDiscountPolicy;
import objectstudy.policy.refund.AmountRefundPolicy;
import objectstudy.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.*;


class MovieTest {


    private ReservationRepository reservationRepository = new ReservationRepository();

    private static Movie amountMovie = new Movie(
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

    private static Movie percentMovie = new Movie("엘리멘탈",
            Duration.ofMillis(180),
            Money.wons(13000),
            new PercentDiscountPolicy(0.1,
                    new SequenceCondition(2),
                    new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                    new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))
            ), new AmountRefundPolicy(new TimeCondition(LocalDateTime.now())));

    @Test
    @DisplayName("할인 조건 부합하지 않으면, 할인 적용 X")
    void test1() {

        //given
        Screening testScreening1 = new Screening(amountMovie, 4, LocalDateTime.of(2023, 9, 22, 10, 10));

        //when
        Money fee = testScreening1.calculateFee(1);

        // then
        assertThat(amountMovie.getFee()).isEqualTo(fee);
    }


    @Test
    @DisplayName("할인 조건 부합하면 양적 할인 가격 적용")
    void amountTest1() {

        //given
        Screening testScreening1 = new Screening(amountMovie, 1, LocalDateTime.of(2023, 9, 13, 10, 10));

        //when
        Money fee = testScreening1.calculateFee(1);

        // then
        assertThat(amountMovie.getFee().minus(Money.wons(2000))).isEqualTo(fee);
    }

    @Test
    @DisplayName("양적할인, 1명 이상의 인원 예매")
    void amountTest2() {


        //given
        Screening testScreening1 = new Screening(amountMovie, 1, LocalDateTime.of(2023, 9, 13, 10, 10));

        //when
        Money fee = testScreening1.calculateFee(2);

        // then
        assertThat(amountMovie.getFee().minus(Money.wons(2000)).times(2)).isEqualTo(fee);
    }


    @Test
    @DisplayName("할인조건 부합하면 비율할인 적용")
    void percentTest() {

        //given
        Screening testScreening5 = new Screening(percentMovie, 2, LocalDateTime.of(2023, 9, 14, 10, 10));

        //when
        Money fee = testScreening5.calculateFee(1);

        //then
        assertThat(percentMovie.getFee().minus(percentMovie.getFee().times(0.1))).isEqualTo(fee);
    }

    @Test
    @DisplayName("예약 성공 테스트")
    void reserveTest1() {

        //given
        Customer customer = new Customer("김승옥");
        int audienceCount = 1;

        Screening screening = new Screening(amountMovie, 2, LocalDateTime.of(2023, 9, 14, 10, 10));


        //when

        ReservationAgency reservationAgency = new ReservationAgency();
        Reservation reserveResult = reservationAgency.reserve(screening, customer, 1);
        reservationRepository.save(reserveResult);

        //then

        Reservation reservation = reservationRepository.findByCustomer("김승옥");
        assertThat(reservation).isEqualTo(reserveResult);


    }

    @Test
    @DisplayName("예약 실패 테스트 - 상영 정보가 없으면 예약되지 않는다.")
    void reserveTest2() {

        //given
        Customer customer = new Customer("김승옥");
        int audienceCount = 1;

        Screening screening = new Screening(amountMovie, 4, LocalDateTime.of(2023, 9, 14, 10, 10));


        //when

        ReservationAgency reservationAgency = new ReservationAgency();
        Reservation reserveResult = reservationAgency.reserve(screening, customer, 1);

        //then

        Reservation reservation = reservationRepository.findByCustomer("김승옥");
        assertThat(reservation).isNull();


    }

    @Test
    @DisplayName("환불 성공")
    void refundTest1(){
        //given

        Customer customer = new Customer("김승옥");
        int audienceCount = 1;

        Screening screening = new Screening(amountMovie, 2, LocalDateTime.of(2023, 9, 14, 10, 10));

        ReservationAgency reservationAgency = new ReservationAgency();
        Reservation reserveResult = reservationAgency.reserve(screening, customer, 1);
        reservationRepository.save(reserveResult);

        //when
        Refund refund = reserveResult.refund();
        reservationRepository.delete(reserveResult);
        refundRepository.save(refund);

        //then
        Assertions.assertThat(refund.getReservation().getCustomerName()).isEqualTo(reserveResult.getCustomerName());
        Assertions.assertThat(refund.getMovieFee()).isEqualTo(reserveResult.getFee());

    }


}