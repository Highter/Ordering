/*餐馆留言表*/

package bean;

import java.io.Serializable;

public class Rest_message implements Serializable {
	private int Message_ID; // BigInt 　　　自动生成的代码 primary
	private int Custom_ID; // Int 　　　用户ID Not null
	private int Rest_ID; // Int 　　　餐馆ID
	private String Time; // Datetime 　　　时间
	private String Message; // Varchar 200 　　　内容

	public Rest_message() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Rest_message(int custom_ID, int rest_ID, String time, String message) {
		super();
		Custom_ID = custom_ID;
		Rest_ID = rest_ID;
		Time = time;
		Message = message;
	}



	public Rest_message(int message_ID, int custom_ID, int rest_ID,
			String time, String message) {
		super();
		Message_ID = message_ID;
		Custom_ID = custom_ID;
		Rest_ID = rest_ID;
		Time = time;
		Message = message;
	}



	public int getMessage_ID() {
		return Message_ID;
	}

	public void setMessage_ID(int message_ID) {
		Message_ID = message_ID;
	}

	public int getCustom_ID() {
		return Custom_ID;
	}

	public void setCustom_ID(int custom_ID) {
		Custom_ID = custom_ID;
	}

	public int getRest_ID() {
		return Rest_ID;
	}

	public void setRest_ID(int rest_ID) {
		Rest_ID = rest_ID;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "Rest_message [Message_ID=" + Message_ID + ", Custom_ID="
				+ Custom_ID + ", Rest_ID=" + Rest_ID + ", Time=" + Time
				+ ", Message=" + Message + "]";
	}

}
