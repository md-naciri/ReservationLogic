package com.example.reservationv2.services;

import com.example.reservationv2.domains.ReservEquip;
import com.example.reservationv2.domains.Reservation;

import java.util.List;

/*Devis addDevis(Devis devis);
        List<Devis> getListDevis();
        Devis updateDevis(Devis devis);
        void deleteDevis(Long id);
        Optional<Devis> findDevis(Long id);*/
public interface ReservationEquipService {
    Reservation saveReservation(Reservation reservation);
}
