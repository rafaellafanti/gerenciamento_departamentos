package com.example.gerenciamento_departamentos.services;

import com.example.gerenciamento_departamentos.models.DepartamentoModel;
import com.example.gerenciamento_departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoModel salvar(DepartamentoModel departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<DepartamentoModel> listarTodos() {
        return departamentoRepository.findAll();
    }

    public DepartamentoModel buscarPorId(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public DepartamentoModel atualizar(Long id, DepartamentoModel departamentoAtualizado) {
        departamentoAtualizado.setId(id);
        return departamentoRepository.save(departamentoAtualizado);
    }

    public void deletar(Long id) {
        departamentoRepository.deleteById(id);
    }
}