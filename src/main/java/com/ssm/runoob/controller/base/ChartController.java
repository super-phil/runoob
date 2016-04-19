package com.ssm.runoob.controller.base;

import com.ssm.runoob.util.ResultUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * The type Chart controller.
 */
@Controller
@RequestMapping("chart")
public class ChartController {

    /**
     * SELECT
     * DATE_FORMAT(create_time, '%h:%s') AS hs,
     * COUNT(id)
     * FROM
     * USER
     * WHERE DATE_SUB(NOW(), INTERVAL 5 SECOND  ) <= create_time
     *
     * @param interval the interval
     * @return object
     */
    @ResponseBody
    @RequestMapping(value = "ajax", method = RequestMethod.POST)
    public Object chart(@RequestParam(value = "interval", required = false) int interval) {
//        Map<String, Object> data = userService.getIntervalData(interval);
        Map<String, Object> data = new HashMap<>();
        data.put("x", new DateTime().toString("HH:mm:ss"));
        data.put("y", new Random().nextInt(99));
        return ResultUtils.success(data);
    }
}
