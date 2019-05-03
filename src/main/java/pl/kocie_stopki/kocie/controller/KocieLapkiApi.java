package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kocie_stopki.kocie.entity.Item;

@RestController
public class KocieLapkiApi {
    private DataBaseManager dataBaseManager;

    @Autowired
    public KocieLapkiApi(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    @PostMapping("/add")
    public void addItemToDatabase(@RequestBody Item item) {
        dataBaseManager.addItem(item);
    }

    @DeleteMapping("/delete")
    public String deleteItemFromDatabase(@RequestBody Item item) {
        return dataBaseManager.deleteItem(item);
    }

    @PutMapping("/update")
    public String updateItemInDatabase(@RequestBody Item item) {
        return dataBaseManager.updateItem(item);
    }
}
