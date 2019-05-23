package com.pride.service.qualify.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.ProcessCountCheck;
import com.pride.domain.vo.ProcessCountCheckVO;
import com.pride.mapper.ProcessCountCheckMapper;
import com.pride.service.qualify.ProcessCountCheckService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService
{
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Override
    public List<ProcessCountCheckVO> queryProcessCountCheckVO()
    {
        List<ProcessCountCheckVO> processCountCheckVOS = processCountCheckMapper.find();
        return processCountCheckVOS;
    }

    @Override
    public MyPageHelper getList(int page,int rows)
    {
        PageHelper.startPage(page,rows);
        List<ProcessCountCheckVO> ProcessCountCheckVOS = processCountCheckMapper.find();
        PageInfo<ProcessCountCheckVO> processCountCheckVOPageInfo = new PageInfo<>(ProcessCountCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(ProcessCountCheckVOS);
        myPageHelper.setTotal(processCountCheckVOPageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public ProcessCountCheck get(String id)
    {
        return processCountCheckMapper.selectByPrimaryKey(id);
    }

    @Override
    public JsonUtil insert(ProcessCountCheck processCountCheck)
    {
        int insert = processCountCheckMapper.insert(processCountCheck);
        if(insert > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"插入失败");
    }

    @Override
    public JsonUtil updateAll(ProcessCountCheck processCountCheck)
    {
        int update = processCountCheckMapper.updateByPrimaryKey(processCountCheck);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }

    @Override
    public JsonUtil deleteBatch(String[] ids)
    {
        int i = processCountCheckMapper.deleteBatch(ids);
        if(i > 0)
        {
            return JsonUtil.ok();
        }
        else
            return JsonUtil.build(101,"删除失败");
    }

    @Override
    public MyPageHelper searchpCountCheckBypCountCheckId(int page,int rows,String searchValue)
    {
        PageHelper.startPage(page,rows);
        List<ProcessCountCheckVO> processCountCheckVOS = processCountCheckMapper.searchpCountCheckBypCountCheckId(searchValue);
        PageInfo<ProcessCountCheckVO> processCountCheckVOPageInfo = new PageInfo<>(processCountCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(processCountCheckVOS);
        myPageHelper.setTotal(processCountCheckVOPageInfo .getTotal());
        return myPageHelper;
    }

    @Override
    public JsonUtil updateNote(ProcessCountCheck processCountCheck)
    {
        int update = processCountCheckMapper.updateNote(processCountCheck);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }
}
