package com.pride.service.device;

import com.pride.domain.Device;
import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;
import com.pride.domain.vo.DeviceVO;
import com.pride.mapper.DeviceMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface DeviceService {

    List<DeviceVO> queryAllDevice();

    TypeCode insertDevice(Device device);

    TypeCode deleteDeviceByIds(String[] ids);

    TypeCode updateDeviceById(Device device);

    MyPageHelper<DeviceVO> viewAllDevice(Integer page, Integer rows);
}
