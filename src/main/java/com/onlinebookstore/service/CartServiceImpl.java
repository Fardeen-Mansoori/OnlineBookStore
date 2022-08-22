package com.onlinebookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.CartRepository;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.exception.CartException;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	BookService bookService;

	@Autowired
	CartItemService cartItemService;


	@Override
	public List<Cart> getAllCart() throws CartException {
		return this.cartRepository.findAll();
	}

	@Override
	public Cart updateCart(Cart cart) throws CartException {
		// TODO Auto-generated method stub
		Double total = 0.0;

		List<CartItem> cartItemList = cartItemService.findByCart(cart);

		for (CartItem cartItem : cartItemList) {

			cartItemService.updateCartItem(cartItem);
			//System.out.println("////////////////"+cartItem.getSubtotal());
			total += (cartItem.getSubtotal());
			

		}

		cart.setCartTotal(total);

		cartRepository.save(cart);

		return cart;

	}

	@Override
	public void clearCart(Cart cart) throws CartException {
		// TODO Auto-generated method stub
		List<CartItem> cartItemList = cartItemService.findByCart(cart);

        for(CartItem cartItem : cartItemList) {
            cartItem.setCart(null);
            cartItemService.save(cartItem);

            cart.setCartTotal(0.0);

            cartRepository.save(cart);
        }
    }

	

}
