package br.com.daniel.controller;

import br.com.daniel.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PessoaController {
    @GetMapping
    public ResponseEntity<List<Pessoa>> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Daniel");
        pessoa1.setIdade(27);

        pessoas.add(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Tuxu");
        pessoa2.setIdade(25);

        pessoas.add(pessoa2);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(pessoas);
    }

    @GetMapping(path = "/{nome}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable("nome") String nome) {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Daniel");
        pessoa1.setIdade(27);

        pessoas.add(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Tuxu");
        pessoa2.setIdade(25);

        pessoas.add(pessoa2);

        for (Pessoa p: pessoas) {
            if (p.getNome().equals(nome)) {
                return ResponseEntity.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p);
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Pessoa());
    }
}
