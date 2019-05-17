package pl.kocie_stopki.kocie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kocie_stopki.kocie.entity.Item;
import pl.kocie_stopki.kocie.repository.ItemRepo;


@Service
public class DataBaseManager {
    private ItemRepo itemRepo;

    @Autowired
    public DataBaseManager(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public void addItem(Item item) {
        itemRepo.save(item);
    }

    public String deleteItem(Item item) {
        if (itemRepo.findById(item.getId()).isPresent()) {
            Item itemToDelete = itemRepo.findById(item.getId()).get();
            itemRepo.delete(itemToDelete);
            return "Item " + itemToDelete.getName() + " has been deleted";
        }
        return "There is no item with such id in database";
    }

    public String updateItem(Item item) {
        if (itemRepo.findById(item.getId()).isPresent()) {
            Item itemToUpdate = itemRepo.findById(item.getId()).get();
            itemToUpdate.setName(item.getName());
            itemToUpdate.setPrice(item.getPrice());
            itemToUpdate.setDescription(item.getDescription());
            itemToUpdate.setQuantity(item.getQuantity());
            itemRepo.save(itemToUpdate);
            return "Item with id: " + item.getId() + " has been updated";
        }
        return "No item with id number: " + item.getId() + " in database";
    }
}
