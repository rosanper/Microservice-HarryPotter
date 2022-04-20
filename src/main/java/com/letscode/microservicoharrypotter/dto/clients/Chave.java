package com.letscode.microservicoharrypotter.dto.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chave {

    @JsonProperty("sorting-hat-choice")
    private String sortingHatChoice;
}
