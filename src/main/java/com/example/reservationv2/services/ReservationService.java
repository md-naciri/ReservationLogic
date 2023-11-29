package com.example.reservationv2.services;

import com.example.reservationv2.domains.Reservation;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
}
