package br.edu.iffarroupilha.sigachat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iffarroupilha.sigachat.modelos.Preferencias;
import br.edu.iffarroupilha.sigachat.modelos.dto.PreferenciasDTO;
import br.edu.iffarroupilha.sigachat.services.PreferenciasService;

/**
 * <p>
 * Controle para delegar as ações pata a entidade Preferencias 
* </p>
* @author Professor
* @since Nov 6, 2024 8:24:36 PM
*/
@RestController
@RequestMapping("/preferencias")
public class PreferenciasControle {
	@Autowired
	private PreferenciasService servico;
		
	@PostMapping
    public ResponseEntity<Preferencias> gravar(@RequestBody PreferenciasDTO dto) {
        Preferencias p = new Preferencias();
        p.setTipoPreferencia(dto.tipoPreferencia());
        p.setValor(dto.valor());
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(servico.gravar(p));
    }

    @PutMapping
    public ResponseEntity<Preferencias> atualizar(@RequestBody PreferenciasDTO dto) {
        Preferencias preferencia = servico.buscarID(dto.idPreferencias());
        if (preferencia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        preferencia.setTipoPreferencia(dto.tipoPreferencia());
        preferencia.setValor(dto.valor());
        return ResponseEntity.status(HttpStatus.OK).body(servico.gravar(preferencia));
    }

    @DeleteMapping
    public ResponseEntity<Preferencias> delete(@RequestBody PreferenciasDTO dto) {
        Preferencias preferencia = servico.buscarID(dto.idPreferencias());
        if (preferencia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        servico.apagar(preferencia);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<Preferencias>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(servico.buscarTodos());
    }

}
