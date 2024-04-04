package edu.poly.domain;

public class Email {
	private String from, to, fromPassword, content, subject;

	public Email() {

	}

	public Email(String from, String to, String fromPassword, String content, String subject) {
		super();
		this.from = from;
		this.to = to;
		this.fromPassword = fromPassword;
		this.content = content;
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFromPassword() {
		return fromPassword;
	}

	public void setFromPassword(String fromPassword) {
		this.fromPassword = fromPassword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
