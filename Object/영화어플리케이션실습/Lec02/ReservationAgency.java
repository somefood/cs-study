package Lec02;

import Lec02.condition.discount.DiscountCondition;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount){

        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
