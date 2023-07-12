package com.example.Ep4GonzalesPaz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_visitas", uniqueConstraints =  @UniqueConstraint(columnNames = "dni"))
public class Visitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 150)

    private String local;
    @Column(length = 8)

    String dni;

    @Column(name = "FechaDeCreacion")
    Date fecha;

    @Column(name = "HoraDeCreacion")
    private Time hora;

    @PrePersist
    public void prePersist(){
        fecha = new Date();
        hora = new Time(System.currentTimeMillis());
    }
}

