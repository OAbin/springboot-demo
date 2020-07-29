package com.binge.jpa.dao.order;


import com.binge.jpa.model.Order;
import org.springframework.data.repository.Repository;


public interface OrderRepository extends Repository<Order, Integer> {

    /**
     * 保存order
     * @param order
     */
    void save(Order order);

    /**
     * 根据id查询order
     * @param id
     * @return
     */
    Order findById(Integer id);
}
