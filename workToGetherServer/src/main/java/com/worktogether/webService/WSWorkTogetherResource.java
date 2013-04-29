package com.worktogether.webService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.worktogether.entities.Convite;
import com.worktogether.entities.Evento;
import com.worktogether.entities.Habilidade;
import com.worktogether.entities.Presenca;
import com.worktogether.entities.Publicacao;
import com.worktogether.entities.Usuario;

@Path("/worktogetherresource")
public class WSWorkTogetherResource {
	
	@GET
	@Path("/validarEmail")
	@Produces("application/json")
	public String validarEmail(){return "Hello!!!!";} 
	
	
	
	public List<Evento> cadastrarUsuario(Usuario usuario){return null;} 
	public void cadastrarEvento(Evento evento){} 
	public String autenticarUsuario(Usuario usuario){return null;} 
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
