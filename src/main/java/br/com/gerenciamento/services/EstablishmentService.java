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
        try {
            this.repository.save(establishment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Criar um estabelecimento.
    public Establishment createEstablishment(EstablishmentDTO dto) {
        try {
            Establishment establishmentNew = new Establishment(dto);
            this.saveEstablishment(establishmentNew);
            return establishmentNew;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Listar todos os estabelecimento.
    public List<Establishment> getAllEstablishment() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Procurar estabelecimento por ID.
    public Establishment findEstablishmentById(Long id) {
        try {
            return repository.findEstablishmentById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Procurar estabelecimento por CNPJ.
    public Establishment findEstablishmentByDocument(String document) {
        try {
            return repository.findEstablishmentByDocument(document).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //Update
    //Atualizar um estabelecimento.
    public Establishment updateEstablishment(EstablishmentDTO dto) {
        try {
            Optional<Establishment> optionalEstablishment = repository.findEstablishmentByDocument(dto.document());

            if (optionalEstablishment.isPresent()) {
                Establishment establishment = optionalEstablishment.get();

                establishment.setName(dto.name());
                establishment.setName(dto.document());
                establishment.setName(dto.address());
                establishment.setName(dto.telephone());
                establishment.setName(dto.amountVacanciesBike());
                establishment.setName(dto.amountVacanciesCar());

                return repository.save(establishment);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //Deletar um estabelecimento por ID.
    public void deleteEstablishmentById(Long id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Deletar um estabelecimento por CNPJ.
    public void deleteEstablishmentByDocument(String document) {
        try {
            Optional<Establishment> optionalEstablishment = repository.findEstablishmentByDocument(document);

            if (optionalEstablishment.isPresent()) {

                Establishment establishment = optionalEstablishment.get();

                repository.delete(establishment);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
