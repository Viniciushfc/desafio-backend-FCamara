package br.com.gerenciamento.domain.exitEntryControl;

import br.com.gerenciamento.domain.establishment.Establishment;
import br.com.gerenciamento.domain.vehicle.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    private Double price;
    @ManyToOne
    @NotNull(message = "Establishment is mandatory")
    private Establishment establishment;
    @ManyToOne
    @NotNull(message = "Vehicle is mandatory")
    private Vehicle vehicle;

}
