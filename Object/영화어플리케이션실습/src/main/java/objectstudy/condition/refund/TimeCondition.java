package objectstudy.condition.refund;


import objectstudy.Refund;
import objectstudy.Screening;

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
