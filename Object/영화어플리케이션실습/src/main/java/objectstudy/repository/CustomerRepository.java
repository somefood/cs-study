package objectstudy.repository;

import objectstudy.Customer;
import objectstudy.Movie;

import java.util.LinkedHashMap;
import java.util.Optional;

public class CustomerRepository {

    private Long customerId = 1L;

    private LinkedHashMap<Long, Customer> customerDict = new LinkedHashMap<>();

    public void save(Customer customer) {
        customerDict.put(customerId++, customer);
    }

    public Optional<Customer> findById(Long customerIdId) {
        return Optional.of(customerDict.get(customerIdId));
    }


}
