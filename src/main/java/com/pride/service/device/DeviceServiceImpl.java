package com.pride.service.device;

import com.pride.domain.Device;
import com.pride.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> queryAllDevice() {
        List<Device> devices = deviceMapper.queryAllDevice();
        return devices;
    }
}
