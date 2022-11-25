package com.example.springboot.demo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailUtil {
    private static final String host="168.63.25.156";//邮箱ip
    private static final String port = "25";//邮箱端口
    private static final String fromUserName = "张辰";//发件人名字
    private static final String formAccount = "015754";//发件人名字
    private static final String password = "Admin@123";//发件人账号密码
    private static final  String subject = "这是邮件主题 this is subject";//主题
    private static final   String content = "这是邮件正文  this is content";//正文

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            // smtp地址
            props.setProperty("mail.host", host);
            // smtp端口
            props.setProperty("mail.port", port);
            props.setProperty("mail.smtp.auth", "true");
            //设置了附件名过长问题
            System.setProperty("mail.mime.splitlongparameters", "false");
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    //账号 密码
                    return new PasswordAuthentication(fromUserName, password);
                }
            });

            //1.创建一封邮件的实例对象
            MimeMessage msg = new MimeMessage(session);

            //2.设置发件人地址（昵称如果包含中文需要ENCODE否则乱码）
            String from = MimeUtility.encodeText(fromUserName) + " <"+ChineseToSpell.getPingYin(fromUserName)+formAccount+"@htzq.htsc.com.cn>";
            msg.setFrom(new InternetAddress(from));

            /**
             * 3.设置收件人地址（可以增加多个收件人、抄送、密送）（昵称如果包含中文需要ENCODE否则乱码）
             * MimeMessage.RecipientType.TO:发送
             * MimeMessage.RecipientType.CC：抄送
             * MimeMessage.RecipientType.BCC：密送
             */
            List<String> to = new ArrayList<>();
            to.add(MimeUtility.encodeText("DEMO收件人昵称") + " <test2@htzq.htsc.com.cn>");
            for (String each : to) {
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(each));
            }
            List<String> cc = new ArrayList<>();
            if (null != cc && cc.size() > 0) {
                for (String each : cc) {
                    msg.addRecipient(Message.RecipientType.CC, new InternetAddress(each));
                }
            }
            List<String> bcc = new ArrayList<>();
            if (null != bcc && bcc.size() > 0) {
                for (String each : bcc) {
                    msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(each));
                }
            }

            //4.设置邮件主题
            //String subject = "这是邮件主题 this is subject";
            msg.setSubject(subject, "utf-8");

            //5.设置正文
            MimeBodyPart text = new MimeBodyPart();
            //String content = "这是邮件正文  this is content";
            text.setContent(content, "text/html;charset=utf-8");

            //6.创建附件
            MimeBodyPart attachment = new MimeBodyPart();
            DataHandler dataHandler = new DataHandler(new FileDataSource(new File("src\\信创邮箱发送设置.doc")));
            attachment.setDataHandler(dataHandler);
            attachment.setFileName(MimeUtility.encodeText(dataHandler.getName()));

            //7.组合邮件的内容
            MimeMultipart mm = new MimeMultipart();
            mm.addBodyPart(text);
            // 如果有多个附件，可以创建多个多次添加
            mm.addBodyPart(attachment);
            // 混合关系
            mm.setSubType("mixed");

            //11.设置整个邮件的内容（由多个 BodyPart 组成的 Multipart）
            msg.setContent(mm);
            //12.设置邮件的发送时间,默认立即发送 (非必要)
            msg.setSentDate(new Date());

            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("send end!");
    }
}
