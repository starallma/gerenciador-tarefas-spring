package com.tarefas.gerenciadortarefas.service;

import com.tarefas.gerenciadortarefas.model.Tarefa;
import com.tarefas.gerenciadortarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    public List<Tarefa> listarPendentes() {
        return repository.findByConcluidaFalse();
    }

    public List<Tarefa> listarConcluidas() {
        return repository.findByConcluidaTrue();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}