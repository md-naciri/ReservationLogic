package com.example.reservationv2.web.rest;

import com.example.reservationv2.domains.Equipment;
import com.example.reservationv2.domains.ReservEquip;
import com.example.reservationv2.domains.Reservation;
import com.example.reservationv2.dto.ReservationDTO;
import com.example.reservationv2.repositories.ReservEquipRepository;
import com.example.reservationv2.services.ReservEquipService;
import com.example.reservationv2.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservEquipService reservEquipService;
    private final ReservationService reservationService;
    private final ReservEquipRepository reservEquipRepository;

    @PostMapping
    public ResponseEntity<?> reservation(@RequestBody ReservationDTO reservationDTO){
        for (int i = 0; i < reservationDTO.getItemDTOList().size(); i++) {
            if (!checkDate(reservationDTO.getItemDTOList().get(i).getStart(), reservationDTO.getItemDTOList().get(i).getEnd())) return ResponseEntity.badRequest().body("9add les dates dialk a chrif");
            if (!checkAvailability(reservationDTO.getItemDTOList().get(i).getStart(),reservationDTO.getItemDTOList().get(i).getEnd(),reservationDTO.getItemDTOList().get(i).getEquipmentId())) return ResponseEntity.badRequest().body("Hadchi ya mreservi ya makaynch");
        }
        Reservation reserved = reservationService.saveReservation(Reservation.builder().status("Reserved").build());
        for (int i = 0; i < reservationDTO.getItemDTOList().size(); i++) {
            ReservEquip reservEquip = ReservEquip.builder()
                    .start(reservationDTO.getItemDTOList().get(i).getStart())
                    .end(reservationDTO.getItemDTOList().get(i).getEnd())
                    .reservation(reserved)
                    .equipment(Equipment.builder().id(reservationDTO.getItemDTOList().get(i).getEquipmentId()).build())
                    .build();
            reservEquipService.saveReserEquip(reservEquip);
        }


        return ResponseEntity.ok().body("Equipment Reserved Successfully");
    }
    public Boolean checkDate (LocalDate start, LocalDate end){
        if (start.isAfter(end) || start.isBefore(LocalDate.now())){
            return false;
        }
        return true;
    }
    public Boolean checkAvailability (LocalDate start, LocalDate end, Long equipmentId){
        if(reservEquipService.findById(equipmentId) == null) return false;
        if(reservEquipRepository.findReservEquipsByEquipment_Id(equipmentId).isEmpty()) return true;
        if(!reservEquipService.isEquipmentAvailable(equipmentId, start, end)) return false;
        return true;
    }

}
