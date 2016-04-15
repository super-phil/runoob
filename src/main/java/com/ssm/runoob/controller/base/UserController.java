package com.ssm.runoob.controller.base;

import com.alibaba.fastjson.JSON;
import com.ssm.runoob.model.DTRequest;
import com.ssm.runoob.model.DTResponse;
import com.ssm.runoob.model.User;
import com.ssm.runoob.service.UserService;
import com.ssm.runoob.util.MsgUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "base/user_list";
    }

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
        return JSON.toJSON(dtResponse);
    }

    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Object insert(User user) {
        int v = userService.insert(user);
        if (v > 0) {
            return MsgUtils.addSuccess();
        } else {
            return MsgUtils.addError();
        }
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Object update(User user) {
        int v = userService.updateByPrimaryKeySelective(user);
        if (v > 0) {
            return MsgUtils.updateSuccess();
        } else {
            return MsgUtils.updateError();
        }
    }

    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.POST)
    public Object del(@RequestParam("id") long id) {
        int v = userService.deleteByPrimaryKey(id);
        if (v > 0) {
            return MsgUtils.delSuccess();
        } else {
            return MsgUtils.delError();
        }
    }

}
