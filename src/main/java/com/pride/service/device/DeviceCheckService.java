package com.pride.service.device;

import com.pride.domain.DeviceCheck;
import com.pride.domain.typecode.TypeCode;

import java.util.List;

public interface DeviceCheckService {
    List<DeviceCheck> queryAllDeviceCheck();

    TypeCode insertDeviceCheck(DeviceCheck deviceCheck);

    TypeCode deleteDeviceCheckByIds(String[] ids);

    TypeCode updateDeviceCheckById(DeviceCheck deviceCheck);
}
