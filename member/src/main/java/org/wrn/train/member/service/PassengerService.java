package org.wrn.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.wrn.train.common.util.SnowUtil;
import org.wrn.train.member.domain.Passenger;
import org.wrn.train.member.mapper.PassengerMapper;
import org.wrn.train.member.req.PassengerSaveReq;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-15 17:00
 **/
@Service
public class PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq passengerSaveReq) {
        DateTime time = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(passengerSaveReq, Passenger.class);
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(time);
        passenger.setUpdateTime(time);
        passengerMapper.insert(passenger);
    }
}
