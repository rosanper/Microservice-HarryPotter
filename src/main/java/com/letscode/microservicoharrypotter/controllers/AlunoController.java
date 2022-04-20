package com.letscode.microservicoharrypotter.controllers;

import com.letscode.microservicoharrypotter.dto.AlunoRequest;
import com.letscode.microservicoharrypotter.dto.AlunoResponse;
import com.letscode.microservicoharrypotter.dto.clients.Casa;
import com.letscode.microservicoharrypotter.dto.clients.Chave;
import com.letscode.microservicoharrypotter.models.Aluno;
import com.letscode.microservicoharrypotter.services.ClientService;
import com.letscode.microservicoharrypotter.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private CrudService crudService;

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AlunoResponse create(@RequestBody AlunoRequest alunoRequest){
        Aluno aluno = crudService.create(alunoRequest);
        Casa casa = clientService.getCasa(aluno.getChaveDaCasaSeletora());
        return new AlunoResponse(aluno,casa);
    }

    @GetMapping
    public List<AlunoResponse> getAluno(@RequestParam(required = false) String chave){
        if (chave == null){
            return crudService.getAll().stream()
                    .map(aluno -> new AlunoResponse(aluno, clientService.getCasa(aluno.getChaveDaCasaSeletora())))
                    .collect(Collectors.toList());
        }

        List<AlunoResponse> response = new ArrayList<>();
        AlunoResponse aluno = crudService.getAlunoByChave(chave);
        response.add(aluno);
        return response;
    }


    // Teste para ver se estava funcionando a obtenção da chave e da casa
//    @GetMapping("/chave")
//    public String teste(@RequestParam(required = false) String chave){
//        if (chave != null){
//            Casa casa = clientService.getCasa(chave);
//            String name = casa.getName();
//            return name;
//        }
//        Chave key = clientService.getChave();
//        String chaveCasa = key.getSortingHatChoice();
//        return chaveCasa;
//    }
}
