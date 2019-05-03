package pl.kocie_stopki.kocie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kocie_stopki.kocie.entity.OrderItems;

@Repository
public interface OrderItemsRespository extends CrudRepository<OrderItems, Integer> {
}
