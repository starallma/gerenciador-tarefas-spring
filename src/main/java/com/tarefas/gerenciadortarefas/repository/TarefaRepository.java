package com.tarefas.gerenciadortarefas.repository;

import com.tarefas.gerenciadortarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByConcluidaFalse();

    List<Tarefa> findByConcluidaTrue();
}