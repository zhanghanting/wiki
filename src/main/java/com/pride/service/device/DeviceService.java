package com.pride.service.device;

import com.pride.domain.Device;
import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface DeviceService {

    List<Device> queryAllDevice();

}
