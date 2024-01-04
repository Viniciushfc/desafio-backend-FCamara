package br.com.gerenciamento.core.entity.vehicle;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity(name = "vehicles")
@Table(name = "vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String color;
    @NotNull
    @Column(unique = true)
    private String plate;
    @NotNull
    private TypeVehicle typeVehicle;
}

