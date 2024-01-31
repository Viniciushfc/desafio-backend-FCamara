package br.com.gerenciamento.entities.establishment;


import br.com.gerenciamento.dtos.EstablishmentDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
/**
 * Esta classe representa um estabelecimento.
 *
 * <p>
 * Um estabelecimento possui um identificador único (ID), nome, documento, endereço, telefone,
 * número de vagas para bicicletas e número de vagas para carros.
 * </p>
 *
 * <p>
 * A classe é mapeada para a tabela "establishments" no banco de dados e possui anotações JPA
 * para definir detalhes como o nome da tabela, as restrições de chave primária e os mapeamentos
 * de colunas.
 * </p>
 *
 * <p>
 * Além disso, a classe possui construtores, getters e setters para manipulação dos seus atributos.
 * </p>
 *
 * @author ViniciusHFC
 */
@Entity(name = "establishments")
@Table(name = "establishments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Establishment {

    /**
     * Identificador único do estabelecimento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do estabelecimento.
     */
    @NotBlank(message = "Name is mandatory")
    private String name;

    /**
     * Documento do estabelecimento (por exemplo, CNPJ).
     */
    @NotBlank(message = "Document is mandatory")
    @Column(unique = true)
    private String document;

    /**
     * Endereço do estabelecimento.
     */
    @NotBlank(message = "Address is mandatory")
    private String address;

    /**
     * Telefone do estabelecimento.
     */
    @NotBlank(message = "Telephone is mandatory")
    private String telephone;

    /**
     * Número de vagas para bicicletas no estabelecimento.
     */
    @NotNull(message = "Vacancies Bike is mandatory")
    private Integer amountVacanciesBike;

    /**
     * Número de vagas para carros no estabelecimento.
     */
    @NotNull(message = "Vacancies Car is mandatory")
    private Integer amountVacanciesCar;

    /**
     * Construtor que recebe um objeto EstablishmentDTO para facilitar a conversão.
     *
     * dto O objeto EstablishmentDTO a ser convertido em Establishment.
     */
    public Establishment(EstablishmentDTO dto) {
        this.name = dto.name();
        this.document = dto.document();
        this.address = dto.address();
        this.telephone = dto.telephone();
        this.amountVacanciesBike = dto.amountVacanciesBike();
        this.amountVacanciesCar = dto.amountVacanciesCar();
    }
}