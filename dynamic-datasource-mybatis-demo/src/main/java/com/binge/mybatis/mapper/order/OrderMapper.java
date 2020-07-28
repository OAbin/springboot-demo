package com.binge.mybatis.mapper.order;

import com.binge.mybatis.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    /**
     * 根据id查询order对象
     * @param id
     * @return
     */
    Order orderById(@Param("id") Integer id);


    /**
     * 保存order
     * @param order
     */
    void save(Order order);
}
