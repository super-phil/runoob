package com.ssm.runoob;

import com.ssm.runoob.service.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Phil on 2016/3/28.
 */
public class MailTest extends BaseTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testCli() {
        mailService.sendHtmlMail("185509965@qq.com", "185509965", "xxx");
    }
}
