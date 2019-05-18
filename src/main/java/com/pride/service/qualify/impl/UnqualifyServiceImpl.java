package com.pride.service.qualify.impl;

import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.UnqualifyApplyVO;
import com.pride.mapper.UnqualifyApplyMapper;
import com.pride.service.qualify.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UnqualifyServiceImpl implements UnqualifyService
{
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;
    @Override
    public List<UnqualifyApplyVO> queryUnqualifyApplyVOList()
    {
        List<UnqualifyApplyVO> unqualifyApplyVOList = unqualifyApplyMapper.find();
        return unqualifyApplyVOList;
    }
}
