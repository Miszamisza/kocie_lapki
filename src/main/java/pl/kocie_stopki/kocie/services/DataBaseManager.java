package pl.kocie_stopki.kocie.services;

import org.springframework.stereotype.Service;
import pl.kocie_stopki.kocie.entity.Item;
import pl.kocie_stopki.kocie.entity.Order;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.repository.ItemRepo;
import pl.kocie_stopki.kocie.repository.OrderRepo;
import pl.kocie_stopki.kocie.repository.UserRepo;


@Service
public class DataBaseManager {
    private ItemRepo itemRepo;
    private OrderRepo orderRepo;
    private UserRepo userRepo;

    public DataBaseManager(ItemRepo itemRepo, OrderRepo orderRepo, UserRepo userRepo) {
        this.itemRepo = itemRepo;
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
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
        return "No item with id number: " + item.getId() + " in database";
    }

    public String updateItem(Item item) {
        if (itemRepo.findById(item.getId()).isPresent()) {
            Item itemToUpdate = itemRepo.findById(item.getId()).get();
            itemToUpdate.setName(item.getName());
            itemToUpdate.setPrice(item.getPrice());
            itemToUpdate.setDescription(item.getDescription());
            itemToUpdate.setQuantity(item.getQuantity());
            itemRepo.save(itemToUpdate);
            return "Item with id: " + itemToUpdate.getId() + " has been updated";
        }
        return "No item with id number: " + item.getId() + " in database";
    }

    public void addOrder(Order order) {
        orderRepo.save(order);
    }

    public String deleteOrder(Order order) {
        if (orderRepo.findById(order.getId()).isPresent()) {
            Order orderToDelete = orderRepo.findById(order.getId()).get();
            orderRepo.delete(orderToDelete);
            return "Order with id: " + orderToDelete.getId() + " has been deleted";
        }
        return "No order with id number: " + order.getId() + " in database";
    }

    public String updateOrder(Order order) {
        if (orderRepo.findById(order.getId()).isPresent()) {
            Order orderToUpdate = orderRepo.findById(order.getId()).get();
            orderToUpdate.setUser(order.getUser());
            orderToUpdate.setItem(order.getItem());
            orderRepo.save(orderToUpdate);
            return "Order with id: " + orderToUpdate.getId() + " has been updated";
        }
        return "No order with id number: " + order.getId() + " in database";
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public String deleteUser(User user) {
        if (userRepo.findById(user.getId()).isPresent()) {
            User userToDelete = userRepo.findById(user.getId()).get();
            userRepo.delete(userToDelete);
            return "User: " + userToDelete.getLogin() + " has been deleted";
        }
        return "No item with id number: " + user.getId() + " in database";
    }

    public String updateUser(User user) {
        if (userRepo.findById(user.getId()).isPresent()) {
            User userToUpdate = userRepo.findById(user.getId()).get();
            userToUpdate.setLogin(user.getLogin());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setActive(user.isActive());
            userRepo.save(userToUpdate);
            return "User with id: " + userToUpdate.getId() + " has been updated";
        }
        return "No user with id number: " + user.getId() + " in database";
    }
}
