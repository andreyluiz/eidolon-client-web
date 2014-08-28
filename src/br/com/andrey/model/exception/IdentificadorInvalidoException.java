package br.com.andrey.model.exception;

public class IdentificadorInvalidoException extends PessoaModelException {

	private static final long serialVersionUID = 9080008890542971298L;

	public IdentificadorInvalidoException(String msg) {
		super(msg);
	}
	
	public IdentificadorInvalidoException(String msg, int httpStatus) {
		super(msg, httpStatus);
	}
	
}
