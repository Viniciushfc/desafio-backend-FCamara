package br.com.gerenciamento.services;

import br.com.gerenciamento.domain.establishment.Establishment;
import br.com.gerenciamento.dtos.EstablishmentDTO;
import br.com.gerenciamento.repositories.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository repository;

    //Salvar no Banco de Dados.
    public void saveEstablishment(Establishment establishment) {
        this.repository.save(establishment);
    }

    //Criar um estabelecimento.
    public Establishment createEstablishment(EstablishmentDTO dto) {
        Establishment establishmentNew = new Establishment(dto);
        this.saveEstablishment(establishmentNew);
        return establishmentNew;
    }

    //Listar todos os estabelecimento.
    public List<Establishment> getAllEstablishment() {
        return this.repository.findAll();
    }

    //Procurar estabelecimento por ID.
    public Establishment findEstablishmentById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado!"));
    }

    //Procurar estabelecimento por Document.
    public Establishment findEstablishmentByDocument(String document) {
        Optional<Establishment> optionalEstablishment = repository.findEstablishmentByDocument(document);

        if (optionalEstablishment.isPresent()) {
            Establishment establishment = optionalEstablishment.get();

            return establishment;
        }
        return null;
    }

    //Atualizar um estabelecimento.
    public Establishment updateEstablishment(EstablishmentDTO dto) {
        Optional<Establishment> optionalEstablishment = repository.findEstablishmentByDocument(dto.document());

        if (optionalEstablishment.isPresent()) {
            Establishment establishment = optionalEstablishment.get();

            establishment.setName(dto.name());
            establishment.setDocument(dto.document());
            establishment.setAddress(dto.address());
            establishment.setTelephone(dto.telephone());
            establishment.setAmountVacanciesBike(dto.amountVacanciesBike());
            establishment.setAmountVacanciesCar(dto.amountVacanciesCar());

            return repository.save(establishment);
        }
        return null;

    }

    //Deletar um estabelecimento por ID.
    public Establishment deleteEstablishmentById(Long id) {
            if (repository.existsById(id)) {
                this.repository.deleteById(id);
            }
        return null;
    }

    //Deletar um estbelecimento por Document.
    public Establishment deleteEstablishmentByDocument(String document) {
            Optional<Establishment> optionalEstablishment = repository.findEstablishmentByDocument(document);

            if (optionalEstablishment.isPresent()) {

                Establishment establishment = optionalEstablishment.get();

                repository.delete(establishment);

            }
        return null;
    }

}
