package com.pride.service.device;

import com.pride.domain.DeviceCheck;
import com.pride.domain.DeviceFault;
import com.pride.mapper.DeviceFaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;


    @Override
    public List<DeviceFault> queryAllDeviceFault() {
        List<DeviceFault> deviceFaults = deviceFaultMapper.queryAllDeviceFault();
        return deviceFaults;
    }

}
