package com.pride.mapper;

import com.pride.domain.Device;
import com.pride.domain.DeviceExample;
import com.pride.domain.vo.DeviceVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<DeviceVO> queryAllDevice();
}