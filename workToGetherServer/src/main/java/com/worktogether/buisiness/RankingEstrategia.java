package com.worktogether.buisiness;

import java.math.BigDecimal;

public interface RankingEstrategia {
	
	public BigDecimal rankiamento(Long id);
	
	//TODO MODELAR
	public BigDecimal calcularPontuacao(Long id);

}
