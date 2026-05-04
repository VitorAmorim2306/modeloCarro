package br.com.fiap.vitoramorim.modelocarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vitoramorim.modelocarro.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
