package com.project.EcommerceWebsite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Entities.MyOrder;

@Repository
public interface MyOrderRepo extends JpaRepository<MyOrder, Long>  {

	public List<MyOrder> findByCustomer(Customer customer);

}
