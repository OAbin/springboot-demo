package com.binge.baomidou.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.binge.baomidou.constants.BaomidouConstants;
import com.binge.baomidou.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DS(BaomidouConstants.DATASOURCE_ORDER)
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
