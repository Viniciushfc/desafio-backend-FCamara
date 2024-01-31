package br.com.gerenciamento.entities.exitEntryControl;

import br.com.gerenciamento.entities.establishment.Establishment;
import br.com.gerenciamento.entities.vehicle.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Esta classe representa o controle de entrada e saída de veículos em um estabelecimento.
 *
 * <p>
 * O controle de entrada e saída registra a entrada e a saída de veículos, incluindo informações
 * como a data e hora de entrada, a data e hora de saída, o preço cobrado pelo serviço, o estabelecimento
 * onde o veículo entrou/saiu e o próprio veículo.
 * </p>
 *
 * <p>
 * A classe é mapeada para a tabela "control" no banco de dados e possui anotações JPA
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
@Entity(name = "control")
@Table(name = "control")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ExitEntryControl {

    /**
     * Identificador único do registro de controle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Data e hora de entrada do veículo no estabelecimento.
     */
    private LocalDateTime entry;

    /**
     * Data e hora de saída do veículo do estabelecimento.
     */
    @Column(nullable = true)
    private LocalDateTime exit;

    /**
     * Preço cobrado pelo serviço de entrada/saída do veículo.
     */
    @Column(nullable = true)
    private Double price;

    /**
     * Estabelecimento onde o veículo entrou/saiu.
     */
    @ManyToOne
    @NotNull(message = "Establishment is mandatory")
    private Establishment establishment;

    /**
     * Veículo que entrou/saiu do estabelecimento.
     */
    @ManyToOne
    @NotNull(message = "Vehicle is mandatory")
    private Vehicle vehicle;

}
