package objectstudy.initializer;

import objectstudy.Money;
import objectstudy.Movie;
import objectstudy.condition.discount.PeriodCondition;
import objectstudy.condition.discount.SequenceCondition;
import objectstudy.condition.refund.TimeCondition;
import objectstudy.policy.discount.AmountDiscountPolicy;
import objectstudy.policy.discount.DiscountPolicy;
import objectstudy.policy.discount.PercentDiscountPolicy;
import objectstudy.policy.refund.AmountRefundPolicy;
import objectstudy.policy.refund.RefundPolicy;
import objectstudy.repository.MovieRepository;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class MovieInit {

    public static LinkedHashMap<Long,Movie> createMovieData(MovieRepository movieRepository) {
        Movie movie1 = makeMovie(
                "오펜하이머",
                Duration.ofMinutes(180),
                Money.wons(12000),
                new AmountDiscountPolicy(
                        Money.wons(2000),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))
                ),
                new AmountRefundPolicy(new TimeCondition(LocalDateTime.now()))
        );
        movieRepository.save(movie1);

        Movie movie2 = makeMovie(
                "엘리멘탈",
                Duration.ofMinutes(180),
                Money.wons(13000),
                new PercentDiscountPolicy(
                        0.1,
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))
                ),
                new AmountRefundPolicy(new TimeCondition(LocalDateTime.now()))
        );
        movieRepository.save(movie2);

        return movieRepository.findAll();
    }

    public static Movie makeMovie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy, RefundPolicy refundPolicy) {
        return new Movie(title, runningTime, fee, discountPolicy, refundPolicy);
    }
}
