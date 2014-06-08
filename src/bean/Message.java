package bean;

public class Message {

	private String custom_name;
	private String time;
	private String message;
	public String getCustom_name() {
		return custom_name;
	}
	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Message() {
		super();
	}
	public Message(String custom_name, String time, String message) {
		super();
		this.custom_name = custom_name;
		this.time = time;
		this.message = message;
	}
}
