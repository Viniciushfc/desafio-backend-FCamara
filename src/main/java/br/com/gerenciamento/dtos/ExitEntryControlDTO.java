package br.com.gerenciamento.dtos;

import java.time.LocalDateTime;

public record ExitEntryControlDTO(LocalDateTime entry, LocalDateTime exit, String plate, String document) {
}
