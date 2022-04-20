package com.letscode.microservicoharrypotter.dto;

import com.letscode.microservicoharrypotter.models.Series;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlunoRequest {
    private String name;
    private Series serie;
}
