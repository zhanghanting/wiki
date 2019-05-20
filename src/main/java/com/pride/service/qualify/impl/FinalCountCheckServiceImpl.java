package com.pride.service.qualify.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.FinalCountCheck;
import com.pride.domain.vo.FinalCountCheckVO;
import com.pride.mapper.FinalCountCheckMapper;
import com.pride.service.qualify.FinalCountCheckService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService
{
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Override
    public List<FinalCountCheckVO> queryFinalCountCheckVO()
    {
        List<FinalCountCheckVO> finalCountCheckVOS = finalCountCheckMapper.find();
        return finalCountCheckVOS;
    }

    @Override
    public MyPageHelper getList(int page,int rows)
    {
        PageHelper.startPage(page,rows);
        List<FinalCountCheckVO> finalCountCheckVOS = finalCountCheckMapper.find();
        PageInfo<FinalCountCheckVO> finalCountCheckVOPageInfo = new PageInfo<>(finalCountCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(finalCountCheckVOS );
        myPageHelper.setTotal(finalCountCheckVOPageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public FinalCountCheck get(String id)
    {
        return finalCountCheckMapper.selectByPrimaryKey(id);
    }

    @Override
    public JsonUtil insert(FinalCountCheck finalCountCheck)
    {
        int insert = finalCountCheckMapper.insert(finalCountCheck);
        if(insert > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"插入失败");
    }

    @Override
    public JsonUtil updateAll(FinalCountCheck finalCountCheck)
    {
        int update = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }

    @Override
    public JsonUtil deleteBatch(String[] ids)
    {
        int i = finalCountCheckMapper.deleteBatch(ids);
        if(i > 0)
        {
            return JsonUtil.ok();
        }
        else
            return JsonUtil.build(101,"删除失败");
    }

    @Override
    public MyPageHelper searchFCountCheckByFCountCheckId(int page,int rows,String searchValue)
    {
        PageHelper.startPage(page,rows);
        List<FinalCountCheckVO> finalCountCheckVOS = finalCountCheckMapper.searchFCountCheckByFCountCheckId(searchValue);
        PageInfo<FinalCountCheckVO> finalCountCheckVOPageInfo = new PageInfo<>(finalCountCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(finalCountCheckVOS);
        myPageHelper.setTotal(finalCountCheckVOPageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public MyPageHelper searchFCountCheckByOrderId(int page,int rows,String searchValue)
    {
        PageHelper.startPage(page,rows);
        List<FinalCountCheckVO> finalCountCheckVOS = finalCountCheckMapper.searchFCountCheckByOrderId(searchValue);
        PageInfo<FinalCountCheckVO> finalCountCheckVOPageInfo = new PageInfo<>(finalCountCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(finalCountCheckVOS);
        myPageHelper.setTotal(finalCountCheckVOPageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public JsonUtil updateNote(FinalCountCheck finalCountCheck)
    {
        int update = finalCountCheckMapper.updateNote(finalCountCheck);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }
}
