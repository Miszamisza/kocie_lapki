package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kocie_stopki.kocie.entity.Order;
import pl.kocie_stopki.kocie.repository.OrderRepo;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.repository.UserRepo;

@RestController("order")
public class OrderManager {
    private UserRepo userRepo;

    private OrderRepo orderRepo;

    @Autowired
    public OrderManager(UserRepo userRepo, OrderRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

//    @PostMapping("/saveorder")
//    public void saveOrder(){
//        orderItemsRespository.save(); //Basket save when ready
//    }

    @GetMapping("/searchorder")
    public String searchUser(@RequestParam int id){
        if (userRepo.findById(id).isPresent()) {
            User userToFind = userRepo.findById(id).get();
            return userToFind.toString();
        }
        return "There is no user with such id in database";
    }

    @GetMapping("/searchbyuser")
    public String searchOrder(@RequestParam int id){
        if (orderRepo.findById(id).isPresent()) {
            Order order = orderRepo.findById(id).get();
            return order.toString();
        }
        return "There is no order with such id in database";
    }
}
