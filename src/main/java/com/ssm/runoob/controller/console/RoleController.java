package com.ssm.runoob.controller.console;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssm.runoob.model.DTRequest;
import com.ssm.runoob.model.DTResponse;
import com.ssm.runoob.model.Role;
import com.ssm.runoob.model.RolePrivilege;
import com.ssm.runoob.service.RoleService;
import com.ssm.runoob.util.ResultUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phil on 2016/4/15.
 */
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    private static final Logger logger = Logger.getLogger(UserController.class);

    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "console/role_list";
    }

    /**
     * List object.
     *
     * @param dtRequest the dt request
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "index", method = RequestMethod.POST)
    public Object list(@RequestBody DTRequest dtRequest) {
        List<Role> list = roleService.findByQueryAndOrderBy(dtRequest.getSearch(), dtRequest.getOrder(), dtRequest.getStart(), dtRequest.getLength());
        DTResponse<Role> dtResponse = new DTResponse<>();
        dtResponse.setDraw(dtRequest.getDraw());
        long count = roleService.count();
        dtResponse.setRecordsTotal(count);
        if (StringUtils.isBlank(dtRequest.getSearch())) {
            dtResponse.setRecordsFiltered(count);//有效数据
        } else {
            dtResponse.setRecordsFiltered(roleService.countByQuery(dtRequest.getSearch()));//有效数据
        }
        dtResponse.setData(list);
        return dtResponse;
    }

    /**
     * Insert object.
     *
     * @param role the role
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Object insert(Role role) {
        int v = roleService.insert(role);
        if (v > 0) {
            return ResultUtils.addSuccess();
        } else {
            return ResultUtils.addError();
        }
    }

    /**
     * Update object.
     *
     * @param role the role
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Object update(Role role) {
        int v = roleService.updateByPrimaryKeySelective(role);
        if (v > 0) {
            return ResultUtils.updateSuccess();
        } else {
            return ResultUtils.updateError();
        }
    }

    /**
     * Del object.
     *
     * @param id the id
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.POST)
    public Object del(@RequestParam("id") long id) {
        int v = roleService.deleteByPrimaryKey(id);
        if (v > 0) {
            return ResultUtils.delSuccess();
        } else {
            return ResultUtils.delError();
        }
    }

    /**
     * 给角色分配权限
     * Assign object.
     *
     * @param obj 权限ids
     * @return object object
     */
    @ResponseBody
    @RequestMapping(value = "assign", method = RequestMethod.POST)
    public Object assign(@RequestBody JSONObject obj) {
        //如果obj
        Long rid = obj.getLong("rid");
        logger.debug("rid" + rid);
        JSONArray ids = obj.getJSONArray("pids");
        Integer[] pids = ids.toArray(new Integer[ids.size()]);
        logger.debug("pids" + pids);

        if (null == rid) return ResultUtils.IllegalArgumentError();
        //如果 数组为0长度为0 的话就是全部删除
        //这里采用删除后重新插入的策略
        int v;
        if (pids.length == 0) {
            v = roleService.removeAssignAllByRID(rid);
        } else {
            List<RolePrivilege> rps = new ArrayList<>();
            for (Integer pid : pids) {
                RolePrivilege rp = new RolePrivilege();
                rp.setRoleId(rid);
                rp.setPrivilegeId(Long.valueOf(pid));
                rps.add(rp);
            }
            v = roleService.insertAssign(rps);
        }
        if (v > 0) {
            return ResultUtils.success("分配成功!");
        } else {
            return ResultUtils.error("分配失败!");
        }
    }

}
