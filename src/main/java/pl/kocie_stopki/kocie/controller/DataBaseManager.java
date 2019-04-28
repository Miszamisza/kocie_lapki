package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

}
