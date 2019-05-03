package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.kocie_stopki.kocie.entity.Item;
import pl.kocie_stopki.kocie.repository.ItemRepo;

@Controller
public class DataBaseManager {
    private ItemRepo itemRepo;

    @Autowired
    public DataBaseManager(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    void addItem(Item item) {
        itemRepo.save(item);
    }

    String deleteItem(Item item) {
        if (itemRepo.findById(item.getId()).isPresent()) {
            Item itemToDelete = itemRepo.findById(item.getId()).get();
            itemRepo.delete(itemToDelete);
            return "Item " + itemToDelete.getName() + " has been deleted";
        }
        return "There is no item with such id in database";
    }

    String updateItem(Item item) {
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
