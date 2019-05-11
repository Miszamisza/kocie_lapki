package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kocie_stopki.kocie.entity.Item;
import pl.kocie_stopki.kocie.entity.Order;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.services.DataBaseManager;

@RestController
public class KocieLapkiApi {
    private DataBaseManager dataBaseManager;

    @Autowired
    public KocieLapkiApi(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
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

    @PostMapping("/order/add")
    public void addOrderToDatabase(@RequestBody Order order) {
        dataBaseManager.addOrder(order);
    }

    @DeleteMapping("/order/delete")
    public String deleteOrderFromDatabase(@RequestBody Order order) {
        return dataBaseManager.deleteOrder(order);
    }

    @PutMapping("/order/update")
    public String updateOrderInDatabase(@RequestBody Order order) {
        return dataBaseManager.updateOrder(order);
    }

    @PostMapping("/user/add")
    public void addUserToDatabase(@RequestBody User user) {
        dataBaseManager.addUser(user);
    }

    @DeleteMapping("/user/delete")
    public String deleteUserFromDatabase(@RequestBody User user) {
        return dataBaseManager.deleteUser(user);
    }

    @PutMapping("/user/update")
    public String updateUserInDatabase(@RequestBody User user) {
        return dataBaseManager.updateUser(user);
    }
}
