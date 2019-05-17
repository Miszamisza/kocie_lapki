package pl.kocie_stopki.kocie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kocie_stopki.kocie.entity.Order;

/**
 * Thic class is a repostitory for orders. It provides create, remove, uptdate, delete functions.
 */
@Repository
public interface OrderRespository extends CrudRepository<Order, Integer> {
}
