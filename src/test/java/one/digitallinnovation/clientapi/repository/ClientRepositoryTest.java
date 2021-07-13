package one.digitallinnovation.clientapi.repository;

import one.digitallinnovation.clientapi.entity.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for Client Repository")
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Save creates Client when Successful")
    void save_PersistClient_WhenSucessful () {
        Client clientToBeSaved = createClient();
        Client savedClient = this.clientRepository.save(clientToBeSaved);
        Assertions.assertThat(savedClient).isNotNull();
        Assertions.assertThat(savedClient.getId()).isNotNull();
        Assertions.assertThat(savedClient.getCorporateName()).isEqualTo(clientToBeSaved.getCorporateName());
        Assertions.assertThat(savedClient.getCnpj()).isEqualTo(clientToBeSaved.getCnpj());
        Assertions.assertThat(savedClient.getPhoneCorporate()).isEqualTo(clientToBeSaved.getPhoneCorporate());
        Assertions.assertThat(savedClient.getEmailCorporate()).isEqualTo(clientToBeSaved.getEmailCorporate());

    }

    private Client createClient() {
        return Client.builder()
                .cnpj("17.244.147/0001-81")
                .corporateName("MegaEmpresa")
                .phoneCorporate("99557845")
                .emailCorporate("megaempresa@gmail.com")
                .build();
    }
}