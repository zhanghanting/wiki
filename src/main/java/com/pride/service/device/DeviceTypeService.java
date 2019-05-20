package com.pride.service.device;

import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;

import java.util.List;

public interface DeviceTypeService {
    List<DeviceType> queryAllDeviceType();

    TypeCode insertDeviceType(DeviceType deviceType);

    TypeCode deleteDeviceTypeByIds(String[] ids);
}
