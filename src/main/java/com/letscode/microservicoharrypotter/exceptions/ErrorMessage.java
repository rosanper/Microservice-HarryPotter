package com.letscode.microservicoharrypotter.exceptions;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessage {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;

}
