package br.com.andrey.pessoa;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.andrey.model.exception.PessoaModelException;

@Path("/pessoas")
public class PessoaResource {
	
	@Inject private PessoaDatabaseManager model;
	private static final String APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON + "; charset=UTF-8";
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(APPLICATION_JSON_UTF8)
	public Response create(final Pessoa pessoa) {
		try {
			String uri = model.create(pessoa);
			return Response.created(URI.create(uri)).build();
		} catch (PessoaModelException e) {
			return Response.status(e.getHttpStatusCode()).entity(e.getErroEmJSON()).build();
		}
	}
	
	@GET
	@Path("/")
	@Produces(APPLICATION_JSON_UTF8)
	public Response getAll() {
		List<Object> pessoas = model.getAll();
		return Response.ok(pessoas).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(APPLICATION_JSON_UTF8)
	public Response getOne(@PathParam("id") String id) {
		Pessoa pessoa;
		try {
			pessoa = model.getOneById(id,true);
			return Response.ok(pessoa).build();
		} catch (PessoaModelException e) {
			return Response.status(e.getHttpStatusCode()).entity(e.getErroEmJSON()).build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(APPLICATION_JSON_UTF8)
	public Response update(@PathParam("id") String id, final Pessoa pessoa) {
		try {
			model.update(id, pessoa);
			return Response.ok().build();
		} catch (PessoaModelException e) {
			return Response.status(e.getHttpStatusCode()).entity(e.getErroEmJSON()).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(APPLICATION_JSON_UTF8)
	public Response delete(@PathParam("id") String id) {
		try {
			model.delete(id);
			return Response.ok().build();
		} catch (PessoaModelException e) {
			return Response.status(e.getHttpStatusCode()).entity(e.getErroEmJSON()).build();
		}
	}
	
}
