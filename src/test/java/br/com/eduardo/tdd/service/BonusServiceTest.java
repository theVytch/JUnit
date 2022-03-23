package br.com.eduardo.tdd.service;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.eduardo.tdd.modelo.Funcionario;
import br.com.eduardo.tdd.service.BonusService;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMaiorQueMil() {
		BonusService bonusService = new BonusService();
		
		//assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("eduardo", LocalDate.now(), new BigDecimal("25000"))));
		
		try {
			bonusService.calcularBonus(new Funcionario("eduardo", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu a exception");
		} catch (Exception e) {
			assertEquals("Funcionario com salario maior que R$1000", e.getMessage());
		}
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("eduardo", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.0"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("eduardo", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.0"), bonus);
	}


}
