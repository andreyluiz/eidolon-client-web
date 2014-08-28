package br.com.andrey.model.exception;

public class ObjetoNaoEncontradoException extends PessoaModelException {

	private static final long serialVersionUID = -4869277114972198312L;

	public ObjetoNaoEncontradoException(String msg) {
		super(msg, 404);
	}
	
	public ObjetoNaoEncontradoException(String msg, int httpStatus) {
		super(msg, httpStatus);
	}

}
