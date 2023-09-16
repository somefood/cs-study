package Lec02.condition.refund;


import Lec02.Refund;
import Lec02.Screening;

import java.time.LocalDateTime;

public class TimeCondition implements RefundCondition {

    private LocalDateTime currentTime;

    public TimeCondition(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public boolean isSatisfiedBy(Refund refund) {
        return currentTime.compareTo(refund.getMovieStartTime()) <= 0;
    }
}
