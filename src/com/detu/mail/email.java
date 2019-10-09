package com.detu.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class email {
	public static void main(String[] args) throws AddressException, MessagingException {
		MailUtils.sendMail("1983928995@qq.com", "ceshi", "helloworld");
	}

}
