package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kocie_stopki.kocie.entity.Item;
import pl.kocie_stopki.kocie.entity.Order;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.services.DataBaseManager;

import java.util.ArrayList;
import java.util.List;

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

//    @GetMapping("/getMeeeeee")
//    public Order getOreder() {
////        User user = new User();
////        user.setEmail("kotki@mail.com");
////        user.setPassword("1234");
////        user.setLogin("kotek2000");
////        user.setActive(true);
////        List<Item> items = new ArrayList<>();
////        items.add(new Item(1, "łapka", 10.50, "piękna pachnąca łapka", 50, "http:www:asdsad.pl"));
////        items.add(new Item(2, "kuweta", 15.30, "duża kuweta", 100, "http:www:gggdhhtusjj.pl"));
////        Order or = new Order();
////        or.setUser(user);
////        or.setItem(items);
////        return or;
//    }


    @DeleteMapping("/user/delete")
    public String deleteUserFromDatabase(@RequestBody User user) {
        return dataBaseManager.deleteUser(user);
    }

    @PutMapping("/user/update")
    public String updateUserInDatabase(@RequestBody User user) {
        return dataBaseManager.updateUser(user);
    }
}
