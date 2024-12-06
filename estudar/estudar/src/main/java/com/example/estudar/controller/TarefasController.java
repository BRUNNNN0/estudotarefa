package com.example.estudar.controller;


import com.example.estudar.model.TarefasModel;
import com.example.estudar.model.UsuarioModel;
import com.example.estudar.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping//
    public TarefasModel criartarefa(@RequestBody TarefasModel tarefa){
        return tarefaService.criartarefa(tarefa);
    }

    @GetMapping("/{status}")//
    public List<TarefasModel> findByStatus(@PathVariable String status){
        return tarefaService.findByStatus(status);
    }

    @GetMapping("/{id}/usuario")//
    public List<TarefasModel> findByIdResponsavel(@PathVariable int id){
        return tarefaService.findByIdResponsavel(id);
    }

    @PutMapping("/{id}")//
    public TarefasModel updatetarefa(@PathVariable int id, @RequestBody TarefasModel tarefa){
        return tarefaService.updatetarefa(id, tarefa);
    }

    @PutMapping("/mover_backlog/{id}")//
    public TarefasModel backlog(@PathVariable int id){
        return tarefaService.backlog(id);
    }

    @PutMapping("/mover_Em_Progresso/{id}")//
    public TarefasModel emProgresso(@PathVariable int id){
        return tarefaService.emProgresso(id);
    }

    @PutMapping("/mover_concluido/{id}")//
    public TarefasModel concluido(@PathVariable int id){
        return tarefaService.concluido(id);
    }

    @DeleteMapping("/deletar_tarefa/{id}")//
    public TarefasModel deletarTarefa(@PathVariable int id){
        return tarefaService.deletarTarefa(id);
    }
}
