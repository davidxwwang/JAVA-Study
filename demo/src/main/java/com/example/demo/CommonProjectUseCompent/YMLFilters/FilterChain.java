package com.example.demo.CommonProjectUseCompent.YMLFilters;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterChain {

    private Integer currentExcuteFilterIndex = 0;

    private List<FilterInterFace> filters = new ArrayList<>();

    /**
     * 使用yml文件初始化一个FilterChain
     * @param path yml文件路径
     * @param section 加载yml文件的section
     * @return
     */
    public static FilterChain configWithYML(String path, String section) throws FilterChainException, IllegalAccessException, InstantiationException {

        FilterChain chain = new FilterChain();

        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
        yamlMapFactoryBean.setResources(new ClassPathResource(path));

        Map<String, Object> map = yamlMapFactoryBean.getObject();

        List<String> classNameList = (List<String>) map.get(section);

        chain.filters.clear();
        for (String className : classNameList){
            Class clazz = null;
            try{
                clazz = Class.forName(className);
            }catch (ClassNotFoundException ex){
                throw new FilterChainException();
            }

            FilterInterFace instance = (FilterInterFace) clazz.newInstance();
            if (instance instanceof FilterInterFace){
                chain.filters.add(instance);
            }else{
                throw new FilterChainException();
            }
        }

        return chain;
    }

    /**
     * 执行filter
     * @param context
     * @throws FilterChainException
     */
    public void execute(FilterChainContext context) throws FilterChainException{

        if (currentExcuteFilterIndex == (this.filters.size() - 1)){
            return;
        }

        FilterInterFace filterInterFace = filters.get(currentExcuteFilterIndex);
        filterInterFace.dofilter(context);

        currentExcuteFilterIndex++;
    }




}
