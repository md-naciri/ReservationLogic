package com.example.reservationv2.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private List<ItemDTO> itemDTOList;
}
