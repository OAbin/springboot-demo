package com.binge.baomidou.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.binge.baomidou.constants.BaomidouConstants;
import com.binge.baomidou.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * baomidou读写分离测试
 */
@Repository
public interface OrderProxyMapper {

    /**
     * 从库通过默认的负载均衡--轮训来查询数据
     * @param id
     * @return
     */
    @DS(BaomidouConstants.DATASOURCE_ORDER_SLAVE)
    Order orderById(@Param("id") Integer id);

    /**
     * 主库写入数据
     * @param order
     * @return
     */
    @DS(BaomidouConstants.DATASOURCE_ORDER_MASTER)
    int save(Order order);
}
