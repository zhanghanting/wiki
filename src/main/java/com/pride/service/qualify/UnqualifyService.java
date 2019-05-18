package com.pride.service.qualify;

import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.UnqualifyApplyVO;
import com.pride.mapper.UnqualifyApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UnqualifyService
{
    List<UnqualifyApplyVO> queryUnqualifyApplyVOList();
}
