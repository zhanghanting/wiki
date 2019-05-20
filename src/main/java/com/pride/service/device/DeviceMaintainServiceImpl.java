package com.pride.service.device;

import com.pride.domain.DeviceMaintain;
import com.pride.mapper.DeviceMaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public List<DeviceMaintain> queryAllDeviceMaintain() {
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.queryAllDeviceMaintain();
        return deviceMaintainList;
    }
}
