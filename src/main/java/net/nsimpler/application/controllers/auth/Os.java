package net.nsimpler.application.controllers.auth;

public class Os{
	private int code;
	private String label;
	
	public Os(int code, String name) {
		this.setCode(code);
		this.setLabel(name);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	

}

