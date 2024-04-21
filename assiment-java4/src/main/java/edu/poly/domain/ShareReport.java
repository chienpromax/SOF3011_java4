package edu.poly.domain;

import java.util.Date;

public class ShareReport {
	private String username;
	private String SenderEmail;
	private String ReceiverEmail;
	private Date shareDate;
	
	
	public ShareReport() {
		super();
	}
	public ShareReport(String username, String senderEmail, String receiverEmail, Date shareDate) {
		this.username = username;
		this.SenderEmail = senderEmail;
		this.ReceiverEmail = receiverEmail;
		this.shareDate = shareDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenderEmail() {
		return SenderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		SenderEmail = senderEmail;
	}
	public String getReceiverEmail() {
		return ReceiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		ReceiverEmail = receiverEmail;
	}
	public Date getShareDate() {
		return shareDate;
	}
	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
	
}
