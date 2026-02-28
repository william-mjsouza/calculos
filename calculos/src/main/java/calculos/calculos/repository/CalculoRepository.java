package calculos.calculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import calculos.calculos.entity.Saida;

public interface CalculoRepository extends JpaRepository<Saida, Long> {

}
