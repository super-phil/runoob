package com.ssm.runoob.controller;

import com.ssm.runoob.model.User;
import com.ssm.runoob.service.TestService;
import com.ssm.runoob.service.UserService;
import com.ssm.runoob.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Created by Phil on 2016/2/24.
 *
 * @author Phil
 */
@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {

        return "test/index";
    }

    /**
     * Ftl string.
     *
     * @return the string
     * @author Phil
     */
    @RequestMapping(value = "ftl", method = RequestMethod.GET)
    public String ftl() {
        return "test/ftl";
    }

    /**
     * Jsp string.
     *
     * @return the string
     * @author Phil
     */
    @RequestMapping(value = "jsp", method = RequestMethod.GET)
    public String jsp() {
        return "test/jsp";
    }

    /**
     * Vm string.
     *
     * @return the string
     * @author Phil
     */
    @RequestMapping(value = "vm", method = RequestMethod.GET)
    public String vm() {
        return "test/vm";
    }

    /**
     * Json object.
     *
     * @param text the text
     * @return the object
     * @author Phil
     */
    @ResponseBody
    @RequestMapping(value = "json/{text}", method = RequestMethod.GET)
    public Object json(@PathVariable String text) {
        return testService.getTest(text);
    }

    /**
     * Ex string.
     *
     * @return the string
     * @author Phil
     */
    @RequestMapping(value = "ex", method = RequestMethod.GET)
    public String ex() {
        if (1 == 1) {
            throw new NullPointerException("测试全局异常!");
        }
        return "xx";
    }

    /**
     * Upload index string.
     *
     * @return the string
     * @author Phil
     */
    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String uploadIndex() {
        return "test/upload-index";
    }

    /**
     * Upload string.
     *
     * @param file the file
     * @return the string
     * @author Phil
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {
        FileUtils.upload(file, "e:\\", file.getOriginalFilename());
        return "redirect:/test/upload";
    }

    /**
     * Sess string.
     *
     * @param httpSession the http session
     * @return the string
     * @author Phil
     */
    @RequestMapping(value = "sess", method = RequestMethod.GET)
    public String sess(HttpSession httpSession) {
        httpSession.setAttribute("sess", "sess");
        return "test/sess";
    }

    /**
     * Sess 2 string.
     *
     * @return the string
     * @author Phil
     */
    @RequestMapping(value = "sess2", method = RequestMethod.GET)
    public String sess2() {
        return "test/sess2";
    }

    /**
     * Insert user string.
     *
     * @return the string
     * @author Phil
     */
    @ResponseBody
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String insertUser() {
        User user = new User();
        user.setName("test4");
        userService.insert(user);
        return "user";
    }

    @RequestMapping(value = "shiro", method = RequestMethod.GET)
    public String shiro() {

        return "test/index";
    }
}
