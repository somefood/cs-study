package movieapp.policy.discount;

import movieapp.Money;
import movieapp.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);


}
