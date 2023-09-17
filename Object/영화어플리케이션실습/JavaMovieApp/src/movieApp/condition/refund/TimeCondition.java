package movieApp.condition.refund;



import movieApp.Refund;

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
