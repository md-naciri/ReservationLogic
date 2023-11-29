package com.example.reservationv2.services;

import com.example.reservationv2.domains.Equipment;
import com.example.reservationv2.domains.ReservEquip;
import com.example.reservationv2.domains.Reservation;

import java.time.LocalDate;

public interface ReservEquipService {
    ReservEquip saveReserEquip(ReservEquip reservEquip);
    Equipment findById(Long id);
    Boolean isEquipmentAvailable(Long id, LocalDate start, LocalDate end);
}
