package com.pride.service.device;

import com.pride.domain.DeviceCheck;
import com.pride.mapper.DeviceCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public List<DeviceCheck> queryAllDeviceCheck() {
        List<DeviceCheck> deviceChecks = deviceCheckMapper.queryAllDeviceCheck();

        return deviceChecks;
    }
}
