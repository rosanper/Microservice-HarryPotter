package com.letscode.microservicoharrypotter.dto;

import com.letscode.microservicoharrypotter.dto.clients.Casa;
import com.letscode.microservicoharrypotter.models.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlunoResponse {

    private Integer id;
    private String nome;
    private String serie;
    private String chaveDaCasaSeletora;
    private Casa casa;

    public AlunoResponse(Aluno aluno, Casa casa) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.serie = aluno.getSerie();
        this.chaveDaCasaSeletora = aluno.getChaveDaCasaSeletora();
        this.casa = casa;
    }
}
