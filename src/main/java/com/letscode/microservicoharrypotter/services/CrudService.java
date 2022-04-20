package com.letscode.microservicoharrypotter.services;

import com.letscode.microservicoharrypotter.dto.AlunoRequest;
import com.letscode.microservicoharrypotter.models.Aluno;
import com.letscode.microservicoharrypotter.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ClientService clientService;

    public Aluno create(AlunoRequest alunoRequest) {
        Aluno aluno = new Aluno();
        aluno.setSerie(alunoRequest.getSerie());
        aluno.setNome(alunoRequest.getName());
        alunoRepository.save(aluno);
        return aluno;
    }

    public Aluno getAluno(String nome) {
        Aluno aluno = alunoRepository.findByNome(nome).orElseThrow();
        return aluno;
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }
}
