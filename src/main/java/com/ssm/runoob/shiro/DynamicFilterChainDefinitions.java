package com.ssm.runoob.shiro;

import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Phil on 2016/3/2.
 */
public class DynamicFilterChainDefinitions implements FactoryBean<Ini.Section> {
    //    @Autowired
//    private UserService resourceDao;//模拟配置文件
    private String filterChainDefinitions;//默认配置的
    /**
     * 默认premission字符串
     */
    public static final String PREMISSION_STRING = "perms[\"{0}\"]";

    @Override
    public Ini.Section getObject() throws Exception {
        //获取所有Resource
//        List<Resource> list = resourceDao.getAll();

        Ini ini = new Ini();
        //加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        //循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        //里面的键就是链接URL,值就是存在什么条件才能访问该链接
//        for (Iterator<Resource> it = list.iterator(); it.hasNext();) {
//
//            Resource resource = it.next();
        //如果不为空值添加到section中
//            if(StringUtils.isNotEmpty(resource.getValue()) && StringUtils.isNotEmpty(resource.getPermission())) {
//                section.put(resource.getValue(),  MessageFormat.format(PREMISSION_STRING,resource.getPermission()));
//            }

//        }
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

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }
}
