package com.pride.service.qualify;

import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.UnqualifyApplyVO;
import com.pride.mapper.UnqualifyApplyMapper;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UnqualifyService
{
    List<UnqualifyApplyVO> queryUnqualifyApplyVOList();
    JsonUtil insert(UnqualifyApply unqualifyApply);
    UnqualifyApply get(String id);
    JsonUtil updateAll(UnqualifyApply unqualifyApply);
    JsonUtil deleteBatch(String[] ids);
    MyPageHelper searchUnqualifyByUnqualifyId(int page,int rows,String id);
    MyPageHelper serarchUnqualifyByProductName(int page,int rows,String ProductName);
}

