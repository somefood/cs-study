package movieApp.policy.discount;


import movieApp.Money;
import movieApp.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);


}
