package com.onlinebookstore.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.CartRepository;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.exception.CartException;

/************************************************************************************
 *          @author          Fardeen Mansoori
 *          Description      It is a service class that provides the services for get Cart Details and 
 *                           operations on Carts item.       
 *         Version             1.0
 *         Created Date     20-AUG-2022
 ************************************************************************************/

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	BookService bookService;

	@Autowired
	CartItemService cartItemService;
	
	/************************************************************************************
	 * Method: - Get all Carts 
	 * @Description: - Get all carts  from the Book Store Application. 
	 * @returns List<Cart> - List of all carts if exists otherwise throws Cart
	 *          Exception
	 * @throws CartException - if the cart  is null.
	 ************************************************************************************/


	@Override
	public List<Cart> getAllCart() throws CartException {
		return this.cartRepository.findAll();
	}
	/************************************************************************************
	 * Method: - Update Cart 
	 * @Description: - Update Cart  in the Book Store Application.
	 * @object cart - cart details
	 * @return cart - updated entity i.e. cart if Items exists otherwise throws User
	 *          Exception
	 * @throws CartException - It is raised due to Cart details are invalid, or Cart
	 *                       id is not present.
	 ************************************************************************************/

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
	/************************************************************************************
	 * Method: - Clear Cart 
	 * @Description: - Clear all cart  in the Book Store Application.
	 * @object cart - cart details
	 * @throws CartException -It is raised due to Cart details are invalid, or Cart
	 *                       id is not present.
	 ************************************************************************************/

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
