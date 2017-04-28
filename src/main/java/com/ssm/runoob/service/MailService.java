package com.ssm.runoob.service;

/**
 * Created by Phil on 2016/4/1.
 */
public interface MailService {

    /**
     * Send simple mail.
     *
     * @param toAddress the  收件人地址
     * @param subject   the  主题
     * @param text      the  内容
     */
    void sendSimpleMail(String toAddress, String subject, String text);

    /**
     * Send html mail.
     *
     * @param toAddress the to address
     * @param subject   the subject
     * @param text      the text
     */
    void sendHtmlMail(String toAddress, String subject, String text);
}
