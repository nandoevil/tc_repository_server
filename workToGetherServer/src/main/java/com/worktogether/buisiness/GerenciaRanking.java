package com.worktogether.buisiness;

import java.math.BigDecimal;
import java.util.List;

import com.worktogether.entities.Evento;
import com.worktogether.entities.Usuario;

public class GerenciaRanking {
	
	private RankingEstrategia ranking; 
	private CalculoPontuacaoEstrategia calculoPontuacao;
	
	public BigDecimal calcularPontuacao(Usuario usuario, Evento evento, /*TODO DominioTipoPontuacao*/ String origem){
		return null;
	} 
	public void atualizarPontuacao(Usuario usuario, BigDecimal pontuacao){} 
	public List<Usuario> buscarRankingUsuario(Long colocacaoInicial, Long colocacaoFinal){
		return null;
	} 
	public List<Evento> buscarRankingEvento(Long colocacaoInicial, Long colocacaoFinal){
		return null;
	} 
	
	public RankingEstrategia getRanking() {
		return ranking;
	}
	public void setRanking(RankingEstrategia ranking) {
		this.ranking = ranking;
	}
	public CalculoPontuacaoEstrategia getCalculoPontuacao() {
		return calculoPontuacao;
	}
	public void setCalculoPontuacao(CalculoPontuacaoEstrategia calculoPontuacao) {
		this.calculoPontuacao = calculoPontuacao;
	} 
	
}
