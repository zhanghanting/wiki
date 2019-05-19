package com.pride.service.technology;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.TechnologyRequirement;
import com.pride.domain.vo.TechnologyRequirementVO;
import com.pride.mapper.TechnologyRequirementMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 10:54
 */

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService{


    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public MyPageHelper getList(int page, int rows, TechnologyRequirement technologyRequirement) {
        //分页处理
        PageHelper.startPage(page,rows);
        List<TechnologyRequirementVO> requirementVOList= technologyRequirementMapper.find(technologyRequirement);

        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(requirementVOList);

        //取记录总条数
        PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>();
        result.setTotal(pageInfo.getTotal());

        return result;
    }
}
