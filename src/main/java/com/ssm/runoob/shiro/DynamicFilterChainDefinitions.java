package com.ssm.runoob.shiro;

import com.ssm.runoob.service.RoleService;
import com.ssm.runoob.util.ShiroUtils;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Phil on 2016/3/2.
 */
public class DynamicFilterChainDefinitions implements FactoryBean<Ini.Section> {

    @Autowired
    private RoleService roleService;//模拟配置文件
    private String filterChainDefinitions;


    @Override
    public Ini.Section getObject() throws Exception {
        Ini ini = new Ini();
        //加载默认的url
        ini.load(filterChainDefinitions);
        Map<String, String> defaultFilterChainDefinitionMap = ShiroUtils.getDefaultFilterChainDefinitionMap();
//
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
//
        Map<String, String> filterChainDefinitions = roleService.getFilterChainDefinitions();

        section.putAll(defaultFilterChainDefinitionMap);
        section.putAll(filterChainDefinitions);
        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    /**
     * Sets filter chain definitions.
     *
     * @param filterChainDefinitions the filter chain definitions
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }
}
