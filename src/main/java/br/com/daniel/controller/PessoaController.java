package br.com.daniel.controller;

import br.com.daniel.model.Pessoa;
import br.com.daniel.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List getPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePessoa(@PathVariable("id") Integer id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoaRepository.delete(pessoa);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, Pessoa pessoa) {
        return pessoaRepository.findById(id)
                .map(p -> {
                    p.setNome(pessoa.getNome());
                    p.setIdade(pessoa.getIdade());

                    return ResponseEntity.ok().body(pessoaRepository.save(p));
                }).orElse(ResponseEntity.notFound().build());
    }
}
