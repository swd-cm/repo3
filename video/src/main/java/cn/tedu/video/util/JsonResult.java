package cn.tedu.video.util;
/**
 *封装响应的json结果的类 
 *
 */
public class JsonResult<T>{
	private String message;
	private Integer state;
	private T data;
	public String getMessage() {
		return message;
	}
	public JsonResult() {
		// TODO Auto-generated constructor stub
	}
	
	public JsonResult(Throwable e) {
		super();
		this.message = e.getMessage();
	}
	
	public JsonResult(Integer state) {
		super();
		this.state = state;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
