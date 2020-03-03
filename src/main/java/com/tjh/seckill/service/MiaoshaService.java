package com.tjh.seckill.service;

import com.tjh.seckill.domain.MiaoshaUser;
import com.tjh.seckill.domain.OrderInfo;
import com.tjh.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional(rollbackFor = Exception.class)
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        //减库存 下订单 写入秒杀订单
        System.out.println("in:" + user.getId());
        goodsService.reduceStock(goods);
        System.out.println(user.getId());
        //order_info maiosha_order
        return orderService.createOrder(user, goods);
    }

}
