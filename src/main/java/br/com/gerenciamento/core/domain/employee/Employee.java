package br.com.gerenciamento.core.domain.employee;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity(name = "employees")
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {

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
    private String amountVacanciesBike;
    @NotNull
    private String amountVacanciesCar;


}
