package pl.kocie_stopki.kocie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kocie_stopki.kocie.entity.OrderItems;
import pl.kocie_stopki.kocie.repository.OrderItemsRespository;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.repository.UserRepository;

@Service("orderManager")
public class OrderManagerImpl implements OrderMenager{

    private UserRepository userRepository;
    private OrderItemsRespository orderItemsRespository;

    @Autowired
    public OrderManagerImpl(UserRepository userRepository, OrderItemsRespository orderItemsRespository) {
        this.userRepository = userRepository;
        this.orderItemsRespository = orderItemsRespository;
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
        if (orderItemsRespository.findById(id).isPresent()) {
            OrderItems orderItems = orderItemsRespository.findById(id).get();
            return orderItems.toString();
        }
        return "There is no order with such id in database";
    }

}
