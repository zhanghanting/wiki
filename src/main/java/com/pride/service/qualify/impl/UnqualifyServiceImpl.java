package com.pride.service.qualify.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.UnqualifyApplyVO;
import com.pride.mapper.UnqualifyApplyMapper;
import com.pride.service.qualify.UnqualifyService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public JsonUtil insert(UnqualifyApply unqualifyApply)
    {
        int insert = unqualifyApplyMapper.insert(unqualifyApply);
        if(insert > 0)
        {
            //插入成功
            return JsonUtil.ok();
        }
        else
        {
            return JsonUtil.build(101,"新增不合格品信息失败");
        }
    }
    //返回对应id的不合格品信息
    @Override
    public UnqualifyApply get(String id)
    {
        return unqualifyApplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public JsonUtil updateAll(UnqualifyApply unqualifyApply)
    {
        int update = unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"修改当前不合格品信息失败");
    }
    //批量删除
    @Override
    public JsonUtil deleteBatch(String[] ids)
    {
        int i = unqualifyApplyMapper.deleteBatch(ids);
        if(i > 0)
        {
            return JsonUtil.ok();
        }
        else
            return null;
    }
    //根据不合格品id查询不合格品的申请信息
    @Override
    public MyPageHelper searchUnqualifyByUnqualifyId(int page,int rows,String id)
    {
        PageHelper.startPage(page,rows);
        List<UnqualifyApplyVO> unqualifyApplyVOList = unqualifyApplyMapper.searchUnqualifyByUnqualifyId(id);
        //将获取的信息封装为page
        PageInfo<UnqualifyApplyVO> unqualifyApplyVOPageInfo = new PageInfo<>(unqualifyApplyVOList);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(unqualifyApplyVOList);
        myPageHelper.setTotal(unqualifyApplyVOPageInfo.getTotal());
        return myPageHelper;
    }
    //根据不合格品的产品名称查询不合格品的申请信息
    @Override
    public MyPageHelper serarchUnqualifyByProductName(int page,int rows,String productName)
    {
        PageHelper.startPage(page,rows);
        List<UnqualifyApplyVO> unqualifyApplyVOList = unqualifyApplyMapper.searchUnqualifyByProductName(productName);
        PageInfo<UnqualifyApplyVO> unqualifyApplyVOPageInfo = new PageInfo<>(unqualifyApplyVOList);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(unqualifyApplyVOList);
        myPageHelper.setTotal(unqualifyApplyVOPageInfo.getTotal());
        return myPageHelper;
    }
}
