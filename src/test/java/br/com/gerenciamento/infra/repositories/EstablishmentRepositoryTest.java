package br.com.gerenciamento.infra.repositories;

import br.com.gerenciamento.entities.establishment.Establishment;
import br.com.gerenciamento.dtos.EstablishmentDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class EstablishmentRepositoryTest {

    @Autowired
    EstablishmentRepository establishmentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Deve achar um estabelecimento por Documento")
    void findEstablishmentByDocumentCase1() {
        String document = "123456781";
        EstablishmentDTO dto = new EstablishmentDTO("Estabelecimento", document, "Ali mesmo", "(99)99999-9998", 10L, 10L);
        this.createEstablishment(dto);
        Optional<Establishment> result = this.establishmentRepository.findEstablishmentByDocument(document);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Deve não achar um estabelecimento por Documento")
    void findEstablishmentByDocumentCase2() {
        String document = "123456781";
        Optional<Establishment> result = this.establishmentRepository.findEstablishmentByDocument(document);

        assertThat(result.isEmpty()).isTrue();
    }

    private Establishment createEstablishment(EstablishmentDTO dto){
        Establishment establishment = new Establishment(dto);
        this.entityManager.persist(establishment);
        return establishment;
    }
}