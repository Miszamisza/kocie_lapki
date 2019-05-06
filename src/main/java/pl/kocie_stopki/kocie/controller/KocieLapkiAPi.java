package pl.kocie_stopki.kocie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.kocie_stopki.kocie.entity.Item;
import pl.kocie_stopki.kocie.service.DataBaseManager;
import pl.kocie_stopki.kocie.service.OrderManagerImpl;

@RestController
public class KocieLapkiApi {
    @Qualifier("orderMenager")
    private OrderManagerImpl orderManager;
    @Autowired
    private DataBaseManager dataBaseManager;


    @PostMapping("/add")
    public void addItemToDatabase(@RequestBody Item item) {
        dataBaseManager.addItem(item);
    }

    @DeleteMapping("/delete")
    public String deleteItem(@RequestBody Item item) {
        return dataBaseManager.deleteItem(item);
    }

    @PutMapping("/update")
    public String updateItem(@RequestBody Item item) {
        return dataBaseManager.updateItem(item);
    }
    @GetMapping("/searchorder")
    public String searchUser(@RequestParam int id){
        return orderManager.searchUser(id);
    }

    @GetMapping("/searchbyuser")
    public String searchOrder(@RequestParam int id){
        return orderManager.searchOrder(id);
    }
}