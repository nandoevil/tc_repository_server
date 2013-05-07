package com.worktogether.webService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.spi.HttpResponse;

import com.worktogether.buisiness.GerenciaEvento;
import com.worktogether.buisiness.GerenciaUsuario;
import com.worktogether.entities.Convite;
import com.worktogether.entities.Evento;
import com.worktogether.entities.Habilidade;
import com.worktogether.entities.Presenca;
import com.worktogether.entities.Publicacao;
import com.worktogether.entities.Usuario;

@Path("/worktogetherresource")
public class WSWorkTogetherResource {
	
	@Context 
	HttpResponse response;
	
	@Inject
	GerenciaUsuario gru;
	
	@Inject
	GerenciaEvento gre;
	
	@POST
	@Path("/validarEmail")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String validarEmail(String email){
		
		return gru.isEmailExistente(email);
			
	} 
	
	@POST
	@Path("/cadastrarUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Evento> cadastrarUsuario(Usuario usuario){
		return gru.cadastrarUsuario(usuario);
		
	}
	
	@GET
	@Path("/test")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Integer test() {
		return 1;
	} 
	
	@POST
	@Path("/cadastrarEvento")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void cadastrarEvento(Evento evento){
		gre.cadastrarEvento(evento);
	} 
	
	@POST
	@Path("/autenticarUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String autenticarUsuario(Usuario usuario){
		return gru.autenticarUsuario(usuario);
	} 
	
	public List<Evento> buscarRankingEvento(Long colocacaoInicial, Long colocacaoFinal){return null;} 
	public List<Usuario> buscarRankingUsuario(Long colocacaoInicial, Long colocacaoFinal){return null;} 
	public String publicar(Publicacao publicacao){return null;} 
	public List<Evento> buscarEventos(Long idUsuario){return null;} 
	public List<Convite> enviarConviteAutomatico(Usuario usuario, String localizacao){return null;} 
	public void indicarPresenca(List<Presenca> presencas){} 
	public List<Habilidade> buscarHabilidades(Long inicio, Long fiim){return null;} 
	public String atualizarListaEventosUsuairo(Usuario usuario, List<Presenca> eventos){return null;} 
	public String confirmarPresenca(Presenca presencao, String localizacaoAtual){return null;} 
	public List<Evento> verificarAtualizacaoEventos(Long idUltimoEvento){return null;} 

}
