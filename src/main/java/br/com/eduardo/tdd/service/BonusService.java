package br.com.eduardo.tdd.service;

import java.math.BigDecimal;

import br.com.eduardo.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionario com salario maior que R$1000");
		}
		
		return valor;
	}

}
