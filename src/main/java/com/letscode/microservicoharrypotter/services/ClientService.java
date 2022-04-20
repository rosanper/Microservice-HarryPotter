package com.letscode.microservicoharrypotter.services;

import com.letscode.microservicoharrypotter.dto.clients.Casa;
import com.letscode.microservicoharrypotter.dto.clients.Chave;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ClientService {

    static final String URL_OBTER_CHAVE = "https://api-harrypotter.herokuapp.com/sortinghat";
    static final String URL_OBTER_CASA = "https://api-harrypotter.herokuapp.com/house/{chavecasa}";

    public Chave getChave(){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Chave> chave =
                    restTemplate.getForEntity(URL_OBTER_CHAVE, Chave.class);
            return chave.getBody();
        }catch (RestClientException e){
            // Falta Ajustar a mensagem do erro
            throw new RestClientException(e.getMessage());
        }

    }

    public Casa getCasa(String chave){
        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Casa> casa =
                    restTemplate.exchange(URL_OBTER_CASA,
                    HttpMethod.GET,
                    httpEntity,
                    Casa.class,
                    chave);
            return casa.getBody();
        }catch (RestClientException e){
            // Falta Ajustar a mensagem do erro
            throw new RestClientException(e.getMessage());
        }
    }

}
