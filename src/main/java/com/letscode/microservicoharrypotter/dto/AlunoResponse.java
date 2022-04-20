package com.letscode.microservicoharrypotter.dto;

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
}
