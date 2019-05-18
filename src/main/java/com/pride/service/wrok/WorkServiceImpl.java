package com.pride.service.wrok;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.WorkExample;
import com.pride.domain.work.WorkPageType;
import com.pride.mapper.WorkMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    WorkMapper workMapper;

    @ResponseBody
    @Override
    public MyPageHelper<WorkPageType> viewPageWorks(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<WorkPageType> workPageTypes = workMapper.viewAllWorks();
        PageInfo<WorkPageType> pageInfo = new PageInfo<>(workPageTypes);
        MyPageHelper<WorkPageType> pageHelper = new MyPageHelper<>();
        pageHelper.setTotal(pageInfo.getTotal());
        pageHelper.setRows(workPageTypes);
        return pageHelper;
    }
}
