package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kocie_stopki.kocie.entity.Item;
import pl.kocie_stopki.kocie.entity.Order;
import pl.kocie_stopki.kocie.services.DataBaseManager;

@RestController
public class KocieLapkiApi {
    private DataBaseManager dataBaseManager;

    @Autowired
    public KocieLapkiApi(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    @GetMapping("/item/getAll")
    public Iterable<Item> getAllItems() {
        return dataBaseManager.findAllItems();
    }

    @GetMapping("/item/get")
    public Item getItem(@RequestParam Integer id) {
        return dataBaseManager.findSingleItem(id);
    }

    @PostMapping("/item/add")
    public void addItemToDatabase(@RequestBody Item item) {
        dataBaseManager.addItem(item);
    }

    @DeleteMapping("/item/delete")
    public String deleteItemFromDatabase(@RequestBody Item item) {
        return dataBaseManager.deleteItem(item);
    }

    @PutMapping("/item/update")
    public String updateItemInDatabase(@RequestBody Item item) {
        return dataBaseManager.updateItem(item);
    }

    @GetMapping("/order/getAll")
    public Iterable<Order> getOrderFromDatabase() {
        return dataBaseManager.findAllOrders();
    }

    @GetMapping("/order/get")
    public Order getOrder(@RequestParam Integer id) {
        return dataBaseManager.findSingleOrder(id);
    }

    @PostMapping("/order/add")
    public void addOrderToDatabase(@RequestBody Order order) {
        dataBaseManager.addOrder(order);
    }

    @DeleteMapping("/order/delete")
    public String deleteOrderFromDatabase(@RequestBody Order order) {
        return dataBaseManager.deleteOrder(order);
    }
}
