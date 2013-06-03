package com.worktogether.buisiness;

import java.math.BigDecimal;

public class CalcularPontuacaoConfirmarPresenca implements CalculoPontuacaoEstrategia {

	@Override
	public BigDecimal calcularPontuacao(Long idUsuario) {
		return new BigDecimal(10);
	}

}
