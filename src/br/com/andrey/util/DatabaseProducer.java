package br.com.andrey.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

@ApplicationScoped
public class DatabaseProducer {
	@Produces
	public ODB open() {
		return ODBFactory.open("data.db");
	}

	public void close(@Disposes ODB odb) {
		if (odb!= null && !odb.isClosed())
			odb.close();
	}
}
