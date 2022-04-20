package com.letscode.microservicoharrypotter.models;

import lombok.Getter;

@Getter
public enum Series {
    PRIMEIRA("Primeira"),
    SEGUNDA("Segunda"),
    TERCEIRA("Terceira"),
    QUARTA("Quarta");

    public String nome;

    Series(String nome) {
        this.nome = nome;
    }
}
