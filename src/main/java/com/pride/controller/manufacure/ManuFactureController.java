package com.pride.controller.manufacure;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Manufacture;
import com.pride.domain.manufacture.ManufacturePageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.service.manufacture.ManuFactureService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/erp/manufacture/")
public class ManuFactureController {

    @Autowired
    ManuFactureService manuFactureService;

    // 跳转到主页面manufacture主页面
    @RequestMapping("find")
    public String find(){
        return "manufacture_list";
    }
    // 返回分页的ManufacturePageType的List
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<ManufacturePageType> list(Integer page,Integer rows){
        return manuFactureService.viewPageManufacturePageType(page,rows);
    }
    // 通过manufactureSn模糊查询
    @ResponseBody
    @RequestMapping("search_manufacture_by_manufactureSn")
    public MyPageHelper<ManufacturePageType> searchManufactureByManufactureId(String searchValue,Integer page,Integer rows){
        return manuFactureService.searchManufactureByManufactureId(searchValue,page,rows);
    }
    // 通过OrderId模糊查询
    @ResponseBody
    @RequestMapping("search_manufacture_by_manufactureOrderId")
    public MyPageHelper<ManufacturePageType> searchManufactureByManufactureOrderId(String searchValue,Integer page,Integer rows){
        return manuFactureService.searchManufactureByManufactureOrderId(searchValue,page,rows);
    }
    // 通过ManufactureTechnologyName模糊查询
    @ResponseBody
    @RequestMapping("search_manufacture_by_manufactureTechnologyName")
    public MyPageHelper<ManufacturePageType> searchManufactureByManufactureTechnologyName(String searchValue,Integer page,Integer rows){
        return manuFactureService.searchManufactureByManufactureTechnologyName(searchValue,page,rows);
    }
    //返回所有的Custom
    @ResponseBody
    @RequestMapping("get_data")
    public List<Manufacture> getData(){
        return manuFactureService.viewAllManufactures();
    }


    // 返回空的json
    @ResponseBody
    @RequestMapping("edit_judge")
    public String editJudge(){
        return null;
    }
    // 跳转到manufacture的修改页面
    @RequestMapping("edit")
    public String edit(){
        return "manufacture_edit";
    }
    // 通过id修改manufacture
    @ResponseBody
    @RequestMapping("update_all")
    public TypeCode updateAll(Manufacture Manufacture){
        return manuFactureService.updateByModel(Manufacture);
    }



    // 删除请求
    @ResponseBody
    @RequestMapping("delete_judge")
    public String deleteJudge(){
        return null;
    }
    // 通过id的Sring数组删除manufacture
    @ResponseBody
    @RequestMapping("delete_batch")
    public TypeCode deleteBatch(String[] ids){
        return manuFactureService.deleteManufacturesByIds(ids);
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
    public TypeCode insert(Manufacture manufacture){
        return manuFactureService.insertManufacture(manufacture);
    }
}
