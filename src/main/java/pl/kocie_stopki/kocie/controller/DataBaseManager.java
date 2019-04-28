package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kocie_stopki.kocie.entity.Item;
import pl.kocie_stopki.kocie.repository.ItemRepo;

@RestController
public class DataBaseManager {
    private ItemRepo itemRepo;

    @Autowired
    public DataBaseManager(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @PostMapping("/add")
    public void addItem(@RequestBody Item item) {
        itemRepo.save(item);
    }

    @DeleteMapping("/delete")
    public String deleteItem(@RequestParam int id) {
        if (itemRepo.findById(id).isPresent()) {
            Item itemToDelete = itemRepo.findById(id).get();
            itemRepo.delete(itemToDelete);
            return "Item " + itemToDelete.getName() + " has been deleted";
        }
        return "There is no item with such id in database";
    }

    @PutMapping("/update")
    public String updateItem(@RequestParam int id,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "price", required = false) Double price,
                             @RequestParam(value = "description", required = false) String description) {
        if (itemRepo.findById(id).isPresent()) {
            Item itemToUpdate = itemRepo.findById(id).get();
            if (name != null) {
                itemToUpdate.setName(name);
            }
            if (price != null) {
                itemToUpdate.setPrice(price);
            }
            if (description != null) {
                itemToUpdate.setDescription(description);
            }
            itemRepo.save(itemToUpdate);
            return "Item with id: " + id + " has been updated";
        }
        return "No item with id number: " + id + " in database";
    }
}
