package br.com.andrey.model.exception;

public class ObjetoInvalidoException extends PessoaModelException {

	private static final long serialVersionUID = 2958306664919145161L;

	public ObjetoInvalidoException(String msg) {
		super(msg);
	}
	
	public ObjetoInvalidoException(String msg, int httpStatus) {
		super(msg, httpStatus);
	}

}
