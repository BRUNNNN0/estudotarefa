package com.example.estudar.service;

import com.example.estudar.model.TarefasModel;
import com.example.estudar.model.UsuarioModel;
import com.example.estudar.repository.TarefaRepository;
import com.example.estudar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;



    public TarefasModel criartarefa(TarefasModel tarefa) {
        tarefa.setStatus("backlog");
        return tarefaRepository.save(tarefa);
    }

    public List<TarefasModel> findByStatus(String status) {
        return tarefaRepository.findByStatus(status);
    }

    public List<TarefasModel> findByIdResponsavel(int idResponsavel) {
        return tarefaRepository.findByIdResponsavel(idResponsavel);
    }

    public TarefasModel updatetarefa(int id, TarefasModel tarefa) {
        Optional<TarefasModel> tarefaselecionada = tarefaRepository.findById(id);
        tarefaselecionada.get().setTitulo(tarefa.getTitulo());
        tarefaselecionada.get().setDescricao(tarefa.getDescricao());
        tarefaselecionada.get().setStatus(tarefa.getStatus());
        tarefaselecionada.get().setIdResponsavel(tarefa.getIdResponsavel());
        return tarefaRepository.save(tarefaselecionada.get());
    }

    public TarefasModel deletarTarefa(int id) {
        Optional<TarefasModel> tarefa = tarefaRepository.findById(id);
        TarefasModel deletar = tarefa.get();
        tarefaRepository.delete(deletar);
        return deletar;
    }

    public TarefasModel backlog(int id) {
        Optional<TarefasModel> tarefa = tarefaRepository.findById(id);
        tarefa.get().setStatus("backlog");
        return tarefaRepository.save(tarefa.get());
    }

    public TarefasModel emProgresso(int id) {
        Optional<TarefasModel> tarefa = tarefaRepository.findById(id);
        tarefa.get().setStatus("Em Progresso");
        return tarefaRepository.save(tarefa.get());
    }

    public TarefasModel concluido(int id) {
        Optional<TarefasModel> tarefa = tarefaRepository.findById(id);
        tarefa.get().setStatus("concluido");
        return tarefaRepository.save(tarefa.get());
    }


}



