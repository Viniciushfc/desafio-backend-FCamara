package br.com.gerenciamento.domain.vehicle;


import br.com.gerenciamento.dtos.VehicleDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @NotBlank(message = "brand is mandatory")
    private String brand;
    @NotBlank(message = "model is mandatory")
    private String model;
    @NotBlank(message = "color is mandatory")
    private String color;
    @NotBlank(message = "plate is mandatory")
    @Column(unique = true)
    private String plate;
    @NotNull(message = "Type Vehicle is mandatory")
    private TypeVehicle typeVehicle;

    public Vehicle(VehicleDTO dto){
        this.brand = dto.brand();
        this.model = dto.model();
        this.color = dto.color();
        this.plate = dto.plate();
        this.typeVehicle = dto.typeVehicle();
    };


}

