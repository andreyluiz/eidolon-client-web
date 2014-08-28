package br.com.andrey.pessoa;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import br.com.andrey.model.exception.IdentificadorInvalidoException;
import br.com.andrey.model.exception.ObjetoInvalidoException;
import br.com.andrey.model.exception.ObjetoNaoEncontradoException;
import br.com.andrey.util.Util;

public class PessoaDatabaseManager {

	@Inject private ODB odb;
	
	public String create(Pessoa pessoa) throws ObjetoInvalidoException {
		if (pessoa == null) throw new ObjetoInvalidoException("O objeto passado para criação é inválido.");
		odb.store(pessoa);
		return "/pessoas/" + pessoa.getId();
	}

	public List<Object> getAll() {
		Objects<Pessoa> result = odb.getObjects(Pessoa.class);
		return Arrays.asList(result.toArray());
	}

	public Pessoa getOneById(String id, boolean manageDB) throws ObjetoNaoEncontradoException, IdentificadorInvalidoException {
		if (!Util.isNumber(id)) throw new IdentificadorInvalidoException("O identificador é inválido.");
		return getById(id);
	}
	
	private Pessoa getById(String id) throws ObjetoNaoEncontradoException {
		IQuery query = new CriteriaQuery(Pessoa.class, Where.equal("id", Integer.valueOf(id)));
		Objects<Pessoa> result = odb.getObjects(query);
		if (result.size() == 0) throw new ObjetoNaoEncontradoException("O objeto com id " + id + " não foi encontrado.");
		return result.getFirst();
	}

	public void update(String id, Pessoa pessoa) throws ObjetoNaoEncontradoException, IdentificadorInvalidoException, ObjetoInvalidoException {
		if (pessoa == null) throw new ObjetoInvalidoException("O objeto passado para alteração é inválido.");
		Pessoa pessoaParaAlterar = getById(id);
		pessoaParaAlterar.setNome(pessoa.getNome());
		odb.store(pessoaParaAlterar);
	}

	public void delete(String id) throws ObjetoNaoEncontradoException, IdentificadorInvalidoException {
		odb.delete(getById(id));
	}

}
