package com.ssm.runoob.controller.console;

import com.alibaba.fastjson.JSON;
import com.ssm.runoob.model.ActQJ;
import com.ssm.runoob.util.ResultUtils;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * User:  Phil
 * Project: runoob
 * Package: com.ssm.runoob.controller.console
 * Date: 2016/5/6
 * Time: 9:59
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("qj")
public class QingJiaController {
    private final Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private ProcessEngine processEngine;


    /**
     * Procdef index string.
     *
     * @return the string
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "console/act/qj";
    }

    /**
     * Add object.
     *
     * @param actQJ the act qj
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Object add(ActQJ actQJ) {


        //用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        processEngine.getIdentityService().setAuthenticatedUserId("user-id");
        //启动流程实例
//        String pid = processEngine.getRuntimeService().startProcessInstanceByKey("Qing_Jia_Tiao",)

        List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskCandidateGroup("admin").list();
        logger.debug(JSON.toJSONString(actQJ));
        return ResultUtils.success("ok");
    }

}
