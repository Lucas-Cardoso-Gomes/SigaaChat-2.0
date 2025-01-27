package br.edu.iffarroupilha.sigachat.modelos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iffarroupilha.sigachat.modelos.Grupo;

/**
 * <p>
 * Especificação dos comportamentos de persistencia da entidade grupo
 * </p>
 * 
 * @author Professor
 * @since Nov 6, 2024 7:29:36 PM
 */

public interface GrupoRepositorio
           extends JpaRepository<Grupo, Long> {
	public List<Grupo> findByNome(String nome);
}
