package com.onlinebookstore.service;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.BookToCartItemRepository;
import com.onlinebookstore.dao.CartItemRepository;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.BookToCartItem;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.CartException;
/************************************************************************************
 *          @author          Fardeen Mansoori
 *          Description      It is a service class that provides the services for get Cart Details and 
 *                           operations on Carts item.       
 *         Version             1.0
 *         Created Date     20-AUG-2022
 ************************************************************************************/


@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private BookToCartItemRepository bookToCartItemRepository;
	
	/************************************************************************************
	 * Method: - Get all Carts items 
	 * @Description: - Get all carts items  from the Book Store Application. 
	 * @returns List<Cart> - List of all carts items if exists otherwise throws Cart
	 *          Exception
	 * @throws CartException - if the cart item  is null.
	 ************************************************************************************/
	
	@Override
	public List<CartItem> findByCart(Cart cart) {
		// TODO Auto-generated method stub
		return this.cartItemRepository.findByCart(cart);
	}
	/************************************************************************************
	 * Method: - Update Cart 
	 * @Description: - Update Cart item in the Book Store Application.
	 * @object cartItem - cart item details
	 * @return cartItem - updated entity i.e. cartItem if cartItems exists otherwise throws CartException
	 * @throws CartException - It is raised due to Cart details are invalid, or Cart
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItem.setSubtotal(cartItem.getBook().getBookPrice() * cartItem.getQty());
		this.cartItemRepository.save(cartItem);

		return cartItem;
	}
	/************************************************************************************
	 * Method: - addBookToCartItem
	 * @Description: - Add a particular book to cartItem
	 * @object Book - Book details
	 * @object User - User details
	 * @parameter  qty - Quantity of Book to add in cartItem
	 * @return cartItem - updated entity i.e. cartItem if cartItems exists otherwise throws CartException
	 * @throws CartException - It is raised due to Cart details are invalid, or Cart
	 *                       id is not present.
	 ************************************************************************************/
	
	@Override
	public CartItem addBookToCartItem(Book book, User user, int qty)  {
		// TODO Auto-generated method stub
		List<CartItem> cartItemList = findByCart(user.getCart());

		for (CartItem cartItem : cartItemList) {
			if (book.getBookId() == cartItem.getBook().getBookId()) {
				cartItem.setQty(cartItem.getQty() + qty);
				cartItem.setSubtotal(book.getBookPrice() * cartItem.getQty());
				cartItemRepository.save(cartItem);
				
				return cartItem;
			}
		}

		CartItem cartItem = new CartItem();
		cartItem.setCart(user.getCart());
		cartItem.setBook(book);

		cartItem.setQty(qty);
		cartItem.setSubtotal(book.getBookPrice() * cartItem.getQty());
		cartItem = cartItemRepository.save(cartItem);

		BookToCartItem bookToCartItem = new BookToCartItem();
		bookToCartItem.setBook(book);
		bookToCartItem.setCartItem(cartItem);
		bookToCartItemRepository.save(bookToCartItem);
		
		return cartItem;
	}
 
	@Override
	public CartItem findById(Integer id) {
		// TODO Auto-generated method stub
		return cartItemRepository.findById(id).get();
	}

	@Override
	@Transactional
	
	/************************************************************************************
	 * Method: - Remove  CartItem
	 * @Description: - Remove cartItem  present in cart.
	 * @object cartItem - cartItem details
	 * @throws CartException -It is raised due to Cart details are invalid, or Cart
	 *                       id is not present.
	 ************************************************************************************/
	public void removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		bookToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);

	}

	@Override
	public CartItem save(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartItemRepository.save(cartItem);
	}
		

}
