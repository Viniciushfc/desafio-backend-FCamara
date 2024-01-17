package br.com.gerenciamento.domain.exitEntryControl;

import br.com.gerenciamento.dtos.ExitEntryControlDTO;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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
    @NotNull
    private LocalDateTime entry;
    @Column(nullable = true)
    private LocalDateTime exit;
    @NotNull
    private String plate;
    @NotNull
    private String document;

    public ExitEntryControl(ExitEntryControlDTO dto) {
        this.entry = dto.entry();
        this.exit = dto.exit();
        this.plate = dto.plate();
        this.document = dto.document();
    }
}
