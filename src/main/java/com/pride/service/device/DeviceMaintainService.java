package com.pride.service.device;

import com.pride.domain.DeviceMaintain;
import com.pride.domain.typecode.TypeCode;

import java.util.List;

public interface DeviceMaintainService {
    List<DeviceMaintain> queryAllDeviceMaintain();

    TypeCode insertDeviceMaintain(DeviceMaintain deviceMaintain);

    TypeCode deleteDeviceMaintainByIds(String[] ids);

    TypeCode updateDeviceMaintainById(DeviceMaintain deviceMaintain);
}
