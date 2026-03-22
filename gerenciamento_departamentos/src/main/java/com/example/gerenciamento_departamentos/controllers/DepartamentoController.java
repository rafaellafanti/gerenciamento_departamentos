package com.example.gerenciamento_departamentos.controllers;

import com.example.gerenciamento_departamentos.models.DepartamentoModel;
import com.example.gerenciamento_departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoModel> criar(@RequestBody DepartamentoModel departamento) {
        DepartamentoModel novo = departamentoService.salvar(departamento);
        URI uri = URI.create("/departamentos/" + novo.getId());
        return ResponseEntity.created(uri).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> listar() {
        return ResponseEntity.ok(departamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> buscar(@PathVariable Long id) {
        DepartamentoModel departamento = departamentoService.buscarPorId(id);

        if (departamento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> atualizar(@PathVariable Long id, @RequestBody DepartamentoModel departamento){
        DepartamentoModel atualizado = departamentoService.atualizar(id, departamento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        departamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
