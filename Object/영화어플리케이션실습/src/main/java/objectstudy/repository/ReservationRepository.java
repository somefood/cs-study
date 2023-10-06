package objectstudy.repository;

import objectstudy.Reservation;
import objectstudy.Screening;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ReservationRepository {

    private Long reservationId = 1L;
    private LinkedHashMap<Long, Reservation> reservationDict = new LinkedHashMap<>();

    public void save(Reservation reservation) {
        reservationDict.put(reservationId++,reservation );
    }

    public Optional<Reservation> findById(Long reservationId) {
        return Optional.of(reservationDict.get(reservationId));
    }



    public Reservation findByCustomer(String customerName){

        for (Reservation reservation : reservationDict.values()) {

            if (reservation.getCustomerName().equals(customerName)) {
                return reservation;
            }
        }
        return null;
    }




    public LinkedHashMap<Long, Reservation> findAll()
    {
        return (LinkedHashMap<Long, Reservation>) reservationDict.clone();
    }

    /**
     *  예약 정보 삭제 메소드
     *
     * @param reservation
     */
    public Long delete(Reservation reservation) {

        for (Map.Entry<Long, Reservation> reservationEntry : reservationDict.entrySet()) {
            if (reservationEntry.getValue().equals(reservation)) {

                Long deleteKey = reservationEntry.getKey();


                reservationDict.remove(deleteKey);

                return deleteKey;
            }
        }

        throw new RuntimeException("존재하지 않는 예매 정보입니다.");

    }
}
