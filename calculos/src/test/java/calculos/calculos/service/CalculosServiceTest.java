package calculos.calculos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculosServiceTest {

	// OBS: Classes teste tem atributos e métodos com visibilidade default (mesmo pacote)
	@Autowired
	CalculoService calculoService;

	@Test
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.calculoService.somar(lista);
	
		// assertEquals(10, retorno) -> lado esquerdo é o resultado esperado e lado direito é o resultado que a aplicação deu
		assertEquals(11, retorno);
	}
	
	@Test
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(4);
		lista.add(5);
	
		assertThrows(Exception.class, () -> {
			int retorno = this.calculoService.somar(lista);
		});
	}
	
}
