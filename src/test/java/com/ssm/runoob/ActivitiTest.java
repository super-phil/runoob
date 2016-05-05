package com.ssm.runoob;

import com.alibaba.fastjson.JSON;
import com.ssm.runoob.model.User;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * User:  Phil
 * Project: runoob
 * Package: com.ssm.runoob
 * Date: 2016/5/3
 * Time: 16:11
 * Created by IntelliJ IDEA.
 */
public class ActivitiTest extends BaseTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private SpringProcessEngineConfiguration springProcessEngineConfiguration;

    @Test //设置流程变量
    public void getVariables() {
        TaskService taskService = processEngine.getTaskService();
        //指定办理人
        String assignee = "张三";
        //流程实例ID
        String pdId = "37501";//
        Task task = taskService.createTaskQuery().processInstanceId(pdId).taskAssignee(assignee).singleResult();

        User variable = (User) taskService.getVariable(task.getId(), "人员信息");

        logger.info("#############"+ JSON.toJSONString(variable)+"###########");
    }

    @Test //设置流程变量
    public void setVariables() {
//        RuntimeService runtimeService = processEngine.getRuntimeService();
//        ProcessInstance processInstance = runtimeService.startProcessInstanceById("QING_JIA_TIAO:5:22504");

        TaskService taskService = processEngine.getTaskService();
        //指定办理人
        String assignee = "张三";
        //流程实例ID
        String pdId = "37501";//
        Task task = taskService.createTaskQuery().processInstanceId(pdId).taskAssignee(assignee).singleResult();

        //1 变量中存放基本数据类型
//        taskService.setVariable(task.getId(), "请假人", "张三");
//        taskService.setVariableLocal(task.getId(), "请假天数", 6);
//        taskService.setVariable(task.getId(), "请假日期", new LocalDateTime());
        //2.存 javabean 需要这个javabean实现了Serializable接口  private static final long serialVersionUID = -775808141942546102L;
        User user = new User();
        user.setName("王武");
        user.setEmail("717@163.com");
        user.setId(20L);

        taskService.setVariable(task.getId(), "人员信息", user);
    }


    @Test
    public void showImage() {
//        获取流程定义文档的资源（查看流程图附件）
        RepositoryService repositoryService = processEngine.getRepositoryService();
        String depId = "22501";
        List<String> resourceNames = repositoryService.getDeploymentResourceNames(depId);
        String imageName = null;
        for (String resourceName : resourceNames) {
            if (resourceName.endsWith(".png")) {
                imageName = resourceName;
            }
        }
        if (imageName != null) {
            File file = new File("e:\\" + imageName);
            InputStream resourceAsStream = repositoryService.getResourceAsStream(depId, imageName);
            try {
                FileUtils.copyInputStreamToFile(resourceAsStream, file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Test //查看指定人员任务
    public void hisTaskByUser() {
        String taskAssignee = "张三";
        List<HistoricTaskInstance> list = processEngine.getHistoryService()//与历史数据（历史表）相关的Service
                .createHistoricTaskInstanceQuery()//创建历史任务实例查询
                .taskAssignee(taskAssignee)//指定历史任务的办理人
                .list();
        if (list != null && list.size() > 0) {
            for (HistoricTaskInstance hti : list) {
                System.out.println(hti.getId() + "    " + hti.getName() + "    " + hti.getProcessInstanceId() + "   " + hti.getStartTime() + "   " + hti.getEndTime() + "   " + hti.getDurationInMillis());
                System.out.println("################################");
            }
        }
    }

    @Test //查看指定人员任务
    public void taskByUser() {
        String userName1 = "张三";
        String userName2 = "李四";
        String userName3 = "王五";
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userName2).orderByTaskCreateTime().desc().list();

        logger.info("#############[" + userName2 + "]的个人任务列表###########");
        for (Task task : tasks) {
            logger.debug("#############" + task.getName() + "###########");
            logger.debug("#############" + task.getCreateTime() + "###########");
            //办理任务
//            taskService.complete(task.getId());
        }
    }

    @Test //查看任务
    public void task() {
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().list();
        for (Task task : tasks) {
            logger.debug("#############" + task.getName() + "###########");
            logger.debug("#############" + task.getAssignee() + "###########");
        }
    }

    @Test //启动流程
    public void start() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceById("QING_JIA_TIAO:5:22504");
        logger.info("#############" + processInstance.getId() + "###########");
    }

    @Test //查询流程
    public void queryHis() {
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> historicActivityInstances = historyService.createHistoricActivityInstanceQuery().list();
        for (HistoricActivityInstance instance : historicActivityInstances) {
            logger.info("#############" + instance.getId() + "###########");
            logger.info("#############" + instance.getStartTime() + "###########");
            logger.info("#############" + instance.getAssignee() + "###########");
            logger.info("#############" + instance.getEndTime() + "###########");
        }
    }

    @Test //查询流程
    public void query() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        processDefinitionQuery
                //添加过滤条件
//     .processDefinitionName(processDefinitionName)
//     .processDefinitionId(processDefinitionId)
//     .processDefinitionKey(processDefinitionKey)
                //分页条件
//     .listPage(firstResult, maxResults)
                //排序条件
                .orderByProcessDefinitionVersion().desc();

        List<ProcessDefinition> pds = processDefinitionQuery.list();
        // 遍历集合，查看内容
        for (ProcessDefinition pd : pds) {
            System.out.print("id:" + pd.getId() + ",");
            System.out.print("name:" + pd.getName() + ",");
            System.out.print("key:" + pd.getKey() + ",");
            System.out.println("version:" + pd.getVersion());
        }
    }

    @Test //删除流程
    public void del() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        String depId = "2501";//流程定义ID
        repositoryService.deleteDeployment(depId, true);
    }

    @Test //部署流程定义
    public void deploy2() {
        logger.info("#############t1###########");
        RepositoryService repositoryService = processEngine.getRepositoryService();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("diagrams/QING_JIA_TIAO.zip");
        repositoryService.createDeployment().addZipInputStream(new ZipInputStream(in)).name("请假条").deploy();
    }

    @Test //部署流程定义
    public void deploy1() {
        logger.info("#############t1###########");
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagrams/QING_JIA_TIAO.bpmn").addClasspathResource("diagrams/QING_JIA_TIAO.png").name("请假条3").deploy();
    }

    @Test //创建23张表
    public void createTable() {
//        springProcessEngineConfiguration.setDatabaseSchemaUpdate(SpringProcessEngineConfiguration.DB_SCHEMA_UPDATE_DROP_CREATE);
        springProcessEngineConfiguration.buildProcessEngine();

    }

}
