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
        }
        return null;
    }

    //Procurar estabelecimento por CNPJ.
    public Establishment findEstablishmentByDocument(String document) {
        try {
            Optional<Establishment> optionalEstablishment = repository.findEstablishmentByDocument(document);

            if (optionalEstablishment.isPresent()) {
                Establishment establishment = optionalEstablishment.get();

                System.out.println(establishment);

                return establishment;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }




    //Atualizar um estabelecimento.
    public Establishment updateEstablishment(EstablishmentDTO dto) {
        try {
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
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //Deletar um estabelecimento por ID.
    public Establishment deleteEstablishmentById(Long id) {
        try {
            if (repository.existsById(id)) {
                this.repository.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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
