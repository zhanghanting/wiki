package com.pride.mapper;

import com.pride.domain.UnqualifyApply;
import com.pride.domain.UnqualifyApplyExample;
import java.util.List;

import com.pride.domain.vo.UnqualifyApplyVO;
import org.apache.ibatis.annotations.Param;

public interface UnqualifyApplyMapper {
    long countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);
    //获取所有的不合格品管理信息
    List<UnqualifyApplyVO> find();
    //批量删除
    int deleteBatch(String[] ids);
    //根据id模糊查询
    List<UnqualifyApplyVO> searchUnqualifyByUnqualifyId(String id);
    //根据productName模糊查询
    List<UnqualifyApplyVO> searchUnqualifyByProductName(String ProductName);
}