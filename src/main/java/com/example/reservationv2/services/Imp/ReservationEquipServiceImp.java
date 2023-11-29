package com.example.reservationv2.services.Imp;

import com.example.reservationv2.domains.Reservation;
import com.example.reservationv2.repositories.ReservationRepository;
import com.example.reservationv2.services.ReservationEquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationEquipServiceImp implements ReservationEquipService {
    private final ReservationRepository reservationRepository;
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
