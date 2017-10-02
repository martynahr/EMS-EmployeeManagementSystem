package app.model;

public class MsgModel {
	private String msg_from;
	private String msg_to;
	private String msg_subject;
	private String msg_content;
	
	public String getMsg_from() {
		return msg_from;
	}
	public void setMsg_from(String msg_from) {
		this.msg_from = msg_from;
	}
	public String getMsg_to() {
		return msg_to;
	}
	public void setMsg_to(String msg_to) {
		this.msg_to = msg_to;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	
	
	public String getMsg_subject() {
		return msg_subject;
	}
	public void setMsg_subject(String msg_subject) {
		this.msg_subject = msg_subject;
	}
	public MsgModel (){}
	public MsgModel(String msg_from, String msg_to, String msg_subject, String msg_content) {
		super();
		this.msg_from = msg_from;
		this.msg_to = msg_to;
		this.msg_subject = msg_subject;
		this.msg_content = msg_content;
	}
	
	}
	
	
	
