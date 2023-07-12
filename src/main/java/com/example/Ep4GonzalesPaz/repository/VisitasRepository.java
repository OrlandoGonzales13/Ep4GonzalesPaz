package com.example.Ep4GonzalesPaz.repository;

import com.example.Ep4GonzalesPaz.entity.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitasRepository extends JpaRepository<Visitas,Long> {

}
