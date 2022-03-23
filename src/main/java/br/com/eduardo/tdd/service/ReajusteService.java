package br.com.eduardo.tdd.service;

import java.math.BigDecimal;

import br.com.eduardo.tdd.modelo.Desempenho;
import br.com.eduardo.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
	
			BigDecimal percentual = desempenho.percentualReajuste();
			BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
			funcionario.reajustarSalario(reajuste);
		
	}

}
