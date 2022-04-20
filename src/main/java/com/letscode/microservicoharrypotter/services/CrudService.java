package com.letscode.microservicoharrypotter.services;

import com.letscode.microservicoharrypotter.dto.AlunoRequest;
import com.letscode.microservicoharrypotter.dto.AlunoResponse;
import com.letscode.microservicoharrypotter.dto.clients.Casa;
import com.letscode.microservicoharrypotter.dto.clients.Chave;
import com.letscode.microservicoharrypotter.exceptions.NotFoundError;
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

        Chave chave = clientService.getChave();
        aluno.setChaveDaCasaSeletora(chave.getSortingHatChoice());

        alunoRepository.save(aluno);
        return aluno;
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public AlunoResponse getAlunoByChave(String chave){
        Aluno aluno = alunoRepository.findByChaveDaCasaSeletora(chave)
                .orElseThrow(() -> new NotFoundError("Não foi encontrado aluno com essa chave"));
        Casa casa = clientService.getCasa(aluno.getChaveDaCasaSeletora());
        return new AlunoResponse(aluno,casa);
    }

    public Aluno getAlunoByNome(String nome) {
        Aluno aluno = alunoRepository.findByNome(nome).orElseThrow();
        return aluno;
    }
}
