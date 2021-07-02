package one.digitallinnovation.clientapi.controller;

import one.digitallinnovation.clientapi.dto.response.MessageResponseDTO;
import one.digitallinnovation.clientapi.entity.Client;
import one.digitallinnovation.clientapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody Client client) {

        return clientService.createClient(client);
    }

    @GetMapping
    public List<Client> listAll(){
       return clientService.listAll();
    }

}
