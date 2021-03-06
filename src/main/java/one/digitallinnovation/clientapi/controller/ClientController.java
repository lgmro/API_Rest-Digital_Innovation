package one.digitallinnovation.clientapi.controller;

import lombok.AllArgsConstructor;
import one.digitallinnovation.clientapi.dto.response.MessageResponseDTO;
import one.digitallinnovation.clientapi.entity.Client;
import one.digitallinnovation.clientapi.exception.ClientNotFoundException;
import one.digitallinnovation.clientapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody Client client) {

        return clientService.createClient(client);
    }

    @GetMapping
    public List<Client> listAll(){
       return clientService.listAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws ClientNotFoundException {
        return clientService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById (@PathVariable Long id, @RequestBody Client client) throws ClientNotFoundException {
        return clientService.updateById(id, client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientNotFoundException {
        clientService.delete(id);
    }

}
