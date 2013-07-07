package com.worktogether.buisiness;

import java.math.BigDecimal;

public class RankingEvento implements RankingEstrategia {

	public BigDecimal rankiamento(Long id) {
		return new BigDecimal(1);
	}

	public BigDecimal calcularPontuacao(Long id) {
		return new BigDecimal(1);
	}

}
