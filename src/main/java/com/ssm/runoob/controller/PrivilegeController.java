package com.ssm.runoob.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.runoob.controller.base.UserController;
import com.ssm.runoob.model.DTRequest;
import com.ssm.runoob.model.DTResponse;
import com.ssm.runoob.model.Privilege;
import com.ssm.runoob.service.PrivilegeService;
import com.ssm.runoob.util.MsgUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Phil on 2016/4/15.
 */
@Controller
@RequestMapping("privilege")
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;
    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "base/privilege_list";
    }

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
        return JSON.toJSON(dtResponse);
    }

    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Object insert(Privilege privilege) {
        int v = privilegeService.insert(privilege);
        if (v > 0) {
            return MsgUtils.addSuccess();
        } else {
            return MsgUtils.addError();
        }
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Object update(Privilege privilege) {
        int v = privilegeService.updateByPrimaryKeySelective(privilege);
        if (v > 0) {
            return MsgUtils.updateSuccess();
        } else {
            return MsgUtils.updateError();
        }
    }

    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.POST)
    public Object del(@RequestParam("id") long id) {
        int v = privilegeService.deleteByPrimaryKey(id);
        if (v > 0) {
            return MsgUtils.delSuccess();
        } else {
            return MsgUtils.delError();
        }
    }
}
