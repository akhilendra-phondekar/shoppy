package com.gen.ai.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gen.ai.dto.CartDto;
import com.gen.ai.dto.CartItemDto;
import com.gen.ai.dto.ProductDto;
import com.gen.ai.entity.Cart;
import com.gen.ai.entity.CartItem;
import com.gen.ai.entity.Order;
import com.gen.ai.entity.OrderItem;
import com.gen.ai.exception.EmptyCartException;
import com.gen.ai.repository.CartItemRepository;
import com.gen.ai.repository.CartRepository;
import com.gen.ai.service.CartService;
import com.gen.ai.service.OrderService;
import com.gen.ai.service.ProductService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrderService orderService;

    @Override
    public void addToCart(Long userId, CartItemDto cartItemDto) {
        // Retrieve user's cart or create a new one
        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart(userId);
                    return cartRepository.save(newCart);
                });

        // Retrieve product information
        ProductDto productDto = productService.getProductById(cartItemDto.getProductId());

        // Check if the product is available in sufficient quantity
        if (productDto.getStockQuantity() >= cartItemDto.getQuantity()) {
            // Decrease product stock quantity
            productService.decreaseStockQuantity(cartItemDto.getProductId(), cartItemDto.getQuantity());

            // Add item to the cart
            CartItem cartItem = new CartItem(cart.getId(), cartItemDto.getProductId(), cartItemDto.getQuantity());
            cartItemRepository.save(cartItem);
        } else {
            // Handle insufficient stock quantity (throw exception, return an error response, etc.)
        }
    }

    @Override
    public void checkout(Long userId) {
        // Implement checkout logic, e.g., creating an order, clearing the cart, etc.
        // You may involve the OrderService or create a new method in this service for checkout
    	// Retrieve the cart for the user
        Cart cart = cartRepository.findByUserId(userId).orElseGet(null);

        if (cart == null ) {
            throw new EmptyCartException("Cannot checkout. Cart is empty.");
        }
        
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
        if(CollectionUtils.isEmpty(cartItems))
        {
        	throw new EmptyCartException("Cannot checkout. Cart is empty.");
        }

        // Create an order
        createOrder(cart,cartItems);

        // Clear the cart
        clearCart(cart);

        // You may perform additional logic here, such as processing payments, sending confirmation emails, etc.
    }
    
    private Order createOrder(Cart cart, List<CartItem> cartItems) {
        // Create an order using the cart information
        Order order = new Order();
        //order.setUser(cart.getUser());
        order.setUserId(cart.getUserId());
        List<OrderItem> orderItems = new ArrayList<>();
        
        BigDecimal totalAmount = cartItems.stream()
        						.map(ci->{
        							
        							ProductDto productById = productService.getProductById(ci.getCartId());
        							if(productById!=null) {
        								BigDecimal subtotal = BigDecimal.valueOf(productById.getPrice()).multiply(BigDecimal.valueOf(ci.getQuantity()));
										orderItems.add(new OrderItem(order, productById.getProductId(), 
        										ci.getQuantity(), subtotal));
										return subtotal;
        							}
        							return BigDecimal.ZERO;
        						}).reduce(BigDecimal.ZERO, BigDecimal::add);
        		
        		
        		
        order.setOrderItems(orderItems);

        order.setTotalAmount(totalAmount);
        // Set other order details as needed

        // Save the order
        orderService.saveOrder(order);

        return order;
    }

    private void clearCart(Cart cart) {
        // Clear the cart by removing all cart items
        cartItemRepository.deleteByCartId(cart.getId());
        cartRepository.save(cart);
    }

    // Additional methods as needed

    private CartItemDto convertToDto(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(cartItem.getProductId());
        cartItemDto.setQuantity(cartItem.getQuantity());
        return cartItemDto;
    }

	@Override
	public CartDto viewCart(Long userId) {
		Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user with ID: " + userId));

        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());

        List<CartItemDto> cartItemDtos = cartItems.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new CartDto(cart.getId(), cart.getUserId(), cartItemDtos);
	}
}
