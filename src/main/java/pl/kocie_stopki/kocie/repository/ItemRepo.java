package pl.kocie_stopki.kocie.repository;

import pl.kocie_stopki.kocie.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Thic class is a repostitory for items. It provides create, remove, uptdate, delete functions.
 */
@Repository
public interface ItemRepo extends CrudRepository<Item, Integer> {
}
