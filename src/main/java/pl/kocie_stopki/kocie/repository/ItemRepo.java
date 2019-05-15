package pl.kocie_stopki.kocie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kocie_stopki.kocie.entity.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer> {
}
