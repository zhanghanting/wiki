package com.pride.controller.material;



import com.pride.domain.Material;
import com.pride.domain.material.MaterialConsume;
import com.pride.domain.material.MaterialReceive;
import com.pride.service.material.MaterialConsumeService;
import com.pride.service.material.MaterialReceiveService;
import com.pride.service.material.MaterialService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@RequestMapping("/erp")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @Autowired
    MaterialReceiveService materialReceiveService;

    @Autowired
    MaterialConsumeService materialConsumeService;


    //转到物料清单信息表并显示
    @RequestMapping("/material/find")
    public String showMaterialHome(){
        return "material_list";
    }
    @RequestMapping("/material/list")
    @ResponseBody
    public MyPageHelper<Material> query(Integer page, Integer rows){
        MyPageHelper myPageHelper = materialService.queryMaterialList(page, rows);
        return myPageHelper;
    }
    //插入物料信息管理
    @RequestMapping("/material/add_judge")
    @ResponseBody
    public String insetMaterialForm() {
        return "null";
    }
    @RequestMapping("/material/add")
    public String insertMaterialList(){
        return "material_add";
    }
    //新增物料数据
    @RequestMapping(value="/material/insert", method= RequestMethod.POST)
    @ResponseBody
    private JsonUtil insertMaterial(Material material, BindingResult bindingResult) throws Exception {
        JsonUtil jsonUtil = materialService.insertMaterial(material, bindingResult);
        return jsonUtil;
    }
    //编辑物料信息管理
    @RequestMapping("/material/edit_judge")
    @ResponseBody
    public String editMaterialForm() {
        return "null";
    }
    @RequestMapping("/material/edit")
    public String editMaterialFormList() {
        return "material_edit";
    }
    //编辑物料数据
    @RequestMapping(value="/material/update_all", method= RequestMethod.POST)
    @ResponseBody
    private JsonUtil editMaterial(Material material, BindingResult bindingResult) throws Exception {
        JsonUtil jsonUtil = materialService.editMaterial(material, bindingResult);
        return jsonUtil;
    }
    //删除物料数据
    @RequestMapping("material/delete_judge")
    @ResponseBody
    public String showDeletePage(){
        return "null";
    }
    @RequestMapping("material/delete_batch")
    @ResponseBody
    public String deleteMaterialList(String[] ids) {
        materialService.deleteBatch(ids);
        return "删除成功";
    }
    //转到物料收入信息表并显示
    @RequestMapping("/materialReceive/find")
    public String materialReceive(){
        return "materialReceive_list";
    }
    @RequestMapping("/materialReceive/list")
    @ResponseBody
    public MyPageHelper<MaterialReceive> queryMaterialReceiveList(Integer page, Integer rows){
        MyPageHelper myPageHelper = materialReceiveService.queryMaterialReceiveList(page, rows);
        return myPageHelper;
    }
    //插入物料收入信息管理
    @RequestMapping("/materialReceive/add_judge")
    @ResponseBody
    public String insetMaterialReceiveForm() {
        return "null";
    }
    @RequestMapping("/materialReceive/add")
    public String insertMaterialReceiveList(){
        return "materialReceive_add";
    }
    //新增物料收入数据
    @RequestMapping(value="/materialReceive/insert", method= RequestMethod.POST)
    @ResponseBody
    private JsonUtil insertMaterialReceive(MaterialReceive materialReceive, BindingResult bindingResult) throws Exception {
        JsonUtil jsonUtil = materialReceiveService.insertMaterialReceive(materialReceive, bindingResult);
        return jsonUtil;
    }
    //编辑物料收入信息管理
    @RequestMapping("/materialReceive/edit_judge")
    @ResponseBody
    public String editMaterialReceiveForm() {
        return "null";
    }
    @RequestMapping("/materialReceive/edit")
    public String editMaterialReceiveFormList() {
        return "materialReceive_edit";
    }
    //编辑物料收入数据
    @RequestMapping(value="/materialReceive/update_all", method= RequestMethod.POST)
    @ResponseBody
    private JsonUtil editMaterialReceive(MaterialReceive materialReceive, BindingResult bindingResult) throws Exception {
        JsonUtil jsonUtil = materialReceiveService.editMaterialReceive(materialReceive, bindingResult);
        return jsonUtil;
    }
    //删除物料收入数据
    @RequestMapping("materialReceive/delete_judge")
    @ResponseBody
    public String showDeleteReceivePage(){
        return "null";
    }
    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public String deleteMaterialReceiveList(String[] ids) {
        materialReceiveService.deleteBatch(ids);
        return "删除成功";
    }

    //打开物料消耗信息表
    @RequestMapping("/materialConsume/find")
    public String materialConsume(){
        return "materialConsume_list";
    }
    @RequestMapping("/materialConsume/list")
    @ResponseBody
    public MyPageHelper<MaterialConsume> queryMaterialConsume(Integer page, Integer rows){
        MyPageHelper myPageHelper = materialConsumeService.queryMaterialConsumeList(page, rows);
        return myPageHelper;
    }
    //插入物料信息管理
    @RequestMapping("/materialConsume/add_judge")
    @ResponseBody
    public String insetMaterialConsumeForm() {
        return "null";
    }
    @RequestMapping("/materialConsume/add")
    public String insertMaterialConsumeList(){
        return "materialConsume_add";
    }
    //新增物料数据
    @RequestMapping(value="/materialConsume/insert", method= RequestMethod.POST)
    @ResponseBody
    private JsonUtil insertMaterialConsume(MaterialConsume materialConsume, BindingResult bindingResult) throws Exception {
        JsonUtil jsonUtil = materialConsumeService.insertMaterialConsume(materialConsume, bindingResult);
        return jsonUtil;
    }
    //编辑物料信息管理
    @RequestMapping("/materialConsume/edit_judge")
    @ResponseBody
    public String editMaterialConsumeForm() {
        return "null";
    }
    @RequestMapping("/materialConsume/edit")
    public String editMaterialConsumeFormList() {
        return "materialConsume_edit";
    }
    //编辑物料数据
    @RequestMapping(value="/materialConsume/update_all", method= RequestMethod.POST)
    @ResponseBody
    private JsonUtil editMaterialConsume(MaterialConsume materialConsume, BindingResult bindingResult) throws Exception {
        JsonUtil jsonUtil = materialConsumeService.editMaterialConsume(materialConsume, bindingResult);
        return jsonUtil;
    }
    //删除物料数据
    @RequestMapping("materialConsume/delete_judge")
    @ResponseBody
    public String showDeleteConsumePage(){
        return "null";
    }
    @RequestMapping("materialConsume/delete_batch")
    @ResponseBody
    public String deleteMaterialConsumeList(String[] ids) {
        materialConsumeService.deleteBatch(ids);
        return "删除成功";
    }
    /*//转到设备管理中心
    @RequestMapping("/deviceList/get_data")
    public String forward_deviceList(){
        return "materialConsume_list";
    }*/
}
