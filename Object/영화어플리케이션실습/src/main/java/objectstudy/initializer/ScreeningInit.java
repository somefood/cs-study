package objectstudy.initializer;

import objectstudy.Money;
import objectstudy.Movie;
import objectstudy.Screening;
import objectstudy.condition.discount.PeriodCondition;
import objectstudy.condition.discount.SequenceCondition;
import objectstudy.condition.refund.TimeCondition;
import objectstudy.policy.discount.AmountDiscountPolicy;
import objectstudy.policy.discount.DiscountPolicy;
import objectstudy.policy.discount.PercentDiscountPolicy;
import objectstudy.policy.refund.AmountRefundPolicy;
import objectstudy.policy.refund.RefundPolicy;
import objectstudy.repository.MovieRepository;
import objectstudy.repository.ScreeningRepository;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashMap;

public class ScreeningInit {



    public static void createScreeningData(ScreeningRepository screeningRepository,LinkedHashMap<Long,Movie> movieData) {

        Screening screening1 = makeScreening(movieData.get(1L), 2, LocalDateTime.of(2023, 9, 14, 15, 10));

        screeningRepository.save(screening1);

        Screening screening2 = makeScreening(movieData.get(2L), 2, LocalDateTime.of(2023, 9, 14, 15, 10));


        screeningRepository.save(screening2);

    }

    public static Screening makeScreening(Movie movie,Integer sequence,LocalDateTime whenScreened) {
        return new Screening(movie, sequence, whenScreened);
    }

}
