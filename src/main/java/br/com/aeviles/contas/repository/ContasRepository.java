package br.com.aeviles.contas.repository;

import br.com.aeviles.contas.model.Contas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ContasRepository extends JpaRepository<Contas, Long> {

}
