package com.pride.controller.work;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.pride.domain.Work;
import com.pride.domain.typecode.TypeCode;
import com.pride.domain.work.WorkPageType;
import com.pride.service.wrok.WorkService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/erp/work/")
public class WorkController {

    @Autowired
    WorkService workService;

    // 返回Word主页面
    @RequestMapping("find")
    public String find(){
        return "work_list";
    }
    // 返回分页的WorkPageType的List
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<WorkPageType> list(Integer page, Integer rows){
        return workService.viewPageWorks(page,rows);
    }
    //返回所有的Task
    @ResponseBody
    @RequestMapping("get_data")
    public List<Work> getData(){
        return workService.viewAllWorks();
    }


    // 返回空的json
    @ResponseBody
    @RequestMapping("edit_judge")
    public String editJudge(){
        return null;
    }
    // 跳转到word的修改页面
    // json
    @RequestMapping("edit")
    public String edit(){
        return "work_edit";
    }
    // 通过id修改product
    @ResponseBody
    @RequestMapping("update_all")
    public TypeCode updateAll(Work work){
        return workService.updateByModel(work);
    }



    // 删除请求
    @ResponseBody
    @RequestMapping("delete_judge")
    public String deleteJudge(){
        return null;
    }
    // 通过id的Sring数组删除work
    @ResponseBody
    @RequestMapping("delete_batch")
    public TypeCode deleteBatch(String[] ids){
        return workService.deleteWorksByIds(ids);
    }






    // 返回空的json字符串
    @ResponseBody
    @RequestMapping("add_judge")
    public String addJudge(){
        return null;
    }
    // 返回product的添加页面
    @RequestMapping("add")
    public String add(){
        return "work_add";
    }
    // 通过id新增一个product实例
    @ResponseBody
    @RequestMapping("insert")
    public TypeCode insert(Work work){
        return workService.insertWord(work);
    }
}
