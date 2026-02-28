package calculos.calculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calculos.calculos.entity.Entrada;
import calculos.calculos.entity.Saida;
import calculos.calculos.repository.CalculoRepository;

@Service
public class CalculoService {
	
	@Autowired
	private CalculoRepository calculoRepository;
	
	public Saida calcular(Entrada entrada) {
		Saida saida = new Saida();
		
		saida.setSoma(this.somar(entrada.getLista()));
		
		saida.setMaiorNumero(this.buscarMAiorNumero(entrada.getLista()));
		
		saida = this.calculoRepository.save(saida);
		
		return saida;
		
	}
	
	public int somar(List<Integer> lista) {
		
		int soma = 0;
		for (int i = 0; i < lista.size(); i ++) {
			
			soma += lista.get(i);
		}
		
		return soma;
		
	}
	
	public int buscarMAiorNumero(List<Integer> lista) {
		
		int maiorNumero = lista.get(0);
		for (int i = 0; i < lista.size(); i ++) {
			
			if (maiorNumero < lista.get(i)) {
				maiorNumero = lista.get(i);
			}
			
		}
		
		return maiorNumero;
		
	}
}
