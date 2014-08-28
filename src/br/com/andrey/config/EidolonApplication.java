package br.com.andrey.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.andrey.pessoa.PessoaResource;

@ApplicationPath("/*")
public class EidolonApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(PessoaResource.class);
		return classes;
	}
	
}
