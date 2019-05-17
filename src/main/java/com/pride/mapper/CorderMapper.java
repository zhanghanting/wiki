package com.pride.mapper;

import com.pride.domain.Corder;
import com.pride.domain.CorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CorderMapper {

    @Select("select * from c_order")
    List<Corder> selectAllCorder();
    long countByExample(CorderExample example);

    int deleteByExample(CorderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Corder record);

    int insertSelective(Corder record);

    List<Corder> selectByExample(CorderExample example);

    Corder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Corder record, @Param("example") CorderExample example);

    int updateByExample(@Param("record") Corder record, @Param("example") CorderExample example);

    int updateByPrimaryKeySelective(Corder record);

    int updateByPrimaryKey(Corder record);
}