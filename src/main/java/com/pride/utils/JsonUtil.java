package com.pride.utils;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/18 11:36
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * 自定义响应结构
 */
public class JsonUtil {
    //自定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    public JsonUtil() {
    }

    public JsonUtil(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonUtil(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public static JsonUtil build(Integer status, String msg, Object data){
        return new JsonUtil(status,msg,data);
    }

    public static JsonUtil build(Integer status, String msg){
        return new JsonUtil(status,msg,null);
    }

    public static JsonUtil ok(){
        return new JsonUtil(null);
    }

    public static JsonUtil ok(Object data){
        return new JsonUtil(data);
    }


    //get()、set()方法
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    /**
     * 将json结果集转化为pojo对象
     * @param jsonData json数据
     * @param clazz 结果中的object类型
     * @return
     */
    public static JsonUtil formatToPojo(String jsonData,Class<?> clazz){
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, JsonUtil.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     *  没有object对象的转化
     * @param json json数据
     * @return
     */
    public static JsonUtil format(String json) {
        try {
            return MAPPER.readValue(json, JsonUtil.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将json结果集转化为集合
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static JsonUtil formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
