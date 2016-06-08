package com.ssm.runoob.controller.console;

import com.alibaba.fastjson.JSONObject;
import com.ssm.runoob.model.DTRequest;
import com.ssm.runoob.model.DTResponse;
import com.ssm.runoob.model.Role;
import com.ssm.runoob.model.User;
import com.ssm.runoob.service.RoleService;
import com.ssm.runoob.service.UserService;
import com.ssm.runoob.util.ResultUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Phil on 2016/3/3.
 *
 * @author Phil
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private static final Logger logger = Logger.getLogger(UserController.class);

    /**
     * Index string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        List<Role> roles = roleService.getAll();
        model.addAttribute("roles", roles);
        return "console/user_list";
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
        List<User> list = userService.findByQueryAndOrderBy(dtRequest.getSearch(), dtRequest.getOrder(), dtRequest.getStart(), dtRequest.getLength());
        DTResponse<User> dtResponse = new DTResponse<>();
        dtResponse.setDraw(dtRequest.getDraw());
        long count = userService.count();
        dtResponse.setRecordsTotal(count);
        if (StringUtils.isBlank(dtRequest.getSearch())) {
            dtResponse.setRecordsFiltered(count);//有效数据
        } else {
            dtResponse.setRecordsFiltered(userService.countByQuery(dtRequest.getSearch()));//有效数据
        }
        dtResponse.setData(list);
        return dtResponse;
    }

    /**
     * Insert object.
     *
     * @param user the user
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Object insert(User user) {
        int v = userService.insert(user);
        if (v > 0) {
            return ResultUtils.OperationSuccess();
        } else {
            return ResultUtils.OperationError(v);
        }
    }

    /**
     * Update object.
     *
     * @param user the user
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Object update(User user) {
        int v = userService.updateByPrimaryKeySelective(user);
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
        int v = userService.deleteByPrimaryKey(id);
        if (v > 0) {
            return ResultUtils.OperationSuccess();
        } else {
            return ResultUtils.OperationError(v);
        }
    }

    /**
     * Assign object.
     *
     * @param obj the obj
     * @return the object
     */
    @ResponseBody
    @RequestMapping(value = "assign", method = RequestMethod.POST)
    public Object assign(@RequestBody JSONObject obj) {
        Long uid = obj.getLong("uid");
        Long rid = obj.getLong("rid");
        if (null == uid || null == rid) return ResultUtils.illegalArgumentError("uid|rid");
        int v = userService.insertAssign(uid, rid);
        if (v > 0) {
            return ResultUtils.success("分配成功!");
        } else {
            return ResultUtils.error("分配失败!");
        }
    }

}
