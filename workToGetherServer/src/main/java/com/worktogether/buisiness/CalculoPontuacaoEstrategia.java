package com.worktogether.buisiness;

import java.math.BigDecimal;

import com.worktogether.entities.Evento;
import com.worktogether.entities.Usuario;

public interface CalculoPontuacaoEstrategia {
	
	public BigDecimal calcularPontuacao(Usuario usuario, Evento evento);

}
