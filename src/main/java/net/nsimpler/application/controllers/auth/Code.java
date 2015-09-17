package net.nsimpler.application.controllers.auth;

public class Code{
	private String code;
	private String label;
	
	public Code(String code, String name) {
		this.code = code;
		this.label = name;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}

}

