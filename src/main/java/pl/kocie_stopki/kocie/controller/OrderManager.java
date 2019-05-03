package pl.kocie_stopki.kocie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kocie_stopki.kocie.entity.Order;
import pl.kocie_stopki.kocie.repository.OrderRespository;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.repository.UserRepository;

@RestController("order")
public class OrderManager {
    private UserRepository userRepository;

    private OrderRespository orderRespository;

    @Autowired
    public OrderManager(UserRepository userRepository, OrderRespository orderRespository) {
        this.userRepository = userRepository;
        this.orderRespository = orderRespository;
    }

//    @PostMapping("/saveorder")
//    public void saveOrder(){
//        orderItemsRespository.save(); //Basket save when ready
//    }

    @GetMapping("/searchorder")
    public String searchUser(@RequestParam int id){
        if (userRepository.findById(id).isPresent()) {
            User userToFind = userRepository.findById(id).get();
            return userToFind.toString();
        }
        return "There is no user with such id in database";
    }

    @GetMapping("/searchbyuser")
    public String searchOrder(@RequestParam int id){
        if (orderRespository.findById(id).isPresent()) {
            Order order = orderRespository.findById(id).get();
            return order.toString();
        }
        return "There is no order with such id in database";
    }
}
