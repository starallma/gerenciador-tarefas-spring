package com.tarefas.gerenciadortarefas.controller;

import com.tarefas.gerenciadortarefas.model.Tarefa;
import com.tarefas.gerenciadortarefas.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String filtro, Model model) {

        List<Tarefa> tarefas;

        if ("pendentes".equals(filtro)) {
            tarefas = service.listarPendentes();
        } else if ("concluidas".equals(filtro)) {
            tarefas = service.listarConcluidas();
        } else {
            tarefas = service.listarTodas();
            filtro = "todas";
        }

        int total = service.listarTodas().size();
        int pendentes = service.listarPendentes().size();
        int concluidas = service.listarConcluidas().size();

        model.addAttribute("tarefas", tarefas);
        model.addAttribute("filtro", filtro);

        model.addAttribute("total", total);
        model.addAttribute("pendentes", pendentes);
        model.addAttribute("concluidas", concluidas);

        return "lista";
    }

    @PostMapping
    public String salvar(Tarefa tarefa) {
        service.salvar(tarefa);
        return "redirect:/tarefas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/tarefas";
    }
}