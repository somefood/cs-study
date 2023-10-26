package objectstudy.repository;

import objectstudy.Refund;
import objectstudy.Reservation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class RefundRepository {

    private Long refundId = 1L;
    private LinkedHashMap<Long, Refund> refundDict = new LinkedHashMap<>();

    public void save(Refund refund) {
        refundDict.put(refundId++,refund);}

    public Optional<Refund> findById(Long refundId) {
        return Optional.of(refundDict.get(RefundRepository.this.refundId));
    }



    public LinkedHashMap<Long, Refund> findAll()
    {
        return (LinkedHashMap<Long, Refund>) refundDict.clone();
    }


}
