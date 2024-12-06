package com.example.estudar.repository;

import com.example.estudar.model.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<TarefasModel, Integer> {
    List<TarefasModel> findByStatus(String status);
    List<TarefasModel> findByIdResponsavel(int idResponsavel);
}
