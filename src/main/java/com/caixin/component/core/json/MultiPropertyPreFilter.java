package com.caixin.component.core.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 多对象属性过滤器
 *
 * @author zhuzhongji
 * create on 20190326
 */
public class MultiPropertyPreFilter implements PropertyPreFilter {

    private Map<Class<?>, String[]> includes = new HashMap<>();
    private Map<Class<?>, String[]> excludes = new HashMap<>();

    static {
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
    }

    public MultiPropertyPreFilter() {}

    public MultiPropertyPreFilter(Map<Class<?>, String[]> includes) {
        super();
        this.includes = includes;
    }

    public static MultiPropertyPreFilter createFilterWithExclude(Class<?> clazz, String... excludeFields) {
        MultiPropertyPreFilter filter = new MultiPropertyPreFilter();
        Map<Class<?>, String[]> classMap = new HashMap<>();
        classMap.put(clazz, excludeFields);
        filter.setExcludes(classMap);
        return filter;
    }

    public static MultiPropertyPreFilter createFilterWithInclude(Class<?> clazz, String... includeFields) {
        MultiPropertyPreFilter filter = new MultiPropertyPreFilter();
        Map<Class<?>, String[]> classMap = new HashMap<>();
        classMap.put(clazz, includeFields);
        filter.setIncludes(classMap);
        return filter;
    }

    public MultiPropertyPreFilter addInclude(Class<?> clazz, String... includeFields) {
        this.includes.put(clazz, includeFields);
        return this;
    }

    public MultiPropertyPreFilter addExclude(Class<?> clazz, String... excludeFields) {
        this.excludes.put(clazz, excludeFields);
        return this;
    }

    @Override
    public boolean apply(JSONSerializer serializer, Object source, String name) {

        //对象为空。直接放行
        if (source == null) {
            return true;
        }

        // 获取当前需要序列化的对象的类对象
        Class<?> clazz = source.getClass();

        // 无需序列的对象、寻找需要过滤的对象，可以提高查找层级
        // 找到不需要的序列化的类型
        for (Map.Entry<Class<?>, String[]> item : this.excludes.entrySet()) {
            // isAssignableFrom()，用来判断类型间是否有继承关系
            if (item.getKey().isAssignableFrom(clazz)) {
                // 该类型下 此 name 值无需序列化
                if (isHave(item.getValue(), name)) {
                    return false;
                }
            }
        }

        // 需要序列的对象集合为空 表示 全部需要序列化
        if (this.includes.isEmpty()) {
            return true;
        }

        // if 未设置对象的过滤, 则默认全部序列化
        if (!this.includes.containsKey(clazz)) {
            return true;
        }

        // 需要序列的对象
        // 找到不需要的序列化的类型
        for (Map.Entry<Class<?>, String[]> item : this.includes.entrySet()) {
            // isAssignableFrom()，用来判断类型间是否有继承关系
            if (item.getKey().isAssignableFrom(clazz)) {
                // 该类型下 此 name 值无需序列化
                if (isHave(item.getValue(), name)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
     */
    private static boolean isHave(String[] strs, String s) {
        for (String s1 : strs) {
            // 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
            if (s1.equals(s)) {
                // 查找到了就返回真，不在继续查询
                return true;
            }
        }
        // 没找到返回false
        return false;
    }

    public Map<Class<?>, String[]> getIncludes() {
        return includes;
    }

    public void setIncludes(Map<Class<?>, String[]> includes) {
        this.includes = includes;
    }

    public Map<Class<?>, String[]> getExcludes() {
        return excludes;
    }

    public void setExcludes(Map<Class<?>, String[]> excludes) {
        this.excludes = excludes;
    }

}