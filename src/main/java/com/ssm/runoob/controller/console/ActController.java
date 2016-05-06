package com.ssm.runoob.controller.console;

import com.alibaba.fastjson.JSONObject;
import com.ssm.runoob.model.DTRequest;
import com.ssm.runoob.model.DTResponse;
import com.ssm.runoob.util.ResultUtils;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * 工作流
 * User:  Phil
 * Project: runoob
 * Package: com.ssm.runoob.controller.console
 * Date: 2016/5/4
 * Time: 11:17
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("act")
public class ActController{
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ProcessEngine processEngine;

    /**
     * Procdef index string.
     *
     * @return the string
     */
    @RequestMapping(value = "procdef/index", method = RequestMethod.GET)
    public String procdefIndex() {
        return "console/act/procdef_list";
    }

    /**
     * Deploy index string.
     *
     * @return the string
     */
    @RequestMapping(value = "deploy/index", method = RequestMethod.GET)
    public String deployIndex() {
        return "console/act/deploy_list";
    }

    /**
     * 删除部署的流程
     * Del object.
     *
     * @param name the name
     * @param file the file
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "deploy/add", method = RequestMethod.POST)
    public Object addDeploy(@RequestParam("name") String name, @RequestParam("zip") MultipartFile file) {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            repositoryService.createDeployment().addZipInputStream(new ZipInputStream(inputStream)).name(name.trim()).deploy();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return ResultUtils.addSuccess();
    }

    /**
     * Deploy list object.
     *
     * @param dtRequest the dt request
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "deploy/index", method = RequestMethod.POST)
    public Object deployList(@RequestBody DTRequest dtRequest) {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery();
        List<Deployment> deployments;
        if (StringUtils.isBlank(dtRequest.getSearch())) {
            deployments = deploymentQuery.orderByDeploymenTime().desc().listPage(dtRequest.getStart(), dtRequest.getLength());
        } else {
            deployments = deploymentQuery.orderByDeploymenTime().deploymentNameLike("%" + dtRequest.getSearch() + "%").desc().listPage(dtRequest.getStart(), dtRequest.getLength());
        }
        List<JSONObject> list = new ArrayList<>(deployments.size());
        for (Deployment deployment : deployments) {
            JSONObject jo = new JSONObject();
            jo.put("id", deployment.getId());
            jo.put("name", deployment.getName());
            jo.put("time", deployment.getDeploymentTime());
            list.add(jo);
        }

        DTResponse<JSONObject> dtResponse = new DTResponse<>();

        dtResponse.setDraw(dtRequest.getDraw());
        long count = deploymentQuery.count();//总数
        dtResponse.setRecordsTotal(count);
        if (StringUtils.isBlank(dtRequest.getSearch())) {
            dtResponse.setRecordsFiltered(count);//有效数据
        } else {
            long scount = deploymentQuery.deploymentNameLike("%" + dtRequest.getSearch() + "%").count();
            dtResponse.setRecordsFiltered(scount);//有效数据
        }
        dtResponse.setData(list);

        return dtResponse;
    }

    /**
     * 删除部署的流程
     * Del object.
     *
     * @param deploymentId the deployment id
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "deploy/del", method = RequestMethod.POST)
    public Object delDeploy(@RequestParam("id") String deploymentId) {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.deleteDeployment(deploymentId, true);
        return ResultUtils.delSuccess();
    }

    /**
     * 流程定义
     * List object.
     *
     * @param dtRequest the dt request
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "procdef/index", method = RequestMethod.POST)
    public Object procdefList(@RequestBody DTRequest dtRequest) {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> processDefinitions;
        if (StringUtils.isBlank(dtRequest.getSearch())) {
            processDefinitions = processDefinitionQuery
                    .orderByProcessDefinitionVersion().desc()
                    .listPage(dtRequest.getStart(), dtRequest.getLength());
        } else {
            processDefinitions = processDefinitionQuery
                    .processDefinitionNameLike("%" + dtRequest.getSearch() + "%")
                    .orderByProcessDefinitionVersion().desc()
                    .listPage(dtRequest.getStart(), dtRequest.getLength());
        }


        List<JSONObject> list = new ArrayList<>(processDefinitions.size());
        for (ProcessDefinition processDefinition : processDefinitions) {
            JSONObject jo = new JSONObject();
            jo.put("id", processDefinition.getId());
            jo.put("name", processDefinition.getName());
            jo.put("version", processDefinition.getVersion());
            jo.put("key", processDefinition.getKey());
            list.add(jo);
        }

        DTResponse<JSONObject> dtResponse = new DTResponse<>();
        dtResponse.setDraw(dtRequest.getDraw());
        long count = processDefinitionQuery.count();//总数
        dtResponse.setRecordsTotal(count);
        if (StringUtils.isBlank(dtRequest.getSearch())) {
            dtResponse.setRecordsFiltered(count);//有效数据
        } else {
            long scount = processDefinitionQuery.processDefinitionNameLike("%" + dtRequest.getSearch() + "%").count();
            dtResponse.setRecordsFiltered(scount);//有效数据
        }
        dtResponse.setData(list);

        return dtResponse;
    }

}
