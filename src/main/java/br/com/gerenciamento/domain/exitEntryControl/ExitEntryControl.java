package br.com.gerenciamento.domain.exitEntryControl;

import br.com.gerenciamento.domain.establishment.Establishment;
import br.com.gerenciamento.domain.vehicle.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "control")
@Table(name = "control")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ExitEntryControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime entry;
    @Column(nullable = true)
    private LocalDateTime exit;
    @Column(nullable = true)
    @NotBlank(message = "Price is mandatory")
    private Double price;
    @ManyToOne
    @NotBlank(message = "Establishment is mandatory")
    private Establishment establishment;
    @ManyToOne
    @NotBlank(message = "Vehicle is mandatory")
    private Vehicle vehicle;
}
