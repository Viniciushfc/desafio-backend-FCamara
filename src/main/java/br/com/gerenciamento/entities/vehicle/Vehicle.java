package br.com.gerenciamento.entities.vehicle;


import br.com.gerenciamento.dtos.VehicleDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Esta classe representa um veículo.
 *
 * <p>
 * Um veículo possui um identificador único (ID), marca, modelo, cor, placa e tipo de veículo.
 * </p>
 *
 * <p>
 * A classe é mapeada para a tabela "vehicles" no banco de dados e possui anotações JPA
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
@Entity(name = "vehicles")
@Table(name = "vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vehicle {

    /**
     * Identificador único do veículo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Marca do veículo.
     */
    @NotBlank(message = "brand is mandatory")
    private String brand;

    /**
     * Modelo do veículo.
     */
    @NotBlank(message = "model is mandatory")
    private String model;

    /**
     * Cor do veículo.
     */
    @NotBlank(message = "color is mandatory")
    private String color;

    /**
     * Placa do veículo.
     */
    @NotBlank(message = "plate is mandatory")
    @Column(unique = true)
    private String plate;

    /**
     * Tipo de veículo.
     */
    @NotNull(message = "Type Vehicle is mandatory")
    private TypeVehicle typeVehicle;

    /**
     * Construtor que recebe um objeto VehicleDTO para facilitar a conversão.
     *
     * dto O objeto VehicleDTO a ser convertido em Vehicle.
     */
    public Vehicle(VehicleDTO dto) {
        this.brand = dto.brand();
        this.model = dto.model();
        this.color = dto.color();
        this.plate = dto.plate();
        this.typeVehicle = dto.typeVehicle();
    }
}

