package br.com.andrey.model.exception;

public class PessoaModelException extends Exception {

	private static final long serialVersionUID = 5968931500728525772L;

	private int httpStatusCode = 500;
	
	public PessoaModelException(String msg) {
		super(msg);
	}
	
	public PessoaModelException(String msg, int httpStatus) {
		super(msg);
		this.httpStatusCode = httpStatus;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
	public String getErroEmJSON() {
		return "{ \"status\": "+ getHttpStatusCode() + ", \"message\": \"" + getMessage() + "\" }";
	}
	
}
