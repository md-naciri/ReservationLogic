package com.example.reservationv2.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Long equipmentId;
    private LocalDate start;
    private LocalDate end;

}
