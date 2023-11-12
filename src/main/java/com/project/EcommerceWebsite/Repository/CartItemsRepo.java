package com.project.EcommerceWebsite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import com.project.EcommerceWebsite.Entities.CartItems;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Entities.Product;

import jakarta.transaction.Transactional;

@Repository
public interface CartItemsRepo extends JpaRepository<CartItems, Long> {

	public List<CartItems> findByCustomer(Customer customer);

	public CartItems findByCustomerAndProduct(Customer customer, Product product);

	@Modifying
	@Transactional
	@Query("UPDATE CartItems c SET c.quantity = ?1 WHERE c.customer.id = ?2 " + "AND c.product.id = ?3")
	public void updateQuantity(int quantity, long customerId, long productId);

	@Query("DELETE from CartItems c  where c.product.id = ?1 " + "AND c.customer.id = ?2")
	@Modifying
	@Transactional
	public void deleteCartProduct(long productId, long customerId);

	@Query("DELETE from CartItems c  where c.customer.id = ?1")
	@Modifying
	@Transactional
	public void deleteCartItemsByCustomer( long customerId);

}
