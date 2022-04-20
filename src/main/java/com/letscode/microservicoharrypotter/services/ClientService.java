package com.letscode.microservicoharrypotter.services;

import com.letscode.microservicoharrypotter.dto.clients.Casa;
import com.letscode.microservicoharrypotter.dto.clients.Chave;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    public Chave getChave(){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Chave> chave =
                    restTemplate.getForEntity("https://api-harrypotter.herokuapp.com/sortinghat", Chave.class);

            if (chave.getStatusCode().isError()){
                // TODO tratar exception
                return null;
            }
            return chave.getBody();
        }catch (RestClientException e){
            // TODO tratar exception
        }

        return null;
    }

    public Casa getCasa(String chave){
        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Casa> casa =
                    restTemplate.exchange("https://api-harrypotter.herokuapp.com/house/{chavecasa}",
                    HttpMethod.GET,
                    httpEntity,
                    Casa.class,
                    chave);
            if (casa.getStatusCode().isError()){
                // TODO tratar exception
                return null;
            }
            return casa.getBody();
        }catch (RestClientException e){
            // TODO tratar exception
        }
        return null;
    }

}
