package com.ssm.runoob.service.impl;

import com.ssm.runoob.service.MailService;
import com.ssm.runoob.util.ConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Phil on 2016/4/1.
 */
@Service("mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void sendSimpleMail(String toAddress) {
        // 建立邮件消息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(javaMailSender.getUsername());
        simpleMailMessage.setTo("185509965@qq.com");
        simpleMailMessage.setSubject(" 测试简单文本邮件发送dds！ ");
        simpleMailMessage.setText(" 测试我的简单邮件发送机制ssss！！ ");
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sendSimpleMail(String toAddress, String subject, String text) {
        sendSimpleMail("xxx");
    }

    public void sendHtmlMail(String toAddress, String subject, String text) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom(javaMailSender.getUsername());
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText("<div>\n" +
                    "                        <span>频率:</span>\n" +
                    "                        <select id=\"fqcy\">\n" +
                    "                            <option value=\"5\">5s</option>\n" +
                    "                            <option value=\"15\">15s</option>\n" +
                    "                            <option value=\"30\">30s</option>\n" +
                    "                            <option value=\"45\">45s</option>\n" +
                    "                            <option value=\"60\">60s</option>\n" +
                    "                        </select>\n" +
                    "                    </div>",true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);

    }

}
