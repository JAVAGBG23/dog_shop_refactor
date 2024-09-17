package com.dog.shop.services;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
   /* @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;


    public Order createOrder(OrderDTO orderDTO) {

        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));


        List<Product> products = new ArrayList<>();
        for (String productId : orderDTO.getProductIds()) {
            products.add(productRepository.findById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid product id")));
        }

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setProducts(products);
        newOrder.setOrderedDate(orderDTO.getOrderedDate());

        return orderRepository.save(newOrder);
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    public List<OrderResponse> getUserOrders(String userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }



    private OrderResponse convertToDTO(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setUserId(order.getUser().getId());

        orderResponse.setOrderedProductIds(order.getProducts().stream().map(Product::getId).collect(Collectors.toList()));
        orderResponse.setOrderedDate(order.getOrderedDate());

        return orderResponse;
    }*/
}