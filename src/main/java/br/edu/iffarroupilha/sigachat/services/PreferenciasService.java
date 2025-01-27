package br.edu.iffarroupilha.sigachat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.iffarroupilha.sigachat.modelos.Preferencias;
import br.edu.iffarroupilha.sigachat.modelos.repositorios.PreferenciasRepositorio;

/**
 * <p>
 * Classe de servico para entidade Preferencias
* </p>
* @author Professor
* @since Nov 6, 2024 8:23:07 PM
*/
@Service
public class PreferenciasService  extends AService{
	private PreferenciasRepositorio repositorio;
	
	public PreferenciasService(PreferenciasRepositorio repositorio) {
		super(repositorio);
		this.repositorio = repositorio;
	}
	public Preferencias atualizar(Preferencias preferencias) {
        return repositorio.save(preferencias);
    }

    public void apagar(Preferencias preferencias) {
        this.repositorio.delete(preferencias);
    }

    public Preferencias buscarID(Long id) {
        Optional<Preferencias> preferencias = repositorio.findById(id);
        return preferencias.orElse(null);
    }

    public List<Preferencias> buscarTodos() {
        return this.repositorio.findAll();
    }

}
