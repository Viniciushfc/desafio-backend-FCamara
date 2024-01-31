package br.com.gerenciamento.domain.establishment;


import br.com.gerenciamento.dtos.EstablishmentDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity(name = "establishments")
@Table(name = "establishments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Document is mandatory")
    @Column(unique = true)
    private String document;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Telephone is mandatory")
    private String telephone;
    @NotNull(message = "Vacancies Bike is mandatory")
    private Integer amountVacanciesBike;
    @NotNull(message = "Vacancies Car is mandatory")
    private Integer amountVacanciesCar;


    public Establishment(EstablishmentDTO dto){
        this.name = dto.name();
        this.document = dto.document();
        this.address = dto.address();
        this.telephone = dto.telephone();
        this.amountVacanciesBike = dto.amountVacanciesBike();
        this.amountVacanciesCar = dto.amountVacanciesCar();
    };
}