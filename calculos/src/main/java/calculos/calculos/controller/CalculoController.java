package calculos.calculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import calculos.calculos.entity.Entrada;
import calculos.calculos.entity.Saida;
import calculos.calculos.service.CalculoService;

@RestController
@RequestMapping("/api/calculo")
public class CalculoController {

	@Autowired
	private CalculoService calculoService;
	
	@PostMapping
	public ResponseEntity<Saida> calcular(@RequestBody Entrada entrada) {
		
		try {
			
			Saida saida = this.calculoService.calcular(entrada);
			return new ResponseEntity<> (saida, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
			
		}
		
	}
}
