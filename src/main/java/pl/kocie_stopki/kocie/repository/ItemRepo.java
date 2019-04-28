package pl.kocie_stopki.kocie.repository;

import pl.kocie_stopki.kocie.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer> {
}
