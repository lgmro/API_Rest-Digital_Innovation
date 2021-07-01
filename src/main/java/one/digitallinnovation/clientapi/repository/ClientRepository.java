package one.digitallinnovation.clientapi.repository;

import one.digitallinnovation.clientapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
