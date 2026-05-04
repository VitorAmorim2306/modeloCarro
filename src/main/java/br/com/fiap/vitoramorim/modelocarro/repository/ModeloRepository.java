package br.com.fiap.vitoramorim.modelocarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vitoramorim.modelocarro.model.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long>{

}