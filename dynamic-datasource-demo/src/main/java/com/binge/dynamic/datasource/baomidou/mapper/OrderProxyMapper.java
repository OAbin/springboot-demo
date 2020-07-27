package com.binge.dynamic.datasource.baomidou.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.binge.dynamic.datasource.baomidou.constants.DataSourceConstants;
import com.binge.dynamic.datasource.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * baomidou读写分离测试
 */
@Repository
public interface OrderProxyMapper {

    @DS(DataSourceConstants.DATASOURCE_ORDER_SLAVE)
    Order orderById(@Param("id") Integer id);

    @DS(DataSourceConstants.DATASOURCE_ORDER_MASTER)
    int save(Order order);
}
