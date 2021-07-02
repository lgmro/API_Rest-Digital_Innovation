package one.digitallinnovation.clientapi.service;

import one.digitallinnovation.clientapi.dto.response.MessageResponseDTO;
import one.digitallinnovation.clientapi.entity.Client;
import one.digitallinnovation.clientapi.exception.ClientNotFoundException;
import one.digitallinnovation.clientapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientService {

    private ClientRepository clientRepository;



    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public MessageResponseDTO createClient(Client client) {

        Client savedClient = clientRepository.save(client);
        return createMessageResponse(savedClient.getId(), "Created client with ID ");
    }

    public List<Client> listAll() {
       List<Client> allClient = clientRepository.findAll();

        return allClient;
    }

    public Client findById(Long id) throws ClientNotFoundException {
        Client client = verifyIfExists(id);

        return client;
    }

    public void delete(Long id) throws ClientNotFoundException {
        verifyIfExists(id);
        clientRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, Client client) throws ClientNotFoundException {
        verifyIfExists(id);

        Client updateClient = clientRepository.save(client);

        return createMessageResponse(updateClient.getId(), "Updated client with ID ");

    }

    private Client verifyIfExists(Long id) throws ClientNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));


    }

    private MessageResponseDTO createMessageResponse (Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
