package com.example.reservationv2.services.Imp;

import com.example.reservationv2.domains.Equipment;
import com.example.reservationv2.domains.ReservEquip;
import com.example.reservationv2.repositories.EquipmentRepository;
import com.example.reservationv2.repositories.ReservEquipRepository;
import com.example.reservationv2.services.ReservEquipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservEquipServiceImp implements ReservEquipService {
    private final ReservEquipRepository reservEquipRepository;
    private final EquipmentRepository equipmentRepository;
    @Override
    public ReservEquip saveReserEquip(ReservEquip reservEquip) {
        return reservEquipRepository.save(reservEquip);
    }

    @Override
    public Equipment findById(Long id) {
        Optional<Equipment> byId = equipmentRepository.findById(id);
        if(byId.isPresent()) return byId.get();
        return null;
    }

    @Override
    public Boolean isEquipmentAvailable(Long id, LocalDate start, LocalDate end) {
        List<Equipment> equipment = reservEquipRepository.checkAvailability(id, start, end);
        if(equipment.isEmpty()) return false;
        return true;
    }



}
