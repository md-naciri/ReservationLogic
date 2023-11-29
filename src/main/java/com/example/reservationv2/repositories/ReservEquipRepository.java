package com.example.reservationv2.repositories;

import com.example.reservationv2.domains.Equipment;
import com.example.reservationv2.domains.ReservEquip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservEquipRepository extends JpaRepository<ReservEquip, Long> {
    /*@Query("SELECT Equipment FROM Equipment INNER JOIN ReservEquip ON Equipment.id = ReservEquip.equipment.id \n" +
            "WHERE ( (:start > ReservEquip.end AND :end < ReservEquip.start) AND Equipment.id = :id)")
    List<Equipment> checkAvailability(@Param("id") Long id, @Param("start") LocalDate start, @Param("end") LocalDate end);*/

    @Query("SELECT e FROM Equipment e INNER JOIN ReservEquip re ON e.id = re.equipment.id " +
            "WHERE (:start > re.end AND :end < re.start) AND e.id = :id")
    List<Equipment> checkAvailability(@Param("id") Long id, @Param("start") LocalDate start, @Param("end") LocalDate end);

    List<ReservEquip> findReservEquipsByEquipment_Id(Long id);

}
