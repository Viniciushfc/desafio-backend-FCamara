package br.com.gerenciamento.services;

import br.com.gerenciamento.core.domain.Establishment.Establishment;
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
        return repository.findAll();
    }

    //Procurar estabelecimento por ID.
    public Establishment findEstablishmentById(Long id) {
        return repository.findEstablishmentById(id).orElse(null);
    }

    //Procurar estabelecimento por CNPJ.
    public Establishment findEstablishmentById(String document) {
        return repository.findEstablishmentByDocument(document).orElse(null);
    }

    //Deletar um estabelecimento por ID.
    public void deleteEstablishmentById(Long id) {
        this.repository.deleteById(id);
    }


    //Deletar um estabelecimento por CNPJ.
    public void deleteEstablishmentByDocument(String document) {

        Optional<Establishment> optionalEstablishment = repository.findEstablishmentByDocument(document);

        if (optionalEstablishment.isPresent()) {

            Establishment establishment = optionalEstablishment.get();

            repository.delete(establishment);

        }
    }

}
