package com.ssm.runoob.controller.console;

import com.alibaba.fastjson.JSON;
import com.ssm.runoob.model.DTRequest;
import com.ssm.runoob.model.DTResponse;
import com.ssm.runoob.model.Privilege;
import com.ssm.runoob.model.TreeNode;
import com.ssm.runoob.service.PrivilegeService;
import com.ssm.runoob.service.TreeNodeService;
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
@RequestMapping("privilege")
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private TreeNodeService treeNodeService;
    private static final Logger logger = Logger.getLogger(UserController.class);

    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "console/privilege_list";
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
        List<Privilege> list = privilegeService.findByQueryAndOrderBy(dtRequest.getSearch(), dtRequest.getOrder(), dtRequest.getStart(), dtRequest.getLength());
        DTResponse<Privilege> dtResponse = new DTResponse<>();
        dtResponse.setDraw(dtRequest.getDraw());
        long count = privilegeService.count();
        dtResponse.setRecordsTotal(count);
        if (StringUtils.isBlank(dtRequest.getSearch())) {
            dtResponse.setRecordsFiltered(count);//有效数据
        } else {
            dtResponse.setRecordsFiltered(privilegeService.countByQuery(dtRequest.getSearch()));//有效数据
        }
        dtResponse.setData(list);
        return dtResponse;
    }

    /**
     * Insert object.
     *
     * @param privilege the privilege
     * @param pName     the p name
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Object insert(Privilege privilege, @RequestParam(value = "pName", required = false) String pName) {

        if (StringUtils.isNotBlank(pName)) {
            Privilege byName = privilegeService.findByName(pName);
            privilege.setParentId(byName.getId());
        }
        int v = privilegeService.insert(privilege);
        if (v > 0) {
            return ResultUtils.OperationSuccess();
        } else {
            return ResultUtils.OperationError(v);
        }
    }

    /**
     * Update object.
     *
     * @param privilege the privilege
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Object update(Privilege privilege) {
        int v = privilegeService.updateByPrimaryKeySelective(privilege);
        if (v > 0) {
            return ResultUtils.OperationSuccess();
        } else {
            return ResultUtils.OperationError(v);
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
        int v = privilegeService.deleteByPrimaryKey(id);
        if (v > 0) {
            return ResultUtils.OperationSuccess();
        } else {
            return ResultUtils.OperationError(v);
        }
    }

    /**
     * Tree object.
     *
     * @param id the id
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "tree", method = RequestMethod.POST)
    public Object tree(@RequestParam(value = "id", required = false) Long id) {
        List<TreeNode> list = new ArrayList<>();
        return ResultUtils.list(treeNodeService.getTree(0, list));
    }


}
