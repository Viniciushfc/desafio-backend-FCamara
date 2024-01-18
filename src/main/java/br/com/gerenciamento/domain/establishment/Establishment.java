package br.com.gerenciamento.domain.establishment;


import br.com.gerenciamento.dtos.EstablishmentDTO;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


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
    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String document;
    @NotNull
    private String address;
    @NotNull
    private String telephone;
    @NotNull
    private Long amountVacanciesBike;
    @NotNull
    private Long amountVacanciesCar;


    public Establishment(EstablishmentDTO dto){
        this.name = dto.name();
        this.document = dto.document();
        this.address = dto.address();
        this.telephone = dto.telephone();
        this.amountVacanciesBike = dto.amountVacanciesBike();
        this.amountVacanciesCar = dto.amountVacanciesCar();
    };
}